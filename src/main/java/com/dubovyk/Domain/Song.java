package com.dubovyk.Domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by knidarkness on 06.05.17.
 */

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String name, lyrics;
    private float happiness, motivation, excitement;

    private float average_rate;
    private Long users_voted;
    private Long trackID;

    @ManyToOne()
    @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "band_id")
    private Band band;

    public Song(){}

    public Song(String name, Band band, float happiness, float motivation, float excitement, long trackID){
        this.name = name;
        this.happiness = happiness;
        this.motivation = motivation;
        this.excitement = excitement;
        this.band = band;
        this.trackID = trackID;
    }

    public Band getBand(){
        return band;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public float getHappiness() {
        return happiness;
    }

    public void setHappiness(float happiness) {
        this.happiness = happiness;
    }

    public float getMotivation() {
        return motivation;
    }

    public void setMotivation(float motivation) {
        this.motivation = motivation;
    }

    public float getExcitement() {
        return excitement;
    }

    public void setExcitement(float excitement) {
        this.excitement = excitement;
    }

    public float getAverage_rate() {
        return average_rate;
    }

    public void setAverage_rate(float average_rate) {
        this.average_rate = average_rate;
    }

    public Long getUsers_voted() {
        return users_voted;
    }

    public void setUsers_voted(Long users_voted) {
        this.users_voted = users_voted;
    }

    public Long getTrackID() {
        return trackID;
    }

    public void setTrackID(Long trackID) {
        this.trackID = trackID;
    }

    @Override
    public String toString(){
        return String.valueOf(this.getHappiness());
    }

}
