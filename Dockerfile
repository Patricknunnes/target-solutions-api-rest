FROM maven:4.0.0-jdk-11

WORKDIR /target-solutions-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run