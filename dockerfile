# Étape 1 : Build Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Crée un dossier de travail
WORKDIR /app

# Copie tout le code source dans l'image
COPY . .

# Compile le projet et génère le JAR
RUN mvn clean install -DskipTests

# Étape 2 : Image d'exécution minimale
FROM eclipse-temurin:17-jdk

# Dossier de travail pour l'exécution
WORKDIR /app

# Copie le JAR généré depuis l'image de build
COPY --from=builder /app/target/*.jar app.jar

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
