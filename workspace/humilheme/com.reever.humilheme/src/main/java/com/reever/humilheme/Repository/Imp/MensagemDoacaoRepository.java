package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.IMensagemDoacaoRepository;
import com.reever.humilheme.entity.MensagemDoacao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Iuri Andreazza
 */
@Repository
public class MensagemDoacaoRepository extends AbstractRepository<MensagemDoacao, Long> implements IMensagemDoacaoRepository{

    @Override
    public List<MensagemDoacao> getMensagens() {
        return new ArrayList<>();
    }
    
    
}
