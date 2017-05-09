package com.dubovyk.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
@Entity
public class UserRoles {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private boolean isAdmin;
    private boolean isModerator;

    public UserRoles(){
        this.isAdmin = false;
        this.isModerator = false;
    }

    public UserRoles(boolean isAdmin, boolean isModerator) {
        this.isAdmin = isAdmin;
        this.isModerator = isModerator;
    }

    public UserRoles(Long id, boolean isAdmin, boolean isModerator) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.isModerator = isModerator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }
}
