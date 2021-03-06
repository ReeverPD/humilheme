package com.reever.humilheme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * 
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
@Entity
@Table(name="fb_user")
public class User extends AbstractEntity<Long> {
    
    @Getter 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;
    
    @Getter @Setter
    @Column(name="username")
    private String userName;
    
    @Getter @Setter
    @Column(name="email")
    private String email;
    
    @Getter @Setter
    @Column(name="token")
    private String tokenAuth;
    
    @Getter @Setter
    @Column(name="profile_name")
    private String profileName;
    
    @Getter @Setter
    @Column(name="profile_pic")
    private String profilePicture;
    
    @Getter @Setter
    @Column(name="profile_link")
    private String profileLink;
    
    @Getter @Setter
    @Column(name="profile_id")
    private String profileId;
    
}
