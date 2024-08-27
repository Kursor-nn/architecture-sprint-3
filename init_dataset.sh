#!/bin/bash

echo "Hello, world!!"

for i in {0..10}
do
  curl -X 'POST' \
    'http://localhost/devices' \
    -H 'accept: application/json' \
    -H 'Content-Type: application/json' \
    -d '{
    "id": 10,
    "name": "temp-sensor-'$i'",
    "type": "temperature",
    "serialNumber": "123345-'$i'",
    "modelName": "amazing-model",
    "manufacturer": "amazing-manufacturer"
  }'

  echo "Temperature sensor '$i' is added"
done;
