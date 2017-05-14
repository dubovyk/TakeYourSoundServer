package com.dubovyk.Config;


import com.dubovyk.Config.Utils.UserRolesEnum;
import com.dubovyk.Domain.User;
import com.dubovyk.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is used as a custom
 * authentication provider. It accesses
 * the database via UserService.
 *
 * It checks if there`s such user registered in
 * the system. If no -- returns null.
 *
 * Then it gets user`s roles and returns
 * them in Authentication object.
 *
 * @version 1.0
 * @author Sergey Dubovyk aka knidarkness
 */
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserService userService;

    @Autowired
    public CustomAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.findByName(name);
        if(user!= null && user.getPasswordHash().equals(password)){
            List<GrantedAuthority> grantedAuths = UserRolesEnum.getUserRole(user).getAuthorities();
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
