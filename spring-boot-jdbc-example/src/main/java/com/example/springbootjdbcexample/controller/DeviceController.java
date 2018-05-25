package com.example.springbootjdbcexample.controller;

import com.example.springbootjdbcexample.controller.url.DeviceUrl;
import com.example.springbootjdbcexample.dao.DeviceRepository;
import com.example.springbootjdbcexample.dao.Operation;
import com.example.springbootjdbcexample.dao.TestingRepository;
import com.example.springbootjdbcexample.model2.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = DeviceUrl.DEVICE_CONTROLLER_ROOT)
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TestingRepository testingRepository;

    @Autowired
    private Operation operation;

    @PostMapping(value = DeviceUrl.DEVICE_CONTROLLER_ADD_DEVICE)
    public ResponseEntity<Device> add(@RequestBody Device device) {
        deviceRepository.save(device);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @GetMapping(value = DeviceUrl.DEVICE_CONTROLLER_DEVICE)
    public ResponseEntity<Device> getDevice(@PathVariable("id") Integer id) {
        Device device = deviceRepository.findById(id).orElse(new Device());
        if (device.getId() < 0) {
            System.out.println();
        }
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PutMapping(value = DeviceUrl.DEVICE_CONTROLLER_DEVICE)
    public ResponseEntity<Device> update(@PathVariable("id") Integer id, @RequestBody Device device) {
        Device oldDevice = deviceRepository.findById(id).orElse(new Device());
        if (oldDevice.getId() > 0) {
            device.setId(oldDevice.getId());
            deviceRepository.save(device);
        }
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @DeleteMapping(value = DeviceUrl.DEVICE_CONTROLLER_DEVICE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Device oldDevice = deviceRepository.findById(id).orElse(new Device());
        if (oldDevice.getId() > 0) {
            deviceRepository.delete(oldDevice);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = DeviceUrl.DEVICE_CONTROLLER_DEVICES)
    public ResponseEntity<List<Device>> getDevices() {
        Iterable<Device> all = deviceRepository.findAll();
        List<Device> list = new ArrayList<>();
        for (Device device : all) {
            if (device.getId() > 0) {
                list.add(device);
            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
