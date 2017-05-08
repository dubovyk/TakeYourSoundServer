package com.dubovyk.Services;

import com.dubovyk.Domain.User;

import java.util.List;

/**
 * @version 1.0
 * @author Sergey Dubovyk aka knidarkness
 */
public interface UserService {
    boolean registerUser(User user);
    boolean isAvailableUser(User user);
    boolean isUser(String email, String password);
    List<User> getAll();
}
