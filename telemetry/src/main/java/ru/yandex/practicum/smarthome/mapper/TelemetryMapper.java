package ru.yandex.practicum.smarthome.mapper;


import org.mapstruct.Mapper;
import ru.yandex.practicum.smarthome.dto.TelemetryDto;
import ru.yandex.practicum.smarthome.entity.TelemetryData;

@Mapper(componentModel = "spring")
public interface TelemetryMapper {
    TelemetryDto data2dto(TelemetryData data);

    TelemetryData dto2data(TelemetryDto data);
}
