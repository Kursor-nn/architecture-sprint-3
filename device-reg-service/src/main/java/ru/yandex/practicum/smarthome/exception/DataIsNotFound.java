package ru.yandex.practicum.smarthome.exception;

public class DataIsNotFound extends RuntimeException {
    public DataIsNotFound() {
        super("Device is not found");
    }
}
