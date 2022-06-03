FROM maven:3.8.5-jdk-11

WORKDIR /bbdd2PromocionApp-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run