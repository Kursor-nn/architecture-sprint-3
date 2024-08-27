# Базовая настройка
Для запуска стенда:
1. проверить что запущен Docker
2. docker-compose up -d
3. подождать инициализации стека
3. для инициализации базовых устройств: 
- init_dataset.sh 
4. Swagger будет доступен по адресу http://localhost:8080/swagger-ui

## Текущая реализация
### Текущая функциональность приложения:

- Получение конфигурации/обновление конфигурации отопления
- Включение/отключение отопления
- Получение текущей температуры

### Домены монолитного приложения:

- Конфигурация отопления
- Сбор метрик температуры

### Должны быть учтены домены:
- Регистрация устройств
- Телеметрия
- Данные пользователя
- управление внешними устройствами

------------

## ToBe

# Описание системы
## Компоненты системы
### API Gateway

API Gateway - реализует концепцию единой точки входа в систему

### Input Device API
Принимает данные от устройств, валидирует и отправляет в обработчики через кафку.

### Telemetry Service

Собирает и предоставляет данные делеметрии по запросу

### Device Registration Service

Сервис регистрации новых устройств в системе 

### Kafka

Message bus - для хранения и транспортировки событий потребителям

### Описание текущего дизайна
- [Контекст](docs%2F1_actual%2F1_context.puml)
- [Контейнеры](docs%2F1_actual%2F2_container.puml)

### Описание целевого дизайна
* [Контекст](docs%2F2_future%2F1_context%2F1_context.puml)
* [Контейнер](docs%2F2_future%2F2_container%2F2_container.puml)
* Компоненты:
  1. [API Gateway](docs%2F2_future%2F3_components%2F1_api_gateway.puml)
  2. [Telemetry](docs%2F2_future%2F3_components%2F2_telemetry.puml)
  3. [Device Registration Service](docs%2F2_future%2F3_components%2F3_device_registration_service.puml)
  4. [Sensor Handler](docs%2F2_future%2F3_components%2F4_sensor_event_handler_service.puml)
  5. [Boiler Handler](docs%2F2_future%2F3_components%2F5_boiler_event_handler_service.puml)
* [Device Registration Service Code.puml](docs%2F2_future%2F4_code%2F1_device_registration_service.puml)
* [ER Диаграмма](docs%2F2_future%2Ftask_1.3_er.puml)