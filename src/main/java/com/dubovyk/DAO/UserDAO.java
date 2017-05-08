package com.dubovyk.DAO;

import com.dubovyk.Domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by knidarkness on 08.05.17.
 */
public interface UserDAO extends CrudRepository<User, Long>{
    User findUserByEmailAndPasswordHash(String email, String passhash);
}
