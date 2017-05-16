package com.dubovyk.DAO;

import com.dubovyk.Domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This is a Data Access Object for User table in
 * the database.
 *
 * It extends default CRUD logic with methods
 * to find user by email and password -- to log in,
 * and check if there exist at least one user
 * with given email or username -- to check
 * if we can create such user.
 *
 * @version 1.0
 * @author Sergey Dubovyk aka knidarkness
 */
public interface UserDAO extends CrudRepository<User, Long>{
    User findUserByEmailAndPasswordHash(String email, String passhash);
    User findUserByUsername(String username);
    User findUserByUsernameAndPasswordHash(String u_name, String u_pass);
    List<User> findAllByEmailOrUsername(String email, String username);
}
