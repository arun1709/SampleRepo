FROM openjdk:8-jdk-alpine
COPY target/*.jar myproduct-service-0.1-Release.jar
ENTRYPOINT ["run.sh"]
