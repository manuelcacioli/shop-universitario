# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Installa Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file pom.xml e la cartella src
COPY pom.xml .
COPY src ./src

# Compila il progetto Maven
RUN mvn clean package -DskipTests --no-transfer-progress

# Stampa il contenuto della cartella target (debug)
RUN echo "### Contenuto della cartella target ###" && ls -la target

# Copia il file JAR nel container
COPY target/*.jar app.jar

# Esponi la porta su cui Spring Boot gira (default 8080)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
