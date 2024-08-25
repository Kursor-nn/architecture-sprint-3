package ru.yandex.practicum.smarthome.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.smarthome.dto.HeatingActionDto;
import ru.yandex.practicum.smarthome.service.HeatingSystemService;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelemetryKafkaListener {
    private final HeatingSystemService heatingSystemService;

    @KafkaListener(topics = "${kafka.topic.heating}", groupId = "heating-group")
    public void listen(HeatingActionDto action) {
        log.info(String.format("Device '%s' is triggered by action '%s'", action.getId(), action.getAction()));
        if("turn_on".equals(action.getAction())){
            heatingSystemService.turnOn(action.getId());
        } else {
            heatingSystemService.turnOff(action.getId());
        }
    }
}