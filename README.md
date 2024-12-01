# Java---Xtreme-programming

# extenção
![alt text](/extencoes.png)

# docker + Java

4. Crie a imagem Docker
No terminal, dentro da pasta do projeto, construa a imagem Docker com o comando:


docker build -t java-app .
5. Execute o contêiner
Após a imagem ser construída, rode o contêiner com:


docker run --rm java-app
`A parte do --rm remove automáticamente o container após a execução para não ter containers parados`

`docker run --name java-container java-app` --> executa o container

`docker start -a java-container` --> para ver a saída do container sem ser de segundo plano