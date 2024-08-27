package ru.yandex.practicum.smarthome.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.UUID;

@Data
public class TelemetryDto {
    private String timestamp;
    private Long deviceId;
    private JsonNode data;
}
