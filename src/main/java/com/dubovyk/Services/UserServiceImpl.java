package com.dubovyk.Services;

import com.dubovyk.DAO.UserDAO;
import com.dubovyk.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by knidarkness on 08.05.17.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void registerUser(User user){
        if (!isUser(user.getEmail(), user.getPasswordHash())){
            userDAO.save(user);
        }
    }

    @Transactional
    public boolean isUser(String email, String passhash){
        return userDAO.findUserByEmailAndPasswordHash(email, passhash) != null;
    }

    @Transactional
    public List<User> getAll(){
        return (List<User>) userDAO.findAll();
    }
}
