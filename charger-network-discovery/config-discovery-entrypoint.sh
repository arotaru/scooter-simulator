#!/bin/sh

while ! nc -z charger-network-config 8101 ; do
    echo "Waiting for upcoming Config Server"
    sleep 10
done

java -jar /opt/lib/charger-network-discovery-0.0.1-SNAPSHOT.jar
