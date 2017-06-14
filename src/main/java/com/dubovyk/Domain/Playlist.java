package com.dubovyk.Domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */

@Entity
public class Playlist {
    @Id
    @GeneratedValue
    @Column(name = "idPlaylist")
    private Long id;

    @ManyToMany
    private List<Song> songs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public boolean removeSongByName(Song song){
        return songs.remove(song);
    }
}
