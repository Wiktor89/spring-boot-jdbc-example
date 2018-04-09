package com.example.springbootjdbcexample.controller;

import com.example.springbootjdbcexample.model.User;
import com.example.springbootjdbcexample.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MainController {

    @Autowired
    @Qualifier ("userServiceCustom")
    private IService service;

    @PostMapping (value = Url.POST_USER)
    public ResponseEntity<User> add (@RequestBody User user) {
        service.add (user);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

    @GetMapping (value = Url.GET_USER_BY_ID)
    public ResponseEntity<User> getUser (@PathVariable ("id") Integer id) {
        return new ResponseEntity<> (service.getUser (id), HttpStatus.OK);
    }

    @PutMapping (value = Url.PUT_USER_BY_ID)
    public ResponseEntity<User> update (@PathVariable ("id") Integer id, @RequestBody User user) {
        return new ResponseEntity<> (service.update (id, user), HttpStatus.OK);
    }

    @DeleteMapping (value = Url.DELETE_USER_BY_ID)
    public ResponseEntity<Void> delete (@PathVariable ("id") Integer id) {
        service.delete (id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping (value = Url.GET_USERS)
    public ResponseEntity<List<User>> getUsers () {
        List<User> users = service.getUsers ();
        return new ResponseEntity<> (users, HttpStatus.OK);
    }

}
