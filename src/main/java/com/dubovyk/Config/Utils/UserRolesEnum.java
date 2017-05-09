package com.dubovyk.Config.Utils;

import com.dubovyk.Domain.User;
import com.dubovyk.Domain.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * This enum is used to return a text form of
 * UserRoles of given User.
 *
 * @see User
 * @see UserRoles
 *
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public enum UserRolesEnum {
    ROLE_ADMIN(new ArrayList<>(
            Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"),
                            new SimpleGrantedAuthority("ROLE_MODERATOR"),
                            new SimpleGrantedAuthority("ROLE_USER")))),
    ROLE_MODERATOR(new ArrayList<>(
            Arrays.asList(new SimpleGrantedAuthority("ROLE_MODERATOR"),
                            new SimpleGrantedAuthority("ROLE_USER")))),
    ROLE_USER(new ArrayList<>(
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));

    public static UserRolesEnum getUserRole(User user){
        UserRoles roles = user.getUserRoles();
        if (roles.isAdmin()){
            return UserRolesEnum.ROLE_ADMIN;
        } else if (roles.isModerator()){
            return UserRolesEnum.ROLE_MODERATOR;
        } else {
            return UserRolesEnum.ROLE_USER;
        }
    }

    private final List<GrantedAuthority> authorities;

    public List<GrantedAuthority> getAuthorities(){
        return authorities;
    }

    UserRolesEnum(List<GrantedAuthority> authorities){
        this.authorities = authorities;
    }
}
