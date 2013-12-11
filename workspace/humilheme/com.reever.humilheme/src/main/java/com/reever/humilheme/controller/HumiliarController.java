package com.reever.humilheme.controller;

import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.service.IHumilharService;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.UrlMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iuriandreazza
 */
@Controller
public class HumiliarController extends AbstractController {
    
    @Autowired
    private IHumilharService humilharService;
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.BATALHAR_AMIGO })
    public ModelAndView handleBattleMode(
            @PathVariable final String profileA,
            @PathVariable final String profileB,
            @PathVariable final Long requestId,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        
        Solicitacao sol = this.humilharService.getSolicitacaoByRequestId(requestId);
        FacebookProfile pA = this.userService.getFacebookProfile(sol.getFriendFaceId());
        
        if(!this.humilharService.existeBattle(requestId)){
            
        }
        
        return new ModelAndView("battle");
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.HUMILHAR_AMIGO })
    public ModelAndView handleHumilharMode(
            
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        return new ModelAndView("humilhar");
    }
    
}
