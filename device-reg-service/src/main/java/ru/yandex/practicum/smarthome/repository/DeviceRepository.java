package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.smarthome.entity.DeviceData;

public interface DeviceRepository extends JpaRepository<DeviceData, Long> {
}
