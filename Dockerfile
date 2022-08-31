FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=demo-0.0.1-SNAPSHOT.jar
WORKDIR /tmp
COPY /target/$JAR_FILE /tmp/application.jar
RUN java -Djarmode=layertools -jar application.jar extract

#Second stage for copy files
FROM adoptopenjdk:11-jre-hotspot
LABEL MAINTAINER = "Andres Florez"

RUN mkdir /app


COPY docker/opt /app

COPY --from=builder /tmp/dependencies /app/
COPY --from=builder /tmp/snapshot-dependencies/ /app/
COPY --from=builder /tmp/spring-boot-loader/ /app/
COPY --from=builder /tmp/application/ /app/

RUN useradd -l -u 1001 demospring \
    && chown -R demospring:demospring /app \
    && chmod +x /app/docker/bin/run_container

WORKDIR /app
EXPOSE 8080
USER demospring

ENTRYPOINT ["/app/docker/bin/run_container"]