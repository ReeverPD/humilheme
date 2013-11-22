package com.reever.humilheme.service;


import com.reever.humilheme.entity.MensagemDoacao;
import java.util.Date;

/**
 *
 * @author iuriandreazza
 */
public interface IMensagemDoacaoService extends IService<MensagemDoacao, Long> {

    MensagemDoacao novaMensagem(String mensagem, String ipOrigem, Date dataCricao);
    
}
