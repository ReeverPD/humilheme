package com.reever.humilheme.service;

import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.entity.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Iuri Andreazza
 */
@Service(value="abstractService")
public abstract class AbstractService <T extends AbstractEntity<K>, K extends Serializable> implements IService<T, K>{

    public abstract IRepository<T, K> getRepository();
    
    @Override
    public T findById(K id) {
        return this.getRepository().getById(id);
    }

    @Override
    public List<T> find(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T save(T entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getRepository().delete(entity);
    }

    @Override
    public T merge(T entity) {
        return this.getRepository().merge(entity);
    }

    @Override
    public void refresh(T entity) {
        this.getRepository().refresh(entity);
    }
    
}