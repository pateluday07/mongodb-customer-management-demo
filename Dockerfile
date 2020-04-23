FROM openjdk:8-jdk-alpine

MAINTAINER pateluday07@gmail.com

COPY ./build/libs/customer-mongodb-demo-0.0.1-SNAPSHOT.jar customer-mongodb-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://customer_management_demo_mongodb/customers_management_demo","-Djava.security.egd=file:/dev/./urandom","-jar","/customer-mongodb-demo-0.0.1-SNAPSHOT.jar"]