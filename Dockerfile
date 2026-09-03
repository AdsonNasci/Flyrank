FROM eclipse-temurin:21
LABEL maintainer="adsonchristopher@gmail.com"
WORKDIR /app

COPY . .
#RUN chmod +x mvnw && ./mvnw clean -DskipTests package

RUN cp target/ANDREYAPP-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]