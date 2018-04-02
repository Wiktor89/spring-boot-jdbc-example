package com.example.springbootjdbcexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    @JsonIgnore
    private Integer id;

    private String loggin;

    private String password;

    public User(Integer id, String loggin, String password) {
        this.id = id;
        this.loggin = loggin;
        this.password = password;
    }

    public User() {
    }

    public User(String loggin, String password) {
        this.loggin = loggin;
        this.password = password;
    }

    public String getLoggin() {
        return loggin;
    }

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "loggin='" + loggin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
