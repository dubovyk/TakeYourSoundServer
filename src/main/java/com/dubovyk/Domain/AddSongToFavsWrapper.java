package com.dubovyk.Domain;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public class AddSongToFavsWrapper {
    private User user;
    private Song song;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
