FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

RUN mkdir /var/lib/config-repo
COPY ./target/charger-network-config-0.0.1-SNAPSHOT.jar /opt/lib/
ENV SPRING_APPLICATION_JSON='{"spring": {"cloud": {"config": {"server": {"git": {"uri": "/var/lib/config-repo", "clone-on-start": true}}}}}}'

CMD ["java", "-Xmx200m", "-jar", "/opt/lib/charger-network-config-0.0.1-SNAPSHOT.jar"]

VOLUME /var/lib/config-repo

EXPOSE 8101
