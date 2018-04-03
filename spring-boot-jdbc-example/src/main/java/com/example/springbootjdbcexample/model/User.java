package com.example.springbootjdbcexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "test_users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column (name = "login")
    private String loggin;

    @Column (name = "password")
    private String password;

    @Temporal (TemporalType.TIMESTAMP)
    @Column (name = "createdate", nullable = false)
    private Date createDate;

    public User (Integer id, String loggin, String password) {
        this.id = id;
        this.loggin = loggin;
        this.password = password;
    }

    public User () {
    }

    public User (String loggin, String password) {
        this.loggin = loggin;
        this.password = password;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getLoggin () {
        return loggin;
    }

    public void setLoggin (String loggin) {
        this.loggin = loggin;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", loggin='" + loggin + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" +
                '}';
    }
}
