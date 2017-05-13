package com.dubovyk.Services;

import com.dubovyk.Domain.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @version 1.0
 * @author Sergey Dubovyk aka knidarkness
 */
public interface UserService extends GenericService<User, Long>{
    @Transactional
    boolean registerUser(User user);
    @Transactional
    boolean isAvailableUser(User user);
    @Transactional
    boolean isRegisteredUser(String email, String password);
    @Transactional
    User findByName(String username);
}
