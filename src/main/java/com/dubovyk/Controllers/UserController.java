package com.dubovyk.Controllers;

import com.dubovyk.Domain.User;
import com.dubovyk.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a REST API endpoint for users operations.
 *
 * It allows to create new users and check if user
 * entered correct credentials.
 *
 * @version 1.0
 * @author SergeyDubovyk aka knidarkness
 */

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * This method should be used for retrieving
     * all the users and basic info about them.
     *
     * @return A collection of all the users in JSON.
     */
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll(){
        return userService.getAll();
    }

    /**
     * @param user A user object to check availability.
     * @return A "true" if such user can be crated or "false" if no, in JSON.
     *
     */
    @PostMapping(path = "/isValid")
    public @ResponseBody String isValid(@RequestBody User user){
        StringBuilder buffer = new StringBuilder();
        buffer.append("{\"status\":\"");
        if (userService.isUser(user.getEmail(), user.getPasswordHash())){
            buffer.append("true");
        } else {
            buffer.append("false");
        }
        buffer.append("\"}");
        return buffer.toString();
    }

    /**
     * @param user User object to be added
     * @return Returns "true" if successful and "false" if not in JSON object for property "status"
     */
    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestBody User user){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = sdf.format(now);
        user.setRegDate(currentDateTime);
        if (userService.registerUser(user)){
            return "{\"status\":\"success\"}";
        } else {
            return "{\"status\":\"failed\"}";
        }
    }
}