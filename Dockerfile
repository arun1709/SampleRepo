FROM openjdk:8
COPY target/*.jar myproduct-service-0.1-Release.jar
CMD ["java", "-jar", "myproduct-service-0.1-Release.jar" ]
