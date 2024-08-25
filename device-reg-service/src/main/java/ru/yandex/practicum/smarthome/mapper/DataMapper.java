package ru.yandex.practicum.smarthome.mapper;


import org.mapstruct.Mapper;
import ru.yandex.practicum.smarthome.dto.DeviceDto;
import ru.yandex.practicum.smarthome.entity.DeviceData;

@Mapper(componentModel = "spring")
public interface DataMapper {
    DeviceDto data2dto(DeviceData data);

    DeviceData dto2data(DeviceDto dto);
}
