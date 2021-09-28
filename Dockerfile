#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/blogs-0.0.1-SNAPSHOT.jar /usr/local/lib/blogs.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/usr/local/lib/blogs.jar"]