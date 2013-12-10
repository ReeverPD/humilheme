package com.reever.humilheme.controller;

import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.service.IHumilharService;
import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.EscapeChars;
import com.reever.humilheme.util.UrlMapping;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class ConvidarController extends AbstractController {

    @Autowired
    private IHumilharService humilharService;
    
    
    /**
     * GET Convidar
     * 
     * @param request
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.CONVIDAR_AMIGO })
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        if(userService.getAuthUser() == null){
            return new ModelAndView("redirect:"+UrlMapping.HOME);
        }
        model.addAttribute("profiles", userService.getFacebookConnection().getApi().friendOperations().getFriendProfiles(0, 25));   
        return new ModelAndView("convidar", model);
    }
    
    
    /**
     * Pesquisa um amigo da lista
     * 
     * @param nomeAmigo
     * @param request
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.POST, value = { UrlMapping.CONVIDAR_PESQUISAR_AMIGO })
    public ModelAndView handleRequestPesquisa(@RequestParam final String nomeAmigo,  HttpServletRequest request, HttpServletResponse response, ModelMap model){
        List<FacebookProfile> lst = userService.getFacebookConnection().getApi().friendOperations().getFriendProfiles();
        List<FacebookProfile> lstSearch = new ArrayList<>();
        for(FacebookProfile p : lst){
            if(p.getName().toLowerCase().contains(nomeAmigo.toLowerCase())){
                lstSearch.add(p);
            }
            if(lstSearch.size() == 25){
                break;
            }
        }
        model.addAttribute("profiles", lstSearch);   
        return new ModelAndView("convidar", model);
    }
    
    /**
     * Invite Friend
     * 
     * @param tipo
     * @param friendId
     * @param friendName
     * @param request
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.POST, value = { UrlMapping.CONVIDAR_AMIGO_INVITE })
    public ModelAndView handleInvite(
            @RequestParam final String tipo,
            @RequestParam final String friendId,
            @RequestParam final String friendName,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String urlRetorno = (tipo.equals("0"))
                                ? this.buildURLProfile(UrlMapping.HUMILHAR_INVITE_AMIGO, EscapeChars.removeAccents(this.userService.getMe().getName()), EscapeChars.removeAccents(friendName)) 
                                : this.buildURLProfile(UrlMapping.BATALHAR_INVITE_AMIGO, EscapeChars.removeAccents(this.userService.getMe().getName()), EscapeChars.removeAccents(friendName));
        
        Solicitacao sol = this.humilharService.sendSolicitacao(Long.valueOf(this.userService.getMe().getId()), Long.valueOf(friendId), 0L);
        String fbURL = getFacebookInviteUrl(friendName, urlRetorno, sol, friendId);
        return new ModelAndView("redirect:"+fbURL);
    }

    
    
    /**
     * handleInviteHumilharBack
     * 
     * 
     * @param s
     * @param request
     * @param profileA
     * @param profileB
     * @param requestH
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.HUMILHAR_INVITE_AMIGO })
    public ModelAndView handleInviteHumilharBack(
            @RequestParam final Long s,
            @RequestParam final Long request,
            @PathVariable final String profileA,
            @PathVariable final String profileB,
            HttpServletRequest requestH, HttpServletResponse response, ModelMap model){
        
        Solicitacao sol = this.humilharService.getSolicitacaoById(s);
        sol.setRequestId(request);
        this.humilharService.saveSolicitacao(sol);
        return new ModelAndView("redirect:"+this.buildURLProfile(UrlMapping.HUMILHAR_AMIGO, profileA, profileB).replace("{requestId}", request.toString()));
    }
    
    
    /**
     * handleInviteBattleBack
     * 
     * 
     * @param s
     * @param request
     * @param profileA
     * @param profileB
     * @param requestH
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.BATALHAR_INVITE_AMIGO })
    public ModelAndView handleInviteBattleBack(
            @RequestParam final Long s,
            @RequestParam final Long request,
            @PathVariable final String profileA,
            @PathVariable final String profileB,
            HttpServletRequest requestH, HttpServletResponse response, ModelMap model){
        
        Solicitacao sol = this.humilharService.getSolicitacaoById(s);
        sol.setRequestId(request);
        this.humilharService.saveSolicitacao(sol);
        return new ModelAndView("redirect:"+this.buildURLProfile(UrlMapping.BATALHAR_AMIGO, profileA, profileB).replace("{requestId}", request.toString()));
    }
    
}
