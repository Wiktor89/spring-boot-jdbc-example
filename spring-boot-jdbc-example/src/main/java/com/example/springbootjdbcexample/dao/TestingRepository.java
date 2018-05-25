package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model2.Testing;
import org.springframework.data.repository.CrudRepository;

public interface TestingRepository extends CrudRepository<Testing, Integer> {
}
