FROM maven:3.9-amazoncorretto-17-debian as backend_builder

WORKDIR /app
COPY . .
RUN mvn install


FROM amazoncorretto:17.0.8-alpine as runner

WORKDIR /app
COPY --from=backend_builder /app/target/*.jar /app/backend/server.jar
CMD java -jar /app/backend/server.jar