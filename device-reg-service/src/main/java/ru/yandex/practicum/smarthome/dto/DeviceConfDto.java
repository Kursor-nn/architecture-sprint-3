package ru.yandex.practicum.smarthome.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class DeviceConfDto {
    private String type;
    private JsonNode parameters;
}
