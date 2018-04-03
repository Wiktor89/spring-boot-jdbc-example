package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CustomRepository extends CrudRepository<User, Integer> {
//    @Query ("SELECT u FROM User u WHERE u.login=:login")
//    List<User> getLogin (@Param ("login") String login);
}
