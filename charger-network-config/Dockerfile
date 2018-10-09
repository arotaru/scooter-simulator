FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

COPY ./target/charger-network-config-0.0.1-SNAPSHOT.jar /opt/lib/
ENV SPRING_APPLICATION_JSON='{"spring": {"cloud": {"config": {"server": {"git": {"uri": "/var/lib/spring-cloud/config-repo", "clone-on-start": true}}}}}}'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/charger-network-config-0.0.1-SNAPSHOT.jar"]
VOLUME /var/lib/spring-cloud/config-repo

EXPOSE 8101
