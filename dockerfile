# Use a imagem oficial do OpenJDK
FROM openjdk:17

# Crie um diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo Java para o contêiner
COPY Main.java /app/

# Compile o código Java
RUN javac Main.java

# Defina o caminho da classe principal
CMD ["java", "-cp", "/app", "Main"]
