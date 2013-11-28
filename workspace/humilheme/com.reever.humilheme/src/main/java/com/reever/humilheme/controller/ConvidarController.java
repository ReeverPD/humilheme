package com.reever.humilheme.controller;

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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author iuriandreazza
 */
@Controller
public class ConvidarController extends AbstractController {


    @Autowired
    private IUserFaceService userService;
    
    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.CONVIDAR_AMIGO })
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        return new ModelAndView("convidar");
    }
    
    
}
