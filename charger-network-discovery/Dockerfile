FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>
RUN apk --no-cache add netcat-openbsd
ADD ./target/charger-network-discovery-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./config-client-entrypoint.sh /opt/bin/
RUN chmod 755 /opt/bin/config-client-entrypoint.sh
