package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.entity.AbstractEntity;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 *
 * @author Iuri Andreazza
 */
public class AbstractRepository<T extends AbstractEntity<K>, K extends Object> implements IRepository<T, K> {
    
    private Class<AbstractEntity<K>> type;
    
    @Getter
    private final Logger _logger = LoggerFactory.getLogger(AbstractRepository.class);
    
    @Getter
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public AbstractRepository(){
        if(getClass().getGenericSuperclass() instanceof ParameterizedTypeImpl){
            type = (Class<AbstractEntity<K>>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }
    
    @SuppressWarnings("unchecked")
    public AbstractRepository(Class<AbstractEntity<K>> persistenceClass){
        type = persistenceClass;
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public T getById(K id) {
        return (T)this.getEntityManager().find(type, id);
    }

    @Transactional
    @Override
    public T save(T entity) {
        this.getEntityManager().persist(entity);
        this.getEntityManager().flush();
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
