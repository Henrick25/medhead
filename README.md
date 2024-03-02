# medheadApp



# api de reservation

Ce projet est une API de réservation construite avec Spring Boot.

## Prérequis

- Java 17
- Maven
- MySQL

# API with Spring Boot

Ce projet est une API construite avec Spring Boot, configurée pour utiliser Maven comme système de gestion de projet. Elle utilise Spring Data JPA pour l'accès aux données, Spring Security pour la sécurité, et est prête à se connecter à une base de données MySQL.

## Configuration du projet

Le fichier `pom.xml` contient toutes les dépendances nécessaires pour le projet, y compris Spring Boot Starter Web, Spring Boot Starter Data JPA, Spring Boot Starter Security, une base de données H2 pour les tests, Lombok pour réduire le boilerplate code, et d'autres dépendances utiles.

## Configuration de l'application

La configuration de l'application est spécifiée dans le fichier `application.properties` ou `application.yml` de Spring Boot. Voici un exemple de configurations clés :

```properties
# Nom de l'application
spring.application.name=api

# Configuration du serveur Tomcat
server.port=8081

# Configuration du niveau de log
logging.level.root=ERROR
logging.level.com.medhead=INFO
logging.level.org.springframework.boot.web.embedded.tomcat=INFO

# Configuration de la base de données H2 (pour les tests)
#spring.h2.console.enabled=true

# Configuration de la base de données MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/MedHead
spring.datasource.username=root
spring.datasource.password=chiot
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

## Installation

Clonez le dépôt :

```bash
mvn clean install
mvn spring-boot:run
spring.application.name=api
server.port=9000
#logging.level.root=ERROR
logging.level.com.medhead=INFO
#logging.level.org.springframework.boot.autoconfigure=2=INFO
logging.level.org.springframework.boot.web.embedded.tomcat=INFO
spring.datasource.url=jdbc:mysql://localhost:3306/MedHead
spring.datasource.username=root
spring.datasource.password=chiot
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=medhead096@gmail.com
spring.mail.password=xkcn ewlr ubrc jjqw
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
security.my-jwtKey=6CLSwAVB3OT9uzeIdkQoOeVQJ7N_k54mm3d4qzrZKoSET1Q3MIe749iQwKnm1ZcP


# Web

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 17.2.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
