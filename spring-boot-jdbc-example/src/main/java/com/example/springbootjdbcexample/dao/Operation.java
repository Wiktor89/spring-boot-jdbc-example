package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model2.OperationSystem;
import org.springframework.data.repository.CrudRepository;

public interface Operation extends CrudRepository<OperationSystem, Integer> {
}
