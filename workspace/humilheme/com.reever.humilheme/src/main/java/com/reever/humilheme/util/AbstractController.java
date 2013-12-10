/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.util;

import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.service.IUserService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iuriandreazza
 */
public abstract class AbstractController {

    @Autowired
    protected IUserFaceService userService;
    
    @Autowired
    protected IUserService userLocalService;
    
    
    @Getter
    private Logger logger = LoggerFactory.getLogger(AbstractController.class);
    
    /**
     * 
     * Build URL Pattern with profile
     * 
     * @param url
     * @param profileA
     * @param profileB
     * @return 
     */
    protected String buildURLProfile(String url, String profileA, String profileB){
        return url.replace("{profileA}", profileA).replace("{profileB}", profileB);
    }
    
    /**
     * Constroi a URL de invite do facebook sempre que gerar uma requisição de
     * JOIN
     * 
     * @param friendName
     * @param urlRetorno
     * @param sol
     * @param friendId
     * @return 
     */
    protected String getFacebookInviteUrl(final String friendName, String urlRetorno, Solicitacao sol, final String friendId) {
        
        String fbURL = "https://www.facebook.com/dialog/apprequests?" +
                "app_id="+ userService.getClientID() +
                "&title=Você tem coragem?" +
                "&message=" + "Peça para " + friendName + " tentar criar uma humilhãção melhor que a sua!"  +
                "&redirect_uri=http://localhost:8080/com.reever.humilheme"+urlRetorno + "?s=" + sol.getId() +
                "&max_recipients=1&to="+friendId;
        logger.info(">> requisitou invite: "+fbURL);
        return fbURL;
    }
    
    protected User getCurrUser(){
        if(this.userService.getAuthUser() != null){
            return this.userLocalService.getById(this.userService.getAuthUser().getIdUser());
        }
        return null;
    }
    
    
}
