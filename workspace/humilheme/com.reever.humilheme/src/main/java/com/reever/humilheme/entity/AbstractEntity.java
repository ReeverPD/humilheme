package com.reever.humilheme.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

/**
 *
 * @author iuriandreazza
 */
@Entity
public abstract class AbstractEntity <T extends Object> implements Serializable {
    
    @Getter 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private T Id;
    
}
