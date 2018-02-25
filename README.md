# Spring boot web application
Spring boot using Java - Rest API , JPA/HIbernate with h2 as database 

1. Java as language
2. Restful API
3. JPA / Hibernate
4. h2 database
5. lombok - for entity creation. Yes, I'm lazy. 

## How to run this application

### Run from terminal  
```mvn clean compile spring-boot:run```

### Run from Intellij IDEA 
Run application.java as java application 

## Database 
1. Open http://localhost:8080/console
2. JDBC URL ```jdbc:h2:mem:spring-boot-as-war```
3. Username ```sa``` with no password
4. Now you can check the entries in the tables 

## REST APIS
1. GET http://localhost:8080
It will fetch all registered participants from the system.

2. POST http://localhost:8080/participants
Register new participants

3. GET http://localhost:8080/participants/1   # Where 1 is the participant id 
It will fetch registered participants from the system.

## Deploy war in apache tomcat web server 

1. Create package ```mvn clean compile package```
2. Copy the war from target into tomcat/webapps dir.
3. Run tomcat from its root directory ```bin/startup.sh```
4. Now because tomcat's manager gui is already deployed as ROOT. You can access the application at http://localhost:8080/war-name 
5. Deploy application at this context path "/", rename spring-boot-as-war-0.0.1-SNAPSHOT.war to ROOT.war or make change in context.xml