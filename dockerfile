# Use uma imagem do OpenJDK baseada no Debian/Ubuntu
FROM openjdk:17-slim

# Atualize os pacotes e instale o findutils
RUN apt-get update && apt-get install -y findutils && rm -rf /var/lib/apt/lists/*

# Crie um diretório de trabalho no contêiner
WORKDIR /app

# Copie os arquivos de código-fonte para o contêiner
COPY ./src /app/src

# Compile todos os arquivos Java no diretório src
RUN mkdir -p /app/bin && javac -d /app/bin $(find src -name "*.java")

# Defina o comando para rodar o aplicativo
CMD ["java", "-cp", "/app/bin", "src.main.Main"]
