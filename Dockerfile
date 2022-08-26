FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employee-service.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar","/employee-service.jar"]
