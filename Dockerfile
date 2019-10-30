FROM openjdk:8
COPY ./target/myproduct-service-0.0.1-SNAPSHOT.jar myproduct-service-0.1-Release.jar
CMD ["java", "-jar", "myproduct-service-0.1-Release.jar" ]