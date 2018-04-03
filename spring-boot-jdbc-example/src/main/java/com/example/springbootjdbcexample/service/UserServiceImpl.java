package com.example.springbootjdbcexample.service;

import com.example.springbootjdbcexample.dao.IDAO;
import com.example.springbootjdbcexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IService {

    @Autowired
    @Qualifier("jdbcTemp")
    private IDAO dao;

    @Override
    public Boolean add(User user) {
        dao.add (user);
        return Boolean.TRUE;
    }

    @Override
    public User getUser(Integer id) {
        return dao.getUser (id);
    }

    @Override
    public User update(Integer id, User userDetails) {
        return dao.update (id, userDetails);
    }

    @Override
    public Boolean delete(Integer id) {
        dao.delete (id);
        return Boolean.TRUE;
    }

    @Override
    public List<User> getUsers() {
        return dao.getUsers ();
    }
}
