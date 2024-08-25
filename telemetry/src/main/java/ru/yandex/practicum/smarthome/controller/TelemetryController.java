package ru.yandex.practicum.smarthome.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.exception.DataIsNotFound;
import ru.yandex.practicum.smarthome.service.TelemetryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TelemetryController {

    private final TelemetryService telemetryService;

    @PostMapping("/devices/{deviceId}/telemetry")
    public ResponseEntity<Void> saveTelemetry(
            @PathVariable Long deviceId,
            @RequestBody TelemetryDto telemetryDto) {

        telemetryDto.setDeviceId(deviceId);
        telemetryService.create(telemetryDto);

        log.info(String.format("create telemetry for device id '%s'", deviceId));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/devices/{deviceId}/telemetry/latest")
    public ResponseEntity<TelemetryDto> getLatestTelemetry(@PathVariable Long deviceId) {
        TelemetryDto telemetryDto = telemetryService.getLatest(deviceId);

        log.info(String.format("request latest telemetry for device id '%s'", deviceId));
        return ResponseEntity.ok(telemetryDto);
    }

    @GetMapping("/devices/{deviceId}/telemetry")
    public ResponseEntity<List<TelemetryDto>> getTelemetryHistory(@PathVariable Long deviceId, @RequestParam("start_time") String startTime, @RequestParam("end_time") String endTime) {
        List<TelemetryDto> telemetryHistory = telemetryService.getHistory(deviceId, startTime, endTime);
        log.info(String.format("request history telemetry for device id %s", deviceId));
        return ResponseEntity.ok(telemetryHistory);
    }

    @ExceptionHandler(DataIsNotFound.class)
    public ResponseEntity notfoundException(DataIsNotFound exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.notFound().build();
    }
}