# Étape 1 : Construction de l'application
FROM openjdk:17-slim AS build

WORKDIR /app

# Copie des fichiers nécessaires
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Attribution des permissions d'exécution au script mvnw
RUN chmod +x mvnw

# Téléchargement des dépendances Maven en mode hors ligne
RUN ./mvnw dependency:go-offline

# Construction du JAR de l'application
RUN ./mvnw clean package -DskipTests

# Étape 2 : Création de l'image finale
FROM openjdk:17-slim

WORKDIR /app

# Copie du JAR généré depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposition du port 8080
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]