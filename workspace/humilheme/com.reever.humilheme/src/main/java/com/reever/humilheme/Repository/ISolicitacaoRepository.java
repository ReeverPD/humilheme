package com.reever.humilheme.Repository;

import com.reever.humilheme.entity.Solicitacao;

/**
 *
 * @author iuriandreazza
 */
public interface ISolicitacaoRepository extends IRepository<Solicitacao, Long> {

    Solicitacao getByIdRequest(Long idRequest);
    
}
