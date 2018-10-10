#!/bin/sh
  
while ! nc -z charger-network-config 8101 ; do
    echo "Waiting for upcoming Config Server"
    sleep 60
done
while ! nc -z charger-network-discovery 8102 ; do
    echo "Waiting for upcoming Discovery Server"
    sleep 60
done
while ! nc -z charger-network-gateway 8100 ; do
    echo "Waiting for upcoming API Gateway Server"
    sleep 30

java -jar /opt/lib/charger-network-manager-0.0.1-SNAPSHOT.jar

