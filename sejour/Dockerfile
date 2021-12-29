#FROM openjdk:17-alpine
#COPY target/*.jar app.jar
#EXPOSE 8027
#CMD ["java","-jar","app.jar"]

FROM openjdk:17-alpine
ARG JAR_FILE=target/taxe-sejour.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8027