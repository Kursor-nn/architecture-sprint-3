package ru.yandex.practicum.smarthome.exception;

public class DataIsNotFound extends RuntimeException {
    public DataIsNotFound(String message) {
        super(message);
    }
}
