package com.reever.humilheme.service;

import com.reever.humilheme.entity.Solicitacao;

/**
 *
 * @author iuriandreazza
 */
public interface IHumilharService {
    
    //Solicitacao
    Solicitacao sendSolicitacao(Long profileId, Long friendProfileId, Long postId);
    Solicitacao getSolicitacaoById(Long idSolicitacao);
    Solicitacao getSolicitacaoByRequestId(Long idRequest);
    void saveSolicitacao(Solicitacao solicitacao);
    
    //Battle Mode
    boolean existeBattle(Long requestId);
    
    
}
