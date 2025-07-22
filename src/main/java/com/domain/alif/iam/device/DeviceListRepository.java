package com.domain.alif.iam.device;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceListRepository extends JpaRepository<DeviceList, Long> {
   
    @Query(value = "SELECT * FROM device_list LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<DeviceList> getPaginatedDeviceList(int from, int size);
}
