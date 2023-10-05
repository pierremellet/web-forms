FROM node:20.4.0 as frontend_builder

WORKDIR /app
COPY frontend .
RUN npm install && npm run build:ui


FROM maven:3.9-amazoncorretto-17-debian as backend_builder

WORKDIR /app
COPY backend .
RUN mvn install


FROM amazoncorretto:17.0.8-alpine as runner

ENV SPRING_WEB_RESOURCES_STATIC-LOCATIONS=file:/app/frontend
WORKDIR /app
COPY --from=frontend_builder /app/build /app/frontend
COPY --from=backend_builder /app/target/*.jar /app/backend/server.jar
CMD java -jar /app/backend/server.jar