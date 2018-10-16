#!/bin/sh

while ! nc -z charger-client-config 8081 ; do
    echo "Waiting for upcoming Config Server"
    sleep 10
done

java -jar /opt/lib/charger-client-discovery-0.0.1-SNAPSHOT.jar