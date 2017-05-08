package com.dubovyk.Services;

import com.dubovyk.Domain.User;

import java.util.List;

/**
 * Created by knidarkness on 08.05.17.
 */
public interface UserService {
    void registerUser(User user);
    boolean isUser(String email, String password);
    List<User> getAll();
}
