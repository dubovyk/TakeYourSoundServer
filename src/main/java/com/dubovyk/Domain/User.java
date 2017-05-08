package com.dubovyk.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * @version 1.0
 * @author Sergey Dubovyk aka knidarkness
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHash;

    private String username;
    private String email;

    @Column(name = "reg_date", columnDefinition = "DATETIME")
    //@Temporal(TemporalType.TIMESTAMP)
    private String regDate;

    public User(){}

    public User(String username, String email, String passwordHash){
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String  getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
