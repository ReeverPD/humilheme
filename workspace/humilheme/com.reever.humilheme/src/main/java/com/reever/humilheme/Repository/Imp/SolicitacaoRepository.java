package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.ISolicitacaoRepository;
import com.reever.humilheme.entity.Solicitacao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iuriandreazza
 */
@Repository
public class SolicitacaoRepository extends AbstractRepository<Solicitacao, Long> implements ISolicitacaoRepository  {
    
}
