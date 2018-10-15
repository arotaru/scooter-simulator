FROM openjdk:8-jre-alpine
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

ADD ./target/charger-network-gateway-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./config-gateway-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/config-gateway-entrypoint.sh

EXPOSE 8100