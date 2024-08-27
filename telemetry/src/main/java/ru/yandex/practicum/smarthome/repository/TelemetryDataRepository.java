package ru.yandex.practicum.smarthome.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.smarthome.entity.TelemetryData;

import java.util.List;
import java.util.Optional;

@Repository
public interface TelemetryDataRepository extends MongoRepository<TelemetryData, String> {
    List<TelemetryData> findByDeviceIdAndTimestampBetween(Long deviceId, String startTime, String endTime);

    Optional<TelemetryData> findTopByDeviceIdOrderByTimestampDesc(Long deviceId);
}
