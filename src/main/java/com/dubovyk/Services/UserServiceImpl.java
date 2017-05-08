package com.dubovyk.Services;

import com.dubovyk.DAO.UserDAO;
import com.dubovyk.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This is a UserService implementation.
 *
 * @version 1.0
 * @author SergeyDubovyk aka knidarkness
 *
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public boolean registerUser(User user){
        if (isAvailableUser(user)) {
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean isUser(String email, String passhash){
        return userDAO.findUserByEmailAndPasswordHash(email, passhash) != null;
    }

    @Transactional
    public List<User> getAll(){
        return (List<User>) userDAO.findAll();
    }

    @Transactional
    public boolean isAvailableUser(User user){
        return userDAO.findAllByEmailOrUsername(user.getEmail(), user.getUsername()).size() == 0;
    }
}
