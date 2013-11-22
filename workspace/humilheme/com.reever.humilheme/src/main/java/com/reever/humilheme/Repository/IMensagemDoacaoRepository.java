package com.reever.humilheme.Repository;

import com.reever.humilheme.entity.MensagemDoacao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
public interface IMensagemDoacaoRepository extends IRepository<MensagemDoacao, Long>{
    
    List<MensagemDoacao> getMensagens();
    
}
