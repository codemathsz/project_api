FROM ubuntu:latest AS build
LABEL authors="codemathsz"

# Atualiza a lista de pacotes e instala o JDK
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Copia o código fonte para o container
COPY . .

# Instala o Maven e compila o projeto
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim
EXPOSE 8080

COPY --from=build /target/stage-0.0.1.jar app.jar

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]