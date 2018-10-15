#!/bin/sh

while ! nc -z charger-network-discovery 8761 ; do
    echo "Waiting for upcoming Discovery Server"
    sleep 90
done

java -jar /opt/lib/charger-network-gateway-0.0.1-SNAPSHOT.jar