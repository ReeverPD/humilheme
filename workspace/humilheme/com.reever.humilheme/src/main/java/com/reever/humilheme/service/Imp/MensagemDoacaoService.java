package com.reever.humilheme.service.Imp;

import com.reever.humilheme.Repository.IMensagemDoacaoRepository;
import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.entity.MensagemDoacao;
import com.reever.humilheme.service.AbstractService;
import com.reever.humilheme.service.IMensagemDoacaoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iuri Andreazza
 */
@Service
public class MensagemDoacaoService extends AbstractService<MensagemDoacao, Long> implements IMensagemDoacaoService{

    @Autowired
    private IMensagemDoacaoRepository repository;
    
    @Override
    public IRepository<MensagemDoacao, Long> getRepository() {
        return this.repository;
    }

    @Override
    public MensagemDoacao novaMensagem(String mensagem, String ipOrigem, Date dataCricao) {
        MensagemDoacao entity = new MensagemDoacao();
        entity.setMensagem(mensagem);
        entity.setOrigem(ipOrigem);
        entity.setDataCriacao(dataCricao);
        return this.repository.save(entity);
    }

    
}
