FROM openjdk:8-jre-alpine
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

ADD ./target/charger-network-manager-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./charger-network-manager-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/charger-network-manager-entrypoint.sh

EXPOSE 8103