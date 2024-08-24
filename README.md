# Базовая настройка

## Запуск minikube

[Инструкция по установке](https://minikube.sigs.k8s.io/docs/start/)

```bash
minikube start
```


## Добавление токена авторизации GitHub

[Получение токена](https://github.com/settings/tokens/new)

```bash
kubectl create secret docker-registry ghcr --docker-server=https://ghcr.io --docker-username=<github_username> --docker-password=<github_token> -n default
```


## Установка API GW kusk

[Install Kusk CLI](https://docs.kusk.io/getting-started/install-kusk-cli)

```bash
kusk cluster install
```


## Настройка terraform

[Установите Terraform](https://yandex.cloud/ru/docs/tutorials/infrastructure-management/terraform-quickstart#install-terraform)


Создайте файл ~/.terraformrc

```hcl
provider_installation {
  network_mirror {
    url = "https://terraform-mirror.yandexcloud.net/"
    include = ["registry.terraform.io/*/*"]
  }
  direct {
    exclude = ["registry.terraform.io/*/*"]
  }
}
```

## Применяем terraform конфигурацию 

```bash
cd terraform
terraform apply
```

## Настройка API GW

```bash
kusk deploy -i api.yaml
```

## Проверяем работоспособность

```bash
kubectl port-forward svc/kusk-gateway-envoy-fleet -n kusk-system 8080:80
curl localhost:8080/hello
```


## Delete minikube

```bash
minikube delete
```

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