package ru.yandex.practicum.smarthome.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TelemetryDto {
    private String timestamp;
    private Long deviceId;
    private JsonNode data;
}
