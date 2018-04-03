package com.example.springbootjdbcexample.service;

import com.example.springbootjdbcexample.model.User;

import java.util.List;

public interface IService {

    Boolean add(User user);

    User getUser(Integer id);

    User update(Integer id, User userDetails);

    Boolean delete(Integer id);

    List<User> getUsers();
}
