package ru.yandex.practicum.smarthome.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telemetry_data")
@CompoundIndex(name = "timestamp_idx", def = "{'deviceId': 1, 'timestamp': -1}")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TelemetryData {

    @Id
    private String id;
    @Indexed
    private Long deviceId;
    private String timestamp;
    private JsonNode data;
}