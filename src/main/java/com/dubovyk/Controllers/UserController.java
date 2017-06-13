package com.dubovyk.Controllers;

import com.dubovyk.Domain.User;
import com.dubovyk.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a REST API endpoint for users operations.
 *
 * It allows to create new users and check if user
 * entered correct credentials.
 *
 * @version 1.0
 * @author SergeyDubovyk aka knidarkness
 */

@RestController
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
    @CrossOrigin
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll(){
        return userService.findAll();
    }


    /**
     * @param user User object to be added
     * @return Returns "true" if successful and "false" if not in JSON object for property "status"
     */
    @CrossOrigin
    @PostMapping(path = "/add")
    public @ResponseBody Map<String, String> addUser(@RequestBody User user){
        Map<String, String> res = new HashMap<>();
        if (userService.isAvailableUser(user)){
            if (userService.registerUser(user)){
                res.put("status", "success");
                res.put("message", "");
            } else {
                res.put("status", "failed");
                res.put("message", "Something went wrong.");
            }
        } else {
            res.put("status", "failed");
            res.put("message", "These credentials are already registered.");
        }
        return res;
    }


    /**
     * @param user A user object to check availability.
     * @return A "true" if such user can be crated or "false" if no, in JSON.
     *
     */
    @CrossOrigin
    @PostMapping(path = "/isValid")
    public @ResponseBody
    Map<String, String> isValid(@RequestBody User user){
        Map<String, String> res = new HashMap<>();
        if (userService.isAvailableUser(user)){
            res.put("status", "failed");
            res.put("message", "User is not registered");
        } else {
            if (userService.isRegisteredUser(user.getUsername(), user.getPasswordHash())) {
                res.put("status", "success");
                res.put("message", "");
            } else {
                res.put("status", "failed");
                res.put("message", "You entered bad credentials.");
            }
        }
        return res;
    }
}
