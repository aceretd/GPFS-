package com.gpfs.security.model;

import java.util.Set;

import javax.persistence.*;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "users")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    @ElementCollection
    @CollectionTable(name = "user_authorities")
    private Set<String> auths;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuths() {
        return auths;
    }

    public void setAuths(Set<String> auths) {
        this.auths = auths;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
