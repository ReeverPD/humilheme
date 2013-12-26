package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.ISolicitacaoRepository;
import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.UserException;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iuriandreazza
 */
@Repository
public class SolicitacaoRepositoryImpl extends AbstractRepository<Solicitacao, Long> implements ISolicitacaoRepository  {

    @Override
    public Solicitacao getByIdRequest(Long idRequest){
        Query query = this.getEntityManager()
                                .createQuery("SELECT u FROM Solicitacao AS u WHERE u.requestId = :requestId");
        query.setParameter("requestId", idRequest);
        List<Solicitacao> lstSolicitacao = query.getResultList();
        if(lstSolicitacao.isEmpty()){
            throw new RuntimeException("Erro ao buscar solicitação");
        }
        return lstSolicitacao.get(0);
    }
    
}
