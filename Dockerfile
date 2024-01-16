# Utiliser une image de base avec Maven et JDK
FROM maven:3.6.3-jdk-17 AS build

# Copier les fichiers de projet dans l'image
COPY src /app/src
COPY pom.xml /app

# Construire l'application
WORKDIR /app
RUN mvn clean package


# Utiliser une image de base Java pour exécuter l'application
FROM eclipse-temurin:17-jdk-alpine AS deploy
COPY --from=build /app/target/*.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
