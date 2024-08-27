package ru.yandex.practicum.smarthome.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.ActionDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.service.DeviceService;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping(value = "/devices", produces = "application/json")
    public Page<DeviceDto> getAll(Pageable pageable) {
        log.info("Get all devices {}", pageable);
        return deviceService.getAll(pageable);
    }

    @PostMapping("/devices")
    public ResponseEntity<Void> create(@RequestBody DeviceDto device) {
        log.info("Create device {}", device);
        deviceService.create(device);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/devices/{device_id}")
    public ResponseEntity<DeviceDto> getInfo(@PathVariable("device_id") Long deviceId) {
        log.info("Get device {}", deviceId);
        DeviceDto device = deviceService.getInfo(deviceId);
        return ResponseEntity.ok(device);
    }


    @DeleteMapping("/devices/{device_id}")
    public ResponseEntity<Void> delete(@PathVariable("device_id") Long deviceId) {
        log.info("Delete device {}", deviceId);
        deviceService.delete(deviceId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/devices/{device_id}/action")
    public ResponseEntity<Void> doAction(@PathVariable("device_id") Long deviceId, @RequestBody ActionDto action) {
        log.info("Do action {} for device {}", action, deviceId);
        deviceService.action(deviceId, action);
        return ResponseEntity.ok().build();
    }
}
