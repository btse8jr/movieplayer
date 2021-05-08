package com.xander.movieplayer.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "user", schema = "movieplayer", catalog = "")
public class User {
    private long userId;
    private String username;
    private String password;
    private Integer permission;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "permission")
    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(permission, that.permission);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, password, permission);
    }
}
