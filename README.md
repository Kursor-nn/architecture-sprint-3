# Базовая настройка
Для запуска стенда:
1. проверить что запущен Docker
2. docker-compose up -d
3. Swagger будет доступен по адресу http://localhost:8085

## Домены
### Home Controller
#### Задание 1.1:

* Heating Controller - предоставляет API системы
* Heating Service - управляет температурой и отоплением

[Общая схема текущего решения](docs%2Fmonolit%2Ftask_1.1.puml)

#### Задание 1.2:
Схемы:
[Схема компонент](docs%2Ftask_1.2_components.puml)
[Схема контейнеров](docs%2Ftask_1.2_containers.puml)
[Поток данных](docs%2Ftask_1.2_sensor_data_road.puml)

#### Задание 1.3:
Схемы:
[Описание сущностей системы](docs%2Ftask_1.3_er.puml)

#### Задание 1.4:
System API:
[task_1.4_command_swagger.yaml](docs%2Ftask_1.4_command_swagger.yaml)