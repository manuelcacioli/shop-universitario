# Usa l'immagine base di OpenJDK 17 con Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copia il progetto Maven (tutti i file)
COPY . .

# Costruisce il file JAR con Maven
RUN mvn clean package -DskipTests

# Usa l'immagine JDK leggera per il runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia il JAR generato dalla fase precedente
COPY --from=build /app/target/shop-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta 8080 (default Spring Boot)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]

