package ru.yandex.practicum.smarthome.dto;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class HeatingActionDto {
    private Long id;
    private String action;
}
