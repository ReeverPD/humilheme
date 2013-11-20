package com.reever.humilheme.entity;

import com.reever.humilheme.enumeration.SimNao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="xingamento")
public class Xingamento extends AbstractEntity<Long>  {
    
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_user_from", nullable = false)
    private User usuarioFrom;
    
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_user_to", nullable = false)
    private User usuarioTo;
    
    @Getter @Setter
    @Column(name="mensagem")
    private String mensagem;
    
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name="isBattleMode")
    private SimNao battleMode;
    
}
