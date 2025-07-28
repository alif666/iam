package com.domain.alif.iam.device;


import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {

    public DeviceResponseDTO toDto(DeviceList device) {
        DeviceResponseDTO dto = new DeviceResponseDTO();
        dto.setId(device.getId());
        dto.setTeam(device.getTeam());
        dto.setTag(device.getTag());
        dto.setItemPackage(device.getItemPackage());
        dto.setDeskId(device.getDeskId());
        dto.setOfficeSpace(device.getOfficeSpace());
        dto.setCabinetNumber(device.getCabinetNumber());
        dto.setResponsibleName(device.getResponsibleName());
        dto.setName(device.getName());
        dto.setRefId(device.getRefId());
        dto.setCategory(device.getCategory());
        dto.setGroup(device.getGroup());
        dto.setRemark(device.getRemark());
        return dto;
    }
}
