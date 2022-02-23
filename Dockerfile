FROM maven:3-jdk-11
VOLUME /tmp
ADD /target/*.jar app.jar
EXPOSE 8080/tcp
EXPOSE 10250/tcp
ENTRYPOINT ["java","-jar","/app.jar"]