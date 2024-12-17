# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia tutto il contenuto del progetto (incluso pom.xml e src)
COPY . /app

# Compila il progetto Maven
RUN mvn clean package -DskipTests

# Esponi la porta su cui Spring Boot gira (default 8080)
EXPOSE 8080

# Copia il file JAR generato nel container (se non già fatto)
COPY target/shop-0.0.1-SNAPSHOT.jar app.jar

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
