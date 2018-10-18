#!/bin/sh

while ! nc -z charger-network-gateway 8100 ; do
    echo "Waiting another 120 seconds for upcoming API Gateway Server"
    sleep 120
done

java -jar /opt/lib/charger-client-simulator-0.0.1-SNAPSHOT.jar
