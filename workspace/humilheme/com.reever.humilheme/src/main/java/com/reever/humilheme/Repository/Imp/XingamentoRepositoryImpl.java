package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.IXingamentoRepository;
import com.reever.humilheme.entity.Solicitacao;
import com.reever.humilheme.entity.Xingamento;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iuriandreazza
 */
@Repository
public class XingamentoRepositoryImpl extends AbstractRepository<Xingamento, Long> implements IXingamentoRepository {
    
    /**
     * 
     * Retorna a lista de xingamentos em uma batlalha
     * isto sendo determinado pelo requestID
     * 
     * @param requestId
     * @return 
     */
    @Override
    public List<Xingamento> getBattle(Long requestId){
        Query query = this.getEntityManager()
                                .createQuery("SELECT x FROM Xingamento AS x WHERE x.requestId = :requestId");
        query.setParameter("requestId", requestId);
        List<Xingamento> lstSolicitacao = query.getResultList();
        return lstSolicitacao;
    }
    
}
