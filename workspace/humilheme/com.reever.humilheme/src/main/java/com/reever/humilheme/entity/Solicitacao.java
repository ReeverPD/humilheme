package com.reever.humilheme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="solicitacao")
public class Solicitacao extends AbstractEntity<Long> {
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User UsuarioRequisitor;
    
    @Getter @Setter
    @Column(name="friend_fb_id")
    private Long friendFaceId;
    
    @Getter @Setter
    @Column(name="post_id")
    private Long postId;
    
    @Getter @Setter
    @Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Long dataCriacao;
}
