FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

COPY ./target/charger-network-config-0.0.1-SNAPSHOT.jar /opt/lib/
VOLUME /src/main/resources/
CMD ["java", "-Xmx200m", "-jar", "/opt/lib/charger-network-config-0.0.1-SNAPSHOT.jar"]


EXPOSE 8101
