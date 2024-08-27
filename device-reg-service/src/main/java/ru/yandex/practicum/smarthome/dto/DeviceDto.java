package ru.yandex.practicum.smarthome.dto;

import lombok.Data;
import ru.yandex.practicum.smarthome.entity.DeviceData;

@Data
public class DeviceDto {
    private Long id;
    private String name;
    private String type;
    private String serialNumber;
    private String modelName;
    private String manufacturer;
}
