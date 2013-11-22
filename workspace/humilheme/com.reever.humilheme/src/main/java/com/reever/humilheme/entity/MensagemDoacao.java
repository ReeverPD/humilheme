package com.reever.humilheme.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
@Entity
@Table(name="mensagem_doacao")
public class MensagemDoacao extends AbstractEntity<Long>{
    
    @Getter 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;
    
    @Getter @Setter
    @Column(name="mensagem")
    private String mensagem;
    
    @Getter @Setter
    @Column(name="ip_origem")
    private String origem;
    
    @Getter @Setter
    @Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
}
