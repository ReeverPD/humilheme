package com.reever.humilheme.Repository;

import com.reever.humilheme.entity.AbstractEntity;
import java.util.List;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
public interface IRepository<T extends AbstractEntity<K>, K extends Object> {
   
    void refresh(T entity);
    T merge(T entity);
    T save(T entity);
    Boolean delete(T entity);    
    T getById(K id);
}
