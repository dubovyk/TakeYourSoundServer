package com.dubovyk.Controllers;

import com.dubovyk.Domain.AddSongToFavsWrapper;
import com.dubovyk.Domain.Playlist;
import com.dubovyk.Domain.Song;
import com.dubovyk.Domain.User;
import com.dubovyk.Services.PlaylistService;
import com.dubovyk.Services.SongService;
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
    private final SongService songService;
    private final PlaylistService playlistService;

    @Autowired
    public UserController(UserService userService, SongService songService, PlaylistService playlistService) {
        this.userService = userService;
        this.songService = songService;
        this.playlistService = playlistService;
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

    @CrossOrigin
    @PostMapping(path = "/add_favorites")
    public @ResponseBody Map<String, String> addToFavourites(@RequestBody AddSongToFavsWrapper wrapper){
        Map<String, String> res = new HashMap<>();
        Song target = songService.findById(wrapper.getSong().getId());
        if (target != null){
            res.put("status", "done");
            userService.addSongToFavorites(wrapper.getUser(), target);
        } else {
            res.put("status", "failed");
        }
        return res;
    }

    @CrossOrigin
    @PostMapping(path = "/remove_favorites")
    public @ResponseBody Map<String, String> removeFromFavorites(@RequestBody AddSongToFavsWrapper wrapper){
        Map<String, String> res = new HashMap<>();
        Song target = songService.findById(wrapper.getSong().getId());
        if (target != null){
            if(userService.findByName(wrapper.getUser().getUsername()).getFavourites().getSongs().contains(target)){

            }
            res.put("status", "done");
            userService.removeSongFromFavorites(wrapper.getUser(), target);
        } else {
            res.put("status", "failed");
        }
        return res;
    }

    @CrossOrigin
    @GetMapping(path = "/get_favorites")
    public @ResponseBody Playlist getFavorites(@RequestParam String username){
        User user = userService.findByName(username);
        if(user == null){
            return null;
        } else {
            return user.getFavourites();
        }
    }
}
