package ru.yandex.practicum.smarthome.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.service.TelemetryService;

@Component
@RequiredArgsConstructor
public class TelemetryKafkaListener {
    private final TelemetryService telemetryService;

    @KafkaListener(topics = "${kafka.topic.telemetry}", groupId = "default-kafka-group")
    public void listen(TelemetryDto telemetryData) {
        telemetryService.create(telemetryData);
    }
}