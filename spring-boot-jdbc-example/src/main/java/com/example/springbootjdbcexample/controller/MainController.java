package com.example.springbootjdbcexample.controller;

import com.example.springbootjdbcexample.model.User;
import com.example.springbootjdbcexample.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private IService service;

    @RequestMapping(value = Url.POST_USER, method = RequestMethod.POST)
    public void add(@RequestBody User user) {
        service.add (user);
    }

    @RequestMapping(value = Url.GET_USER_BY_ID, method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        return service.getUser (id);
    }

    @RequestMapping(value = Url.PUT_USER_BY_ID, method = RequestMethod.PUT)
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        return service.update (id, user);
    }

    @RequestMapping(value = Url.DELETE_USER_BY_ID, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        service.delete (id);
    }

    @RequestMapping(value = Url.GET_USERS, method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.getUsers ();
    }

}
