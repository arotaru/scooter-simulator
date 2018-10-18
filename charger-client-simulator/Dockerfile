FROM openjdk:8-jre-alpine
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

ADD ./target/charger-client-simulator-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./charger-client-simulator-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/charger-client-simulator-entrypoint.sh

EXPOSE 8105