# Utilisez une image de base officielle Java (Temurin) avec Maven inclus
FROM maven:3.8.4-openjdk-17-slim AS build

# Copiez les fichiers de votre projet dans l'image
COPY src /home/app/src
COPY pom.xml /home/app

# Construisez votre application
RUN mvn -f /home/app/pom.xml clean package

# Utilisez une image de base Java pour exécuter votre application
FROM openjdk:17-oracle

# Copiez le jar construit dans l'image
COPY --from=build /home/app/target/*.jar /usr/local/lib/apiReservation.jar

# Commande pour exécuter votre application
ENTRYPOINT ["java","-jar","/usr/local/lib/apiReservation.jar"]
