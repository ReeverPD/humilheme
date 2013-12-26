package com.reever.humilheme.controller;

import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.entity.Xingamento;
import com.reever.humilheme.exception.UserException;
import com.reever.humilheme.service.IHumilharService;
import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.UrlMapping;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iuriandreazza
 */
@Controller
public class HumiliarController extends AbstractController {
    
    @Autowired
    private IHumilharService humilharService;
    
    /*
     * BATTLE MODE
     */
    
    /**
     * GET app/Batalhar/{profileA}/{profileB}/{requestID}
     * 
     * 
     * @param profileA
     * @param profileB
     * @param requestId
     * @param request
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.BATALHAR_AMIGO })
    public ModelAndView handleBattleMode(
            @PathVariable final String profileA,
            @PathVariable final String profileB,
            @PathVariable final Long requestId,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        
        //Verificar se existe a batalha com o ID especificado
        if(!this.humilharService.existeBattle(requestId)){
            return new ModelAndView("redirect:"+UrlMapping.HOME);
        }
         
        Solicitacao sol = this.humilharService.getSolicitacaoByRequestId(requestId);
        User usrA = sol.getUsuarioRequisitor();
        User usrB = null;
        FacebookProfile pB = null;
        
        try{
            usrB = this.userLocalService.findByProfileId(sol.getFriendFaceId());    
        }catch(UserException ex){
            pB = this.userService.getFacebookProfile(sol.getFriendFaceId());
            usrB = new User();
            usrB.setProfileId(sol.getFriendFaceId().toString());
            usrB.setProfileName(pB.getName());
        }
        
        if(this.getCurrUser().getProfileId().equals(usrA.getProfileId()) || this.getCurrUser().getProfileId().equals(usrB.getProfileId())){
            model.addAttribute("showXingamentoBox", true);
        }else{
            model.addAttribute("showXingamentoBox", false);
        }
        
        model.addAttribute("userA", usrA);
        model.addAttribute("userB", usrB);
        
        
        //Carregar Lista de Xingamentos
        List<Xingamento> lstBattle = this.humilharService.getBattle(requestId);
        model.addAttribute("lstBattle", lstBattle);
        
        //TODO: Fazer processo de voto para cada xingamento
        
        return new ModelAndView("battle");
    }
    
    @RequestMapping(method = RequestMethod.POST, value = { UrlMapping.BATALHAR_AMIGO_POST })
    public ModelAndView handlePostBattleMode(
            @PathVariable final Long requestId,
            @RequestParam final String message,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        
        Solicitacao sol = this.humilharService.getSolicitacaoByRequestId(requestId);
        String profileId = sol.getUsuarioRequisitor().getProfileId();
        String profileUrl = sol.getUsuarioRequisitor().getProfileLink();
        if(this.getCurrUser().getProfileId().equals(sol.getFriendFaceId().toString())){
            profileId = sol.getFriendFaceId().toString();
            profileUrl = this.userService.getFacebookProfile(sol.getFriendFaceId()).getLink();
        }
        MultiValueMap<String, Object> data =  new LinkedMultiValueMap<>();
        data.add("profile", profileUrl);
        data.add("", "");
        
        this.userService.getFacebookConnection().getApi().publish(profileId, "hTeste", data);
        
        return new ModelAndView("battle");
    }
    
    /*
     * HUMILHACAO SOLO  
     */
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.HUMILHAR_AMIGO })
    public ModelAndView handleHumilharMode(
            
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        return new ModelAndView("humilhar");
    }
    
}
