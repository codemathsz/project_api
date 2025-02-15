# Etapa de Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copia o pom.xml e o diretório src para dentro do container
COPY pom.xml .
COPY src ./src
# Compila o projeto e gera o jar, pulando os testes que requerem acesso ao banco
RUN mvn clean package -DskipTests

# Etapa de Execução
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copia o jar gerado na etapa anterior
COPY --from=build /app/target/stage-0.0.1.jar app.jar
EXPOSE 8080
# O comando de inicialização será sobrescrito no docker-compose
CMD ["java", "-jar", "app.jar"]