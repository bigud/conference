package com.testtask.conference.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "login", unique = true)
    @NotEmpty(message = "*Login cannot be empty")
    private String login;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    //@NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Column(name = "role")
    private String role;
    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Lecture> lectures;

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
              //  ", name='" + name + '\'' +
                ", login='" + login + '\'' +
              //  ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}