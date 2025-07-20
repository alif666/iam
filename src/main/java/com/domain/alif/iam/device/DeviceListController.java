package com.domain.alif.iam.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
public class DeviceListController {

    @Autowired
    private DeviceListService service;

    @GetMapping
    public List<DeviceList> getAll() {
        return service.getAllDevices();
    }

    @GetMapping("/{id}")
    public DeviceList getById(@PathVariable Long id) {
        return service.getDeviceById(id);
    }

    @PostMapping
    public DeviceList create(@RequestBody DeviceList deviceList) {
        return service.createDevice(deviceList);
    }

    @PutMapping("/{id}")
    public DeviceList update(@PathVariable Long id, @RequestBody DeviceList deviceList) {
        return service.updateDevice(id, deviceList);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDevice(id);
    }
}