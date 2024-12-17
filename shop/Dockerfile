# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR nel container
COPY target/shop-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta su cui Spring Boot gira (default 8080)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
