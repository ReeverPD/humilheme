package com.reever.humilheme.service;

import com.reever.humilheme.entity.AbstractEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
public interface IService <T extends AbstractEntity<K>, K extends Serializable>{
    
    T findById(K id);
    List<T> find(T entity);
    T save(T entity);
    void delete(T entity);
    T merge(T entity);
    void refresh(T entity);
}
