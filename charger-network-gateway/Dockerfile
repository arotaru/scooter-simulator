FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

RUN apk --no-cache add netcat-openbsd
ADD ./target/charger-network-gateway-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./config-gateway-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/config-gateway-entrypoint.sh

EXPOSE 8100