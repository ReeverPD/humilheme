package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.entity.AbstractEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Iuri Andreazza
 */
@Repository
public class AbstractRepository<T extends AbstractEntity<K>, K extends Object> implements IRepository<T, K> {
    
    private T type;
    
    @Getter
    private final Logger _logger = LoggerFactory.getLogger(AbstractRepository.class);
    
    @Getter
    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public T getById(K id) {
        return (T)this.getEntityManager().find(type.getClass(), id);
    }

    @Transactional
    @Override
    public T save(T entity) {
        this.getEntityManager().persist(entity);
        this.getEntityManager().refresh(entity);
        return entity;
    }

    @Transactional
    @Override
    public Boolean delete(T entity) {
        try{
            this.getEntityManager().remove(entity);
            return true;
        }catch(Exception ex){
            _logger.error("Erro ao tentar remover entidade", ex);
            return false;
        }
    }

    @Override
    public T merge(T entity) {
        return (T)this.getEntityManager().merge(entity);
    }
    
    
    @Override
    public void refresh(T entity) {
        this.getEntityManager().refresh(entity);
    }

}
