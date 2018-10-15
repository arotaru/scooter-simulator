#!/bin/sh

while ! nc -z charger-network-gateway 8100 ; do
    echo "Waiting for upcoming API Gateway Server"
    sleep 60
done

java -jar /opt/lib/charger-network-manager-0.0.1-SNAPSHOT.jar

