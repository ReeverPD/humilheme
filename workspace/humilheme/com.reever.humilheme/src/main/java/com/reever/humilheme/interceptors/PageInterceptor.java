package com.reever.humilheme.interceptors;

import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.FacebookLoginException;
import com.reever.humilheme.service.IUserFaceService;
import com.reever.humilheme.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
public class PageInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserFaceService userFaceService;
    
    @Autowired
    protected IUserService userLocalService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getRequestURI().toLowerCase().contains("app")){
            if(this.userFaceService.getAuthUser() == null){
//                User usr = this.userLocalService.getById(this.userFaceService.getAuthUser().getIdUser());
                try{
                    this.userFaceService.autenticarUsuarioFaceBook(request.getParameter("code"), request.getRequestURL().toString(), request, response);
                }catch(FacebookLoginException fEx){
                    response.sendRedirect(fEx.getLoginUrl());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception excptn) throws Exception {
        
    }
    
    
    
}
