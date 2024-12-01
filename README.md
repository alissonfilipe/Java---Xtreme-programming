# Java---Xtreme-programming

# extenção
![alt text](/extencoes.png)

# orientação escrita
Máquina de Refrigerante

Dinheiro do caixa adicionado para troco não se mistura com dinheiro das vendas
Lado Cliente
Efetuar Compra
Cálculo do Troco (Obrigatório)
Parte de Manutenção
Adicionar dinheiro ao caixa
Adicionar produto dentro da máquina
Relatório da renda
Adicionar 5 produtos com preços distintos
Cédulas: de 2, 5, 10 reais
Moedas: de 50 centavos e 1 real
Java - Xtreme Programming

1ª Parte - Entrega da app (02 dez)
2ª Parte - Casos de Teste (3 casos de teste) (JUnit - AssertEquals) (04 dez)
3ª Parte - Métricas (Complexidade Ciclomática Maccabe) (Metrics - Sonarkube) (09 dez)
4ª Parte - Refatoração (11 dez)



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