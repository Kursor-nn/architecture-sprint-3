package ru.yandex.practicum.smarthome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.entity.TelemetryData;
import ru.yandex.practicum.smarthome.exception.DataIsNotFound;
import ru.yandex.practicum.smarthome.mapper.TelemetryMapper;
import ru.yandex.practicum.smarthome.repository.TelemetryDataRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TelemetryService {
    private final TelemetryMapper telemetryMapper;
    private final TelemetryDataRepository telemetryDataRepository;

    public void create(TelemetryDto telemetryDTO) {
        TelemetryData telemetryData = telemetryMapper.dto2data(telemetryDTO);
        telemetryDataRepository.save(telemetryData);
    }

    public TelemetryDto getLatest(Long deviceId) {
        Optional<TelemetryData> telemetryData = telemetryDataRepository.findTopByDeviceIdOrderByTimestampDesc(deviceId);
        return telemetryData.map(telemetryMapper::data2dto)
                .orElseThrow(() -> new DataIsNotFound(String.format("Telemetry not found: {}", deviceId)));
    }

    public List<TelemetryDto> getHistory(Long deviceId, String startTime, String endTime) {
        List<TelemetryData> telemetryDataList = telemetryDataRepository.findByDeviceIdAndTimestampBetween(deviceId, startTime, endTime);
        return telemetryDataList.stream().map(telemetryMapper::data2dto).collect(Collectors.toList());
    }
}
