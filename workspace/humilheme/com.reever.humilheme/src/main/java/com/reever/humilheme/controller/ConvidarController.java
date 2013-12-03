package com.reever.humilheme.controller;

import com.reever.humilheme.service.IHumilharService;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.UrlMapping;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.FacebookProfile;
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
public class ConvidarController extends AbstractController {


    @Autowired
    private IUserFaceService userService;
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
    
    @RequestMapping(method = RequestMethod.POST, value = { UrlMapping.CONVIDAR_AMIGO_INVITE })
    public ModelAndView handleInvite(
            @RequestParam final String tipo,
            @RequestParam final String friendId,
            @RequestParam final String friendName,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String urlRetorno = (tipo.equals("0"))? this.buildURLProfile(UrlMapping.HUMILHAR_AMIGO, this.userService.getMe().getName(), friendName) : this.buildURLProfile(UrlMapping.BATALHAR_AMIGO, this.userService.getMe().getName(), friendName);
        
        String fbURL = "https://www.facebook.com/dialog/apprequests?" +
                        "app_id="+ userService.getClientID() +
                        "&message=" + StringEscapeUtils.escapeHtml4("Você tem coragem? Peça para " + friendName + " tentar criar uma humilhão!")  +
                        "&redirect_uri=http://localhost:8080/com.reever.humilheme"+urlRetorno;
        
        this.humilharService.sendSolicitacao(Long.valueOf(this.userService.getMe().getId()), Long.valueOf(friendId), 0L);
        
        return new ModelAndView("redirect:"+fbURL);
    }
    
}
