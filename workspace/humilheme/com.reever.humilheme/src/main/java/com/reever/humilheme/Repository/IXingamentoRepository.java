package com.reever.humilheme.Repository;

import com.reever.humilheme.entity.Xingamento;
import java.util.List;

/**
 *
 * @author iuriandreazza
 */
public interface IXingamentoRepository extends IRepository<Xingamento, Long> {

    List<Xingamento> getBattle(Long requestId);
    
}
