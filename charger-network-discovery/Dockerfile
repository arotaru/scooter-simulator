FROM alpine-jdk:base
MAINTAINER Erik Rotaru <erikrotaru@gmail.com>

ADD ./target/charger-network-discovery-0.0.1-SNAPSHOT.jar /opt/lib/
ENV SPRING_APPLICATION_JSON: '{"spring": {"cloud": {"config": {"uri": "http://config-server:8101"}}}}'

CMD ["java", "-Xmx200m", "-jar", "/opt/lib/charger-network-discovery-0.0.1-SNAPSHOT.jar"]

EXPOSE 8102
