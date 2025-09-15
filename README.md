# Motoshop
A small test project of a motorbike shop management system

## Content
* [General info](#general-info)
* [Demonstration](#demonstration)
* [Technologies](#technologies)
* [Features](#features)
* [Setup](#setup)

---

## General info
Motoshop is an educational web application store for managing motorcycles and spare parts.  
It is implemented on **Spring Boot** using **PostgreSQL** as a database.  
The project demonstrates working with REST API, Spring Data JPA, and interacting with clients and transactions.

---

## Demonstration
The application runs at `http://localhost:8082`.  
After launch, the REST API is available for working with entities (motorcycles, spare parts, customers, transactions).  
Later, you can connect the frontend or test requests via Postman/Swagger.

```
 :: Spring Boot ::                (v3.2.3)

2025-09-15T10:28:44.812+02:00  INFO 18384 --- [shop_lera] [  restartedMain] pl.dmcs.shop.ShopApplication             : Starting ShopApplication using Java 23.0.1 with PID 18384 (C:\Users\vdoro\IdeaProjects\shop 1\shop\target\classes started by vdoro in C:\Users\vdoro\IdeaProjects\shop 1)
2025-09-15T10:28:44.822+02:00  INFO 18384 --- [shop_lera] [  restartedMain] pl.dmcs.shop.ShopApplication             : No active profile set, falling back to 1 default profile: "default"
2025-09-15T10:28:45.033+02:00  INFO 18384 --- [shop_lera] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2025-09-15T10:28:45.034+02:00  INFO 18384 --- [shop_lera] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2025-09-15T10:28:49.297+02:00  INFO 18384 --- [shop_lera] [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-09-15T10:28:49.482+02:00  INFO 18384 --- [shop_lera] [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 170 ms. Found 4 JPA repository interfaces.
2025-09-15T10:28:51.270+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8082 (http)
2025-09-15T10:28:51.295+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-09-15T10:28:51.295+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2025-09-15T10:28:51.396+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-09-15T10:28:51.397+02:00  INFO 18384 --- [shop_lera] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 6361 ms
2025-09-15T10:28:52.292+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-09-15T10:28:52.580+02:00  INFO 18384 --- [shop_lera] [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.4.4.Final
2025-09-15T10:28:52.714+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-09-15T10:28:54.126+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-09-15T10:28:54.182+02:00  INFO 18384 --- [shop_lera] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-09-15T10:28:54.558+02:00  INFO 18384 --- [shop_lera] [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@3e9f4d44
2025-09-15T10:28:54.560+02:00  INFO 18384 --- [shop_lera] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-09-15T10:28:57.651+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-09-15T10:28:57.694+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.694+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "moto" does not exist, skipping
2025-09-15T10:28:57.695+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.695+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "moto_parts" does not exist, skipping
2025-09-15T10:28:57.696+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.696+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "moto_parts" does not exist, skipping
2025-09-15T10:28:57.696+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.697+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "part" does not exist, skipping
2025-09-15T10:28:57.697+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.697+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "transaction" does not exist, skipping
2025-09-15T10:28:57.698+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.698+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "transaction_motos" does not exist, skipping
2025-09-15T10:28:57.699+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.699+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "transaction_motos" does not exist, skipping
2025-09-15T10:28:57.700+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.701+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "transaction_parts" does not exist, skipping
2025-09-15T10:28:57.701+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.702+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : relation "transaction_parts" does not exist, skipping
2025-09-15T10:28:57.703+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.704+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "customer" does not exist, skipping
2025-09-15T10:28:57.704+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.704+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "moto" does not exist, skipping
2025-09-15T10:28:57.705+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.705+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "moto_parts" does not exist, skipping
2025-09-15T10:28:57.706+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.706+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "part" does not exist, skipping
2025-09-15T10:28:57.707+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.707+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "transaction" does not exist, skipping
2025-09-15T10:28:57.707+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.707+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "transaction_motos" does not exist, skipping
2025-09-15T10:28:57.708+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 0, SQLState: 00000
2025-09-15T10:28:57.708+02:00  WARN 18384 --- [shop_lera] [  restartedMain] o.h.engine.jdbc.spi.SqlExceptionHelper   : table "transaction_parts" does not exist, skipping
2025-09-15T10:28:57.782+02:00  INFO 18384 --- [shop_lera] [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-09-15T10:28:59.059+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2025-09-15T10:28:59.134+02:00  INFO 18384 --- [shop_lera] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8082 (http) with context path ''
2025-09-15T10:28:59.154+02:00  INFO 18384 --- [shop_lera] [  restartedMain] pl.dmcs.shop.ShopApplication             : Started ShopApplication in 17.458 seconds (process running for 23.73)

```

---

## Technologies
- Java 21  
- Spring Boot 3.2.3  
- Spring Data JPA  
- Spring Web  
- PostgreSQL  
- HikariCP (connection pool)  
- Lombok  
- Tomcat (embedded)  
- Maven

---

## Features
- Storage of motorcycle, parts and customer information.  
- Transaction management (purchase of motorcycles and parts).  
- REST API for CRUD transactions.  
- DevTools support for hot-reload development.  
- Connection to PostgreSQL using JPA/Hibernate.  

---

## Setup
1. Clone the repository:
```bash
git clone https://github.com/username/motoshop.git
cd motoshop
```

2. Configure the PostgreSQL database (example application.properties):
```
spring.datasource.url=jdbc:postgresql://localhost:5432/motoshop
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. Get it up and running:
```
mvn clean install
mvn spring-boot:run
```

4. Jump in the browser:
```
http://localhost:8082
```
