package com.domain.alif.iam.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceListRepository extends JpaRepository<DeviceList, Long> {
}
