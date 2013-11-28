package com.reever.humilheme.controller;

import com.reever.humilheme.exception.FacebookLoginException;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.UrlMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iuriandreazza
 */
@Controller
public class HomeController extends AbstractController {

    
    @Autowired
    private IUserFaceService userService;
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.HOME, UrlMapping.ROOT })
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        return new ModelAndView("welcome");
    }
    
    /* FACEBOOK */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.LOGIN_FACEBOOK })
    public ModelAndView loginFacebook(@RequestParam(required = false) String code,HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String callURL = "http://localhost:8080/com.reever.humilheme"+UrlMapping.LOGIN_FACEBOOK;
        try{
            userService.autenticarUsuarioFaceBook(code, callURL, request, response);
            if(userService.getAuthUser() != null){
                return new ModelAndView("redirect:"+UrlMapping.CONVIDAR_AMIGO);
            }else{
                return new ModelAndView("redirect:"+UrlMapping.HOME);
            }
        }catch(FacebookLoginException ex){
            return new ModelAndView("redirect:"+ex.getLoginUrl());
        }
        
        /*
            FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory("363836663737073", "39f536d4a514437615fcd3d5d2f3f81a");
            OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
            OAuth2Parameters params = new OAuth2Parameters();
            params.setRedirectUri(callURL);
            if(StringUtils.isEmpty(code)){
                String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);
                return new ModelAndView("redirect:"+authorizeUrl);
            }else{
                // upon receiving the callback from the provider:
                AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, callURL, null);
                Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);

                return new ModelAndView("redirect:"+UrlMapping.CONVIDAR_AMIGO);
            }
        */
        
    }
    
    /* SEM PAGINAS */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.CONTATO })
    public String contato(HttpServletRequest request, ModelMap model) {
        return "contato";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.POLITICA_PRIVACIDADE })
    public String politicaPrivacidade(HttpServletRequest request, ModelMap model) {
        return "politica";
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.TERMOS_UTILIZACAO })
    public String TermosUtilizacao(HttpServletRequest request, ModelMap model) {
        return "termosUtilizacao";
    }

}
