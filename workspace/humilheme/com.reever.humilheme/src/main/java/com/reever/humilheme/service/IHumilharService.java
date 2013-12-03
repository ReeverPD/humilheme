package com.reever.humilheme.service;

/**
 *
 * @author iuriandreazza
 */
public interface IHumilharService {
    
    boolean sendSolicitacao(Long profileId, Long friendProfileId, Long postId);
    
}
