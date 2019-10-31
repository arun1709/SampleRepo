FROM openjdk:8
COPY /var/lib/jenkins/workspace/docker-build-pipe-line/target/myproduct-service-0.0.1-SNAPSHOT.jar myproduct-service-0.1-Release.jar
CMD ["java", "-jar", "myproduct-service-0.1-Release.jar" ]
