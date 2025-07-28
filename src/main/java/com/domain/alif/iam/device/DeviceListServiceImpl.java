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
    public List<DeviceList> getPaginatedDevices(int from, int size) {
        return repository.findAll()
                .stream()
                .skip(from)
                .limit(size)
                .toList(); // Java 16+ or use Collectors.toList() for older
    }

    @Override
    public DeviceList getDeviceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found with ID: " + id));
    }

    @Override
    public DeviceList createDevice(DeviceList device) {
        return repository.save(device);
    }

    @Override
    public DeviceList updateDevice(Long id, DeviceList device) {
        DeviceList existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found with ID: " + id));

        if (device.getTeam() != null) existing.setTeam(device.getTeam());
        if (device.getTag() != null) existing.setTag(device.getTag());
        if (device.getItemPackage() != null) existing.setItemPackage(device.getItemPackage());
        if (device.getDeskId() != null) existing.setDeskId(device.getDeskId());
        if (device.getOfficeSpace() != null) existing.setOfficeSpace(device.getOfficeSpace());
        if (device.getCabinetNumber() != null) existing.setCabinetNumber(device.getCabinetNumber());
        if (device.getResponsibleName() != null) existing.setResponsibleName(device.getResponsibleName());
        if (device.getName() != null) existing.setName(device.getName());
        if (device.getRefId() != null) existing.setRefId(device.getRefId());
        if (device.getCategory() != null) existing.setCategory(device.getCategory());
        if (device.getGroup() != null) existing.setGroup(device.getGroup());
        if (device.getRemark() != null) existing.setRemark(device.getRemark());

        return repository.save(existing);
    }

    @Override
    public void deleteDevice(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Device not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
