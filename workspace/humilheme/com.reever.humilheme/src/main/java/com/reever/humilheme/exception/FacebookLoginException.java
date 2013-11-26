/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author iuriandreazza
 */
public class FacebookLoginException extends Exception {
    
    @Getter @Setter
    private String loginUrl;
    
    public FacebookLoginException(String loginUrl){
        this.setLoginUrl(loginUrl);
    }
    
}
