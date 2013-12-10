/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.service;

import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.FacebookLoginException;
import com.reever.humilheme.to.UserTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;

/**
 *
 * @author iuriandreazza
 */
public interface IUserFaceService {
 
    FacebookProfile getMe();
    String getClientID();
    Connection<Facebook> getFacebookConnection();
    UserTO getAuthUser();
    String getChaveSession();
    boolean autenticarUsuarioFaceBook(String code, String redirectUrl, HttpServletRequest request, HttpServletResponse response) throws FacebookLoginException;

    
}
