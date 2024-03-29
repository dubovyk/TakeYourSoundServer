package com.dubovyk.Services;

import com.dubovyk.DAO.PlaylistDAO;
import com.dubovyk.DAO.UserDAO;
import com.dubovyk.DAO.UserRolesDAO;
import com.dubovyk.Domain.Playlist;
import com.dubovyk.Domain.Song;
import com.dubovyk.Domain.User;
import com.dubovyk.Domain.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This is a UserService implementation.
 *
 * @version 1.0
 * @author SergeyDubovyk aka knidarkness
 *
 */
@Service("UserService")
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
    private final UserDAO userDAO;
    private final UserRolesDAO userRolesDAO;
    private final PlaylistDAO playlistDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserRolesDAO userRolesDAO, PlaylistDAO playlistDAO) {
        super(userDAO);
        this.userDAO = userDAO;
        this.userRolesDAO = userRolesDAO;
        this.playlistDAO = playlistDAO;
    }

    /**
     * This method registers a new user. To do it we check
     * if such user can be registered by calling isAvailableUser()
     * method and if it returns true, this method adds a registration
     * data and time to the user object as well as default permissions
     * (usual user).
     *
     * @see boolean isAvailableUser(User user)
     *
     * @param user A User object to be registered
     * @return True if succeeded and false if not
     */
    @Transactional
    public boolean registerUser(User user){
        if (isAvailableUser(user)) {
            UserRoles roles = new UserRoles();
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String currentDateTime = sdf.format(now);
            user.setRegDate(currentDateTime);

            userRolesDAO.save(roles);
            user.setUserRoles(roles);

            userDAO.save(user);

            Playlist favorites = new Playlist();
            playlistDAO.save(favorites);
            user.setFavourites(new Playlist());
            userDAO.save(user);

            return true;
        }
        return false;
    }

    /**
     * @param email Users email
     * @param passhash Hash of users password
     * @return Returns true if given valid credentials and false if not.
     */
    @Transactional
    public boolean isRegisteredUser(String username, String passhash){
        return userDAO.findUserByUsernameAndPasswordHash(username, passhash) != null;
    }

    /**
     * @param user User data to be checked
     * @return Returns true if it`s possible to create a user with given data.
     */
    @Transactional
    public boolean isAvailableUser(User user){
        return userDAO.findAllByEmailOrUsername(user.getEmail(), user.getUsername()).size() == 0;
    }

    @Transactional
    public User findByName(String username){
        return userDAO.findUserByUsername(username);
    }

    @Transactional
    public boolean addSongToFavorites(User user, Song song){
        User u = userDAO.findUserByUsername(user.getUsername());
        if (!u.getFavourites().getSongs().contains(song)){
            u.getFavourites().addSong(song);
        }
        return true;
    }

    @Transactional
    public boolean removeSongFromFavorites(User user, Song song){
        User u = userDAO.findUserByUsername(user.getUsername());
        u.getFavourites().removeSongByName(song);
        return true;
    }
}
