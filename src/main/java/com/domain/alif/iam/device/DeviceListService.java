package com.domain.alif.iam.device;

import java.util.List;

public interface DeviceListService {

    List<DeviceList> getAllDevices();

    List<DeviceList> getPaginatedDevices(int from, int size);

    DeviceList getDeviceById(Long id);

    DeviceList createDevice(DeviceList device);

    DeviceList updateDevice(Long id, DeviceList device);

    void deleteDevice(Long id);
}
