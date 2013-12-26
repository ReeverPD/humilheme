package com.reever.humilheme.service.Imp;

import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.FacebookLoginException;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.service.IUserService;
import com.reever.humilheme.to.UserTO;
import com.reever.humilheme.util.UrlMapping;
import com.reever.humilheme.web.CookieController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Control User's login with facebook and register then automaticly
 * 
 * 
 * @author iuriandreazza
 */
@Service
public class UserFaceService implements IUserFaceService{
    
    public static final String CHAVE_SESSION = "humilhe.me.user";
	private static final Logger _logger = LoggerFactory.getLogger(UserFaceService.class);
    
    @Getter
    private final String clientID = "363836663737073";
    private final String secretID = "39f536d4a514437615fcd3d5d2f3f81a";
    
    private FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(clientID, secretID);
    
    @Autowired
    private CookieController cookieLoginFace;
    
    @Autowired
    private IUserService userService;
    
    @Override
	public String getChaveSession() {
		return CHAVE_SESSION;
	}
    
    /**
     * Retorna um Profile do Facebook atraves da API
     * 
     * @param profileId
     * @return 
     */
    @Override
    public FacebookProfile getFacebookProfile(Long profileId){
        return this.getFacebookConnection().getApi().fetchObject(profileId.toString(), FacebookProfile.class);
    }
    
    /**
     * Autentica o usuario no facebook se caso não tenha autorização
     * ejeta um FacebookLoginException com a URL que deve ser redirecionado para
     * a autorizacao.
     * 
     * 
     * @param code
     * @param redirectUrl
     * @param request
     * @param response
     * @return
     * @throws FacebookLoginException 
     */
    @Transactional
    @Override
	public boolean autenticarUsuarioFaceBook(String code, String redirectUrl, HttpServletRequest request, HttpServletResponse response) throws FacebookLoginException {
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(redirectUrl);
        
        String cookieCode = cookieLoginFace.getCookie(request);
        if(StringUtils.isEmpty(code)){
            String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);
            throw new FacebookLoginException(authorizeUrl);
        }else{
            // upon receiving the callback from the provider:
            AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, redirectUrl, null);
            Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
            cookieLoginFace.createCookie(request, response, code);
            UserProfile userProfileFace = connection.fetchUserProfile();
            UserTO userTO = new UserTO();
            //Valida se o usuário que está no processo de login do facebook
            //não existe na base, se o mesmo for novo registra ele.
            if(!userService.existsUser(userProfileFace.getUsername())){
                //Gravar o usuario novo
                User us = new User();
                us.setEmail(userProfileFace.getEmail());
                us.setProfileLink(connection.getProfileUrl());
                us.setProfileName(connection.getDisplayName());
                us.setProfilePicture(connection.getImageUrl());
                us.setTokenAuth(connection.getKey().getProviderId());
                us.setUserName(userProfileFace.getUsername());
                us.setProfileId(connection.getApi().userOperations().getUserProfile().getId());
                userService.save(us);
            }

            User usr = userService.getByUserName(userProfileFace.getUsername());
            userTO.setIdUser(usr.getId());
            userTO.setUsername(usr.getUserName());
            userTO.setCode(code);
            this.setUserFaceSession(userTO);
            this.setAccessGrantSession(accessGrant);
            return true;
        }
   	}
    
    /**
     * Retorna o Usuario Autenticado
     * 
     * @return 
     */
    @Override
    public UserTO getAuthUser(){
        UserTO user = (UserTO) RequestContextHolder.currentRequestAttributes().getAttribute(this.getChaveSession(), RequestAttributes.SCOPE_SESSION);
        return user;
    }
    
    /**
     * Retorna a conexao com a API do Facebook
     * 
     * @return 
     */
    @Override
    public Connection<Facebook> getFacebookConnection(){
        return connectionFactory.createConnection(this.getAccessGrant());
    }
    
    /* PRIVATE METHODS */
    private AccessGrant getAccessGrant(){
        return (AccessGrant)RequestContextHolder.currentRequestAttributes().getAttribute(this.getChaveSession()+".GRANT", RequestAttributes.SCOPE_SESSION);
    }
    
    private void setAccessGrantSession(AccessGrant access){
        RequestContextHolder.currentRequestAttributes().setAttribute(this.getChaveSession()+".GRANT", access, RequestAttributes.SCOPE_SESSION);
    }
    
    private void setUserFaceSession(UserTO user){
        RequestContextHolder.currentRequestAttributes().setAttribute(this.getChaveSession(), user, RequestAttributes.SCOPE_SESSION);
    }

    @Override
    public FacebookProfile getMe() {
        return this.getFacebookConnection().getApi().userOperations().getUserProfile();    
    }
}