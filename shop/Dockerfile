# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia tutto il contenuto del progetto
COPY . /app

# Pulizia della cache di Maven
RUN mvn dependency:purge-local-repository -DreResolve=false

# Forza la generazione del JAR con Maven
RUN mvn clean package -DskipTests

# Verifica il contenuto della cartella target
RUN echo "### Contenuto della cartella target dopo Maven ###" && ls -la /app/target

# Copia il file JAR generato nel container
COPY target/shop-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta su cui Spring Boot gira
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
