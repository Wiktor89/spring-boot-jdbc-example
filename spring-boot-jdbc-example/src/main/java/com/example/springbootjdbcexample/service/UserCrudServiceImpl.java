package com.example.springbootjdbcexample.service;

import com.example.springbootjdbcexample.dao.CustomRepository;
import com.example.springbootjdbcexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserCrudServiceImpl implements IService {

    @Autowired
    private CustomRepository repository;

    @Override
    public Boolean add (User user) {
        repository.save (user);
        return Boolean.TRUE;
    }

    @Override
    public User getUser (Integer id) {
        return repository.findById (id).orElse (new User ());
    }

    @Override
    public User update (Integer id, User userDetails) {
        userDetails.setId (id);
        return repository.save (userDetails);
    }

    @Override
    public Boolean delete (Integer id) {
        repository.deleteById (id);
        return Boolean.TRUE;
    }

    @Override
    public List<User> getUsers () {
        return (List<User>) repository.findAll ();
    }
}
