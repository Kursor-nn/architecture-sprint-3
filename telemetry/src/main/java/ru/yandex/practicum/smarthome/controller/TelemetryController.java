package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heating")
@RequiredArgsConstructor
public class TelemetryController {
    private static final Logger logger = LoggerFactory.getLogger(TelemetryController.class);
}
