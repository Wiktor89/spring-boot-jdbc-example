package com.example.springbootjdbcexample.dao;

import com.example.springbootjdbcexample.model2.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
}
