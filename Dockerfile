FROM ubuntu:18.04

COPY backend/target/backend-0.0.1-SNAPSHOT.jar  /app.jar
COPY frontend /frontend

RUN apt-get update \
    && apt-get install --yes nodejs \
    && apt-get install --yes openjdk-8-jdk


CMD java -jar app.jar
WORKDIR /frontend

CMD npm install \
    && run start

EXPOSE 4200