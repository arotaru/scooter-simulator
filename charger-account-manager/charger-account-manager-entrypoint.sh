#!/bin/sh

while ! nc -z charger-network-gateway 8100 ; do
    echo "Waiting another 60 seconds for upcoming API Gateway Server"
    sleep 60
done

java -Dspring.data.mongodb.uri=$MONGODB_URI -jar /opt/lib/charger-account-manager-0.0.1-SNAPSHOT.jar