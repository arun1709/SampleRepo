FROM openjdk:8
COPY target/*.jar myproduct-service-0.1-Release.jar
ENTRYPOINT ["java", "-jar", "myproduct-service-0.1-Release.jar" ]
