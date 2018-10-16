FROM openjdk:8-jre-alpine
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

ADD ./target/charger-client-discovery-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./config-discovery-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/config-discovery-entrypoint.sh

EXPOSE 8762