# Fase 1: Compilazione del progetto
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Installa Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copia il progetto Maven
COPY pom.xml .
COPY src ./src

# Compila il progetto Maven
RUN mvn clean package -DskipTests --no-transfer-progress

# Fase 2: Crea l'immagine finale
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia il file JAR dalla fase di build
COPY --from=build /app/target/shop-0.0.1-SNAPSHOT.jar app.jar

# Esponi la porta su cui gira Spring Boot
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
