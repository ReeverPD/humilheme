/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.service;

import com.reever.humilheme.entity.MensagemDoacao;
import com.reever.humilheme.service.Imp.MensagemDoacaoService;
import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author iuriandreazza
 */
public class IMensagemDoacaoServiceTest extends TestCase {
    
    public IMensagemDoacaoServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of novaMensagem method, of class IMensagemDoacaoService.
     */
    public void testNovaMensagem() {
        System.out.println("novaMensagem");
        String mensagem = "";
        String ipOrigem = "";
        Date dataCricao = null;
        IMensagemDoacaoService instance = new MensagemDoacaoService();
        MensagemDoacao expResult = null;
//        MensagemDoacao result = instance.novaMensagem(mensagem, ipOrigem, dataCricao);
//        assertEquals(expResult, result);
    }

    
    
}
