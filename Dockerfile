# Use a imagem base oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Crie um diretório para a aplicação
WORKDIR /app

# Copie o arquivo JAR para o contêiner
COPY target/hello-sol-0.0.1-SNAPSHOT.jar /app/hello-sol-0.0.1-SNAPSHOT.jar

# Exponha a porta em que a aplicação Spring Boot estará rodando
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/hello-sol-0.0.1-SNAPSHOT.jar"]
