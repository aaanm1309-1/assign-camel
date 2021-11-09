FROM openjdk:11-jre-slim

WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE} /app/assign.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","assign.jar"]

#CMD ["java","-jar","assign.jar"]