# Use a imagem oficial do OpenJDK como base
FROM openjdk:17

# Crie um diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o código-fonte completo para o contêiner
COPY ./src /app/src

# Compile todos os arquivos Java no diretório src
RUN javac -d /app/bin $(find src -name "*.java")

# Defina o comando para rodar o aplicativo
CMD ["java", "-cp", "/app/bin", "main.Main"]
