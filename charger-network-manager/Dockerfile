FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

RUN apk --no-cache add netcat-openbsd
ADD ./target/charger-network-manager-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./charger-network-manager-gateway-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/charger-network-manager-gateway-entrypoint.sh

EXPOSE 8103