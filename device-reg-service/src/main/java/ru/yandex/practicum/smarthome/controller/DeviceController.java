package ru.yandex.practicum.smarthome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.smarthome.dto.ActionDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.service.DeviceService;

@RestController
@RequestMapping("/api/v1")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/devices")
    public ResponseEntity<Void> create(@RequestBody DeviceDto deviceDTO) {
        deviceService.create(deviceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/devices/{device_id}")
    public ResponseEntity<DeviceDto> getInfo(@PathVariable("device_id") Long deviceId) {
        DeviceDto device = deviceService.getInfo(deviceId);
        return ResponseEntity.ok(device);
    }

    @PostMapping("/devices/{device_id}/action")
    public ResponseEntity<Void> doAction(@PathVariable("device_id") Long deviceId, @RequestBody ActionDto action) {
        deviceService.action(deviceId, action);
        return ResponseEntity.ok().build();
    }
}
