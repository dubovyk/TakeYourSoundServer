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
    private float happiness, saddness, frustration, motivation, anger, calmness;

    private float average_rate;
    private Long users_voted;

    @ManyToOne()
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "band_id")
    private Band band;

    public Song(){}

    public Song(String name, Band band, float happiness, float saddness, float frustration, float motivation, float anger, float calmness){
        this.name = name;
        this.happiness = happiness;
        this.saddness = saddness;
        this.motivation = motivation;
        this.frustration = frustration;
        this.anger = anger;
        this.calmness = calmness;
        this.band = band;
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

    public float getSaddness() {
        return saddness;
    }

    public void setSaddness(float saddness) {
        this.saddness = saddness;
    }

    public float getFrustration() {
        return frustration;
    }

    public void setFrustration(float frustration) {
        this.frustration = frustration;
    }

    public float getMotivation() {
        return motivation;
    }

    public void setMotivation(float motivation) {
        this.motivation = motivation;
    }

    public float getAnger() {
        return anger;
    }

    public void setAnger(float anger) {
        this.anger = anger;
    }

    public float getCalmness() {
        return calmness;
    }

    public void setCalmness(float calmness) {
        this.calmness = calmness;
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

    //public void setBand(Band band) {
    //    this.band = band;
    //}
}
