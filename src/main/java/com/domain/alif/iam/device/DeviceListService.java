package com.domain.alif.iam.device;

import java.util.List;

public interface DeviceListService {
    
    List<DeviceList> getAllDevices();

    List<DeviceList> getAllDevicesPaginateDeviceLists(int from, int size);

    DeviceList getDeviceById(Long id);

    DeviceList createDevice(DeviceList d);

    DeviceList updateDevice(Long id, DeviceList d );

    void deleteDevice(Long id);
}
