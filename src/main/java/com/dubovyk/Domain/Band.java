package com.dubovyk.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Set<Song> songs;

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
