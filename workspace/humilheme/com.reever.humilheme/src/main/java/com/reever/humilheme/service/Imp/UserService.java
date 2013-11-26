package com.reever.humilheme.service.Imp;

import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.service.AbstractService;
import com.reever.humilheme.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author iuriandreazza
 */
public class UserService extends AbstractService<User, Long> implements IUserService{

    @Autowired
    private IUserRepository repository;
    
    
    @Override
    public IRepository<User, Long> getRepository() {
        return this.repository;
    }
    
}
