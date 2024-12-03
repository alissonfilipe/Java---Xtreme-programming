# Java---Xtreme-programming

# orientação escrita
Máquina de Refrigerante <br>
<br>
Dinheiro do caixa adicionado para troco não se mistura com dinheiro das vendas<br>

Lado Cliente<br>
Efetuar Compra<br>
Cálculo do Troco (Obrigatório)<br>
<hr>
Parte de Manutenção<br>
Adicionar dinheiro ao caixa<br>
Adicionar produto dentro da máquina<br>
Relatório da renda<br>
Adicionar 5 produtos com preços distintos<br>
Cédulas: de 2, 5, 10 reais<br>
Moedas: de 50 centavos e 1 real<br>
Java - Xtreme Programming<br>
<br>

`1ª Parte` - Entrega da app (02 dez)<br>
`2ª Parte` - Casos de Teste (3 casos de teste) (JUnit - AssertEquals) (04 dez)<br>
`3ª Parte` - Métricas (Complexidade Ciclomática Maccabe) (Metrics - Sonarkube) (09 dez)<br>
`4ª Parte` - Refatoração (11 dez)<br>

# passos 

1. Reconstruir a imagem:
`docker build -t maquina-refrigerante .`

<br>

2. Executar o contêiner:
`docker run -it --rm maquina-refrigerante`


# raiz do projeto 
.<br>
├── Dockerfile<br>
├── src<br>
│   ├── cliente<br>
│   │   └── Cliente.java<br>
│   ├── manutencao<br>
│   │   ├── Caixa.java<br>
│   │   ├── Produto.java<br>
│   │   └── Relatorio.java<br>
│   └── main<br>
│       └── Main.java<br>
├── resources<br>
│   └── produtos.json<br>
├── tests<br>
│   └── TesteMaquinaDeRefrigerante.java<br>
├── README.md<br>
└── extensoes.png<br>


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