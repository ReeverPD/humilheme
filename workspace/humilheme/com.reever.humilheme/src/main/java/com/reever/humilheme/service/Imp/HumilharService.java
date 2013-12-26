package com.reever.humilheme.service.Imp;

import com.reever.humilheme.Repository.ISolicitacaoRepository;
import com.reever.humilheme.Repository.IXingamentoRepository;
import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.Xingamento;
import com.reever.humilheme.service.IHumilharService;
import com.reever.humilheme.service.IUserService;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iuriandreazza
 */
@Service
public class HumilharService implements IHumilharService{

    private Logger _logger = LoggerFactory.getLogger(HumilharService.class);
    
    @Autowired
    private ISolicitacaoRepository solicitacaoRepository;
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IXingamentoRepository xingamentoRepository;
    
    @Transactional
    @Override
    public Solicitacao sendSolicitacao(Long profileId, Long friendProfileId, Long postId) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setDataCriacao(Calendar.getInstance());
        solicitacao.setFriendFaceId(friendProfileId);
        solicitacao.setUsuarioRequisitor(userService.findByProfileId(profileId));
        try{
            return solicitacaoRepository.save(solicitacao);
        }catch(Exception ex){
            _logger.error("Não foi possivel enviar solicitação", ex);
            return null;
        }
    }

    @Override
    public Solicitacao getSolicitacaoById(Long idSolicitacao){
        return solicitacaoRepository.getById(idSolicitacao);
    }
    
    @Override
    public Solicitacao getSolicitacaoByRequestId(Long idRequest){
        return solicitacaoRepository.getByIdRequest(idRequest);
    }
    
    @Override
    public void saveSolicitacao(Solicitacao solicitacao){
        solicitacaoRepository.save(solicitacao);
    }
    
    /*
     * BATTLE Methods 
     */
    
    @Override
    public boolean existeBattle(Long requestId){
        return xingamentoRepository.getBattle(requestId).isEmpty();
    }
    
    @Override
    public List<Xingamento> getBattle(Long requestId){
        return xingamentoRepository.getBattle(requestId);
    }
    
}
