FROM node:20.4.0 as frontend_builder
WORKDIR /app
COPY . .
RUN npm install && npm run build:ui

FROM bitnami/nginx:latest as runner
COPY --from=frontend_builder /app/build /app