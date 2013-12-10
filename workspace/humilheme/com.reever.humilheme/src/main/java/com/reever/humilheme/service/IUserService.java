package com.reever.humilheme.service;

import com.reever.humilheme.entity.User;

/**
 *
 * @author iuriandreazza
 */
public interface IUserService extends IService<User, Long> {

    boolean existsUser(String username);
    
    User getByUserName(String username);
    User findByProfileId(Long profileId);

    User getById(Long idUser);
    
}

