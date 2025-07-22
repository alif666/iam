package com.domain.alif.iam.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    private DeviceListRepository repository;

    @Override
    public List<DeviceList> getAllDevices() {
        return repository.findAll();
    }   

    @Override
    public DeviceList getDeviceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found with id: " + id));
    }

    @Override
    public DeviceList createDevice(DeviceList device) {
        return repository.save(device);
    }

    @Override
    public DeviceList updateDevice(Long id, DeviceList device) {
        DeviceList existingDevice = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found with id: " + id));
     
        if (device.getItemName() != null) {
            existingDevice.setItemName(device.getItemName());
        }
        if (device.getItemDescription() != null) {
            existingDevice.setItemDescription(device.getItemDescription());
        }
        if (device.getItemTag() != null) {
            existingDevice.setItemTag(device.getItemTag());
        }        
        if (device.getItemPackage() != null) {
            existingDevice.setItemPackage(device.getItemPackage());
        }
        if (device.getItemResponsibleId() != null) {
            existingDevice.setItemResponsibleId(device.getItemResponsibleId());
        }
        if (device.getItemRefId() != null) {
            existingDevice.setItemRefId(device.getItemRefId());
        }
        if (device.getItemCategory() != null) {
            existingDevice.setItemCategory(device.getItemCategory());
        }   
     
        return repository.save(existingDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Device not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<DeviceList> getAllDevicesPaginateDeviceLists(int from, int size) {
        return repository.getPaginatedDeviceList(from, size);
    }

    

}
