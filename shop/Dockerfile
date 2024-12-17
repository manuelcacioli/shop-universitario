# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Installa Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Imposta la directory di lavoro
WORKDIR /app

# Copia tutto il contenuto del progetto
COPY . /app

# Compila il progetto Maven
RUN mvn clean package -DskipTests --no-transfer-progress

# Stampa il contenuto della cartella target per debug
RUN echo "### Contenuto della cartella target ###" && ls -la /app/target

# Copia il file JAR generato nel container
COPY target/shop-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta su cui Spring Boot gira
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
