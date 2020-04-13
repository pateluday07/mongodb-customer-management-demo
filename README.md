# mongodb-customer-management-demo
This project is for a demonstration of how we can use 
the MongoDB in Spring Boot web application, 
here I am managing the customers, by performing CRUD 
operations.

###Requirements 
For building and running the application you need: 
* Git
* JDK 8 or later
* Gradle 6.3
* Spring Boot
* MongoDB
* Lombok
* MapStruct
* Apache Commons Lang
* Swagger
* IDE

###Running the application locally
1. Download the zip or clone the Git repository
2. Open **build.gradle** file from your favorite IDE
3. Select option **Open as Project** in your IDE
4. Start MongoDB
5. Config MongoDB properties from `src/main/resources/application.yml`
6. Go to the `com.mongodb.demo.CustomerMongodbDemoApplication` and run the class.
Or you can open the IDE terminal and simply run the following command
                
       gradlew bootrun

You can open the swagger to access the APIs: [Swagger] (http://localhost:8080/swagger-ui.html)