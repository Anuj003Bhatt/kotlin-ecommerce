# Order ECommerce SpringBoot Kotlin App

This service interacts with postgresDB to perform CRUD ops for order data

#### Make sure Java 17 and Docker is installed on your machine (https://www.docker.com/products/docker-desktop/)

## Building the app
```
     ./gradlew clean build
```
## Running the app : (choose one of the following method)

#### 1. Run docker-compose to start both postgres and springboot app 
```
    docker-compose up   
    docker container ls 
```
#### 2. Run the app in IDE while postgres runs in the docker container
```
      docker-compose up postgres
```
Make appropriate changes to datasource in application.yml file 
Start the SpringBootApp in IDE using the following env args

    -Dspring.datasource.orderecommercedb.url= jdbc:postgresql://localhost:5432/orderecommerce_db?currentSchema=public
    -Dspring.datasource.orderecommercedb.name= orderecommerceuser
    -Dspring.datasource.orderecommercedb.password= orderecommercepwd
    -Dspring.datasource.orderecommercedb.hikari.connectiontimeout=60000
    -Dspring.datasource.orderecommercedb.hikari.maximumpoolsize=5
    -Dspring.datasource.orderecommercedb.hikari.poolname=orderecommercedb
    -Dspring.datasource.orderecommercedb.hikari.autocommit=false
    -Dservice.name=orderecommerce
    -Dspring_application_context_path=/order-ecommerce

Note:

* All the env args are specified in the docker-env-file
* PostgresSQL startup create script is specified within DockerCompose [setup.sql](setup.sql)
* Verify running instances from Docker Desktop
    
## Swagger : Use to validate API end points 
http://localhost:8080/order-ecommerce/swagger-ui/index.html

## Basic understanding of the flow
![img.png](Egen_Ecommerce.jpg)

## Improvements and Corrections in branch
- Added a flow chart with the understanding of the flow
- Enabled AspectJ auto proxy.
- Created a new annotation `Loggable` to automate some logging acroos service, like API calls, service calls etc.
- Implemented the Aspect in `LoggingAspect`.
- Across the service modified injections that need not be private to controll access
- Modified service layer to have interface segregation.
  - The `ProductService` and `OrderService` are now interfaces
  - There are new implementations `ProductServicePgImpl` and `OrderServicePgImpl` that basically now are postgres specific implementations.
  - Having this segragation allows service to be scalable across multiple data sources loading site specific implementations using configurations.
- Modified controllers 
  - To include `orders` and `products` at the top level resource rather than at functions.
    - No need for these at functions level
  - Returned DTOs from service layer to abstract entities from Data access layer
  - Across all APIs add operations summary and description for swagger
  - Added new APIs to:
    - Get list of all products
    - Update product information
    - Get list of all orders
  - Inside repository added capability for searching product matching input title string.
- Added controller advice, to handle error responses from APIs.
  - This is not yet scaled to all possible scenarios and code flows.
- Apart from all above, removed lombok `NonNull` annotations as not needed in kotlin when declaration is already non nullable.
- Added new DTOs for entities and made data transfers across service consistent using DTOs (Not exposing entire entities out)

