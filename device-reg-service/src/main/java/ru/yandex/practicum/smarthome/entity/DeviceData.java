package ru.yandex.practicum.smarthome.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "devices")
public class DeviceData {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String serialNumber;
    private String modelName;
    private String manufacturer;
}
