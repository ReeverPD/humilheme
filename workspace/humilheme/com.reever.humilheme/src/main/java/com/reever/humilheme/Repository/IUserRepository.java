package com.reever.humilheme.Repository;

import com.reever.humilheme.entity.User;

/**
 *
 * @author iuriandreazza
 */
public interface IUserRepository extends IRepository<User, Long>{

    User findUserByUserName(String username);
    User findByProfileId(Long profileId);
    
}
