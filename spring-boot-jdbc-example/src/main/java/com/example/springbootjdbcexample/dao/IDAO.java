package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model.User;

import java.util.List;

public interface IDAO {

    void add(User user);

    User getUser(Integer id);

    User update(Integer id, User userDetails);

    void delete(Integer id);

    List<User> getUsers();
}
