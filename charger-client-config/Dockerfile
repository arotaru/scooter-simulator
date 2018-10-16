FROM openjdk:8-jre-alpine
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

COPY ./target/charger-client-config-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/charger-client-config-0.0.1-SNAPSHOT.jar"]
VOLUME /var/lib/charger-client/config-repo

EXPOSE 8081