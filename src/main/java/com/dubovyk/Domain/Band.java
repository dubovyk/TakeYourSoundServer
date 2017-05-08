package com.dubovyk.Domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by knidarkness on 07.05.17.
 */

@Entity
public class Band {
    @Id
    @GeneratedValue
    @Column(name = "band_id")
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "band")
    private Set<Song> songs;

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}