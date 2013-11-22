package com.reever.humilheme.controller;

import com.reever.humilheme.util.AbstractController;
import com.reever.humilheme.entity.MensagemDoacao;
import com.reever.humilheme.service.IMensagemDoacaoService;
import com.reever.humilheme.to.ResponseDoarTO;
import com.reever.humilheme.util.UrlMapping;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Iuri Andreazza
 */
@Controller
public class DoacaoController extends AbstractController {
    
    @Autowired
    private IMensagemDoacaoService mensagemService;
    
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = { UrlMapping.DOAR})
    public @ResponseBody ResponseDoarTO doarSend(@PathVariable String mensagem, HttpServletRequest request, ModelMap model) {
        ResponseDoarTO response = new ResponseDoarTO();
        
        try{
            MensagemDoacao ret = mensagemService.novaMensagem(mensagem, request.getRemoteAddr(), new Date());
            response.sucess = true;
            response.xtr = ret.getMensagem();
        }catch(Exception ex){
            response.sucess = false;
            response.xtr = ex.getMessage();
            this.getLogger().error("Erro ao enviar mensagem", ex);
        }
        
        return response;
    }
    
}
