FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /home
COPY src games/src
COPY pom.xml games
RUN mvn -f games/pom.xml clean package

FROM openjdk:8-jre-slim
COPY --from=build /home/games/target/games-0.0.1-SNAPSHOT.jar /home/games.jar 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/games.jar"]