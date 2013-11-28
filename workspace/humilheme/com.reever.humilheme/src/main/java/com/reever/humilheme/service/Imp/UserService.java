package com.reever.humilheme.service.Imp;

import com.reever.humilheme.Repository.IRepository;
import com.reever.humilheme.Repository.IUserRepository;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.UserException;
import com.reever.humilheme.service.AbstractService;
import com.reever.humilheme.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iuriandreazza
 */
@Service
public class UserService extends AbstractService<User, Long> implements IUserService{

    @Autowired
    private IUserRepository repository;
    
    
    @Override
    public IRepository<User, Long> getRepository() {
        return this.repository;
    }
    
    @Override
    public boolean existsUser(String username){
        try{
            this.repository.findUserByUserName(username);
            return true;
        }catch(UserException ex){
            return false;
        }
    }
    
    @Override
    public User getByUserName(String username){
        return this.repository.findUserByUserName(username);
    }
    
}
