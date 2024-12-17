# Usa l'immagine di base di OpenJDK 17
FROM openjdk:17-jdk-slim

# Installa Maven
RUN apt-get update && apt-get install -y maven

# Copia il progetto nella directory di lavoro
COPY . /app

# Imposta la directory di lavoro
WORKDIR /app

# Compila il progetto Maven
RUN mvn clean package -DskipTests

# Esponi la porta su cui Spring Boot gira (default 8080)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "target/shop-0.0.1-SNAPSHOT.jar"]
