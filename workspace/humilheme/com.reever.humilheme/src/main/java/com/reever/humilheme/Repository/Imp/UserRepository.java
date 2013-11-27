package com.reever.humilheme.Repository.Imp;

import com.reever.humilheme.Repository.IUserRepository;
import com.reever.humilheme.entity.User;
import com.reever.humilheme.exception.UserException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author iuriandreazza
 */
public class UserRepository extends AbstractRepository<User, Long> implements IUserRepository {

    @Override
    public User findUserByUserName(String username){
        Query query = this.getEntityManager()
                                .createQuery("SELECT u FROM User AS u WHERE u.username = :username");
        query.setParameter("username", username);
        List<User> lstUsers = query.getResultList();
        if(lstUsers.isEmpty()){
            throw new UserException();
        }
        return lstUsers.get(0);
    }
    
}
