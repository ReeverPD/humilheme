/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.util;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author iuriandreazza
 */
public abstract class AbstractController {

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
    
    
}
