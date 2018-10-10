#!/bin/sh
  
while ! nc -z charger-network-config 8101 ; do
    echo "Waiting for upcoming Config Server"
    sleep 60
done
while ! nc -z charger-network-discovery 8102 ; do
    echo "Waiting for upcoming Discovery Server"
    sleep 60
done

java -jar /opt/lib/charger-network-gateway-0.0.1-SNAPSHOT.jar
