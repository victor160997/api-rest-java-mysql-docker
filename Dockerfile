# Usar a imagem do Eclipse Temurin 21 JDK
FROM eclipse-temurin:21-jdk

# Setar o diretório de trabalho
WORKDIR /workspace

# Instalar Maven (ou outros pacotes necessários)
RUN apt-get update && apt-get install -y maven

# Copiar o código do projeto
COPY . /workspace

# Definir o comando para rodar a aplicação (será sobreescrito pelo VS Code no devcontainer)
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]
