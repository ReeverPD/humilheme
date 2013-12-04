package com.reever.humilheme.entity;

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
import java.util.Calendar;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
@Entity
@Table(name="solicitacao")
public class Solicitacao extends AbstractEntity<Long> {
    
    @Getter 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;
    
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User UsuarioRequisitor;
    
    @Getter @Setter
    @Column(name="friend_fb_id")
    private Long friendFaceId;
    
    @Getter @Setter
    @Column(name="request_id")
    private Long requestId;
    
    @Getter @Setter
    @Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCriacao;
}
