package com.dubovyk.DAO;

import com.dubovyk.Domain.UserRoles;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public interface UserRolesDAO extends CrudRepository<UserRoles, Long> {
}
