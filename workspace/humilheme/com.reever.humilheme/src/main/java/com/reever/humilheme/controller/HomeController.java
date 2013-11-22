package com.reever.humilheme.controller;

import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.util.UrlMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author iuriandreazza
 */
@Controller
public class HomeController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET, value = { UrlMapping.HOME, UrlMapping.ROOT })
    public String handleRequest() {
        return "welcome";
    }

}
