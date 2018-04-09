package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CustomRepository extends CrudRepository<User, Integer> {
}
