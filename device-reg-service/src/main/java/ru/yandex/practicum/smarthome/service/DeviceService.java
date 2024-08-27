package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.ActionDto;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.exception.DataIsNotFound;
import ru.yandex.practicum.smarthome.mapper.DataMapper;
import ru.yandex.practicum.smarthome.repository.DeviceRepository;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final DataMapper dataMapper;

    public void create(DeviceDto device) {
        deviceRepository.save(dataMapper.dto2data(device));
    }

    public DeviceDto getInfo(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .map(dataMapper::data2dto)
                .orElseThrow(DataIsNotFound::new);
    }

    public void delete(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    public Page<DeviceDto> getAll(Pageable pageable) {
        var page = deviceRepository.findAll(pageable);
        return page.map(dataMapper::data2dto);
    }

    public void action(Long deviceId, ActionDto actionDto) {
    }
}