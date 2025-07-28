package com.domain.alif.iam.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceListController {

    @Autowired
    private DeviceListService service;

    /**
     * Get all devices
     */
    @GetMapping
    public List<DeviceList> getAllDevices() {
        return service.getAllDevices();
    }

    /**
     * Get devices with pagination support
     */
    @GetMapping("/paginated")
    public List<DeviceList> getPaginatedDevices(
            @RequestParam int from,
            @RequestParam int end) {
        return service.getPaginatedDevices(from, end);
    }

    /**
     * Get a device by ID
     */
    @GetMapping("/{id}")
    public DeviceList getDeviceById(@PathVariable Long id) {
        return service.getDeviceById(id);
    }

    /**
     * Create a new device entry
     */
    @PostMapping
    public DeviceList createDevice(@RequestBody DeviceList deviceList) {
        return service.createDevice(deviceList);
    }

    /**
     * Update an existing device
     */
    @PutMapping("/{id}")
    public DeviceList updateDevice(
            @PathVariable Long id,
            @RequestBody DeviceList deviceList) {
        return service.updateDevice(id, deviceList);
    }

    /**
     * Delete a device by ID
     */
    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        service.deleteDevice(id);
    }
}
