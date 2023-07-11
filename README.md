# Java Bootspring / Instagram Backend

This application was supposed to provide an API functionality to any frontend which hit it in  a specific way. The running port of application is 8080. Here I have used mysql as database for storage the data. Here the you need to setup the dependencies in pom.xml.

## Requirements
.Java 17 

.MYSQL Database

.Cloudinary Plateform

## Installation

1. Clone the repository:
```bash
git clone https://github.com/tayyabali12345/instagram-backend


```

2. Install the maven:
```bash
apt install maven
```
3. Create the database in mysql and set application properties file:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/empdb
spring.datasource.username=root
spring.datasource.password=root_pass_1234
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
4. Start the Java server:
