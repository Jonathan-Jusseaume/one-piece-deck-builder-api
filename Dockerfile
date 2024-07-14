FROM maven:3.9.8 AS MAVEN_BUILD

COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre

ARG JAR_FILE=target/one-piece-deck-builder*.jar

COPY --from=MAVEN_BUILD /tmp/${JAR_FILE} /usr/local/bin/app.jar

WORKDIR /usr/local/bin/

ENV SERVER_PORT 8080

EXPOSE $SERVER_PORT

ENTRYPOINT [ "sh", "-c", "java -jar app.jar"]
