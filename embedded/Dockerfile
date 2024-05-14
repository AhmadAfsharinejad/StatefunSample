FROM apache/flink-statefun:3.2.0

RUN mkdir -p /opt/statefun/modules/my-embedded

ADD flink-conf.yaml $FLINK_HOME/conf/flink-conf.yaml

COPY target/embedded-jar-with-dependencies.jar /opt/statefun/modules/my-embedded/embedded-jar-with-dependencies.jar
