package com.dubovyk.Controllers;

import com.dubovyk.Domain.User;
import com.dubovyk.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by knidarkness on 08.05.17.
 */

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll(){
        return userService.getAll();
    }

    @PostMapping(path = "/isValid")
    public @ResponseBody String isValid(@RequestBody User user){
        StringBuilder buffer = new StringBuilder();
        buffer.append("{\"status\":\"");
        if (userService.isUser(user.getEmail(), user.getPasswordHash())){
            buffer.append("valid");
        } else {
            buffer.append("notvalid");
        }
        buffer.append("\"}");
        return buffer.toString();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestBody User user){
        userService.registerUser(user);
        return "Added";
    }
}
