package src.main;

import src.manuntecao.Caixa;
import src.manuntecao.Produto;
import src.manuntecao.Relatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = carregarProdutos();
        List<Produto> produtosVendidos = new ArrayList<>();
        Caixa caixa = new Caixa();

        while (true) {
            System.out.println("==== Bem-vindo à Máquina de Refrigerantes ====");
            System.out.println("Menu Principal:");
            System.out.println("1 - Efetuar Compra");
            System.out.println("2 - Parte de Manutenção");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    efetuarCompra(scanner, produtos, produtosVendidos, caixa);
                    break;
                case 2:
                    menuManutencao(scanner, produtos, produtosVendidos, caixa);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void efetuarCompra(Scanner scanner, List<Produto> produtos, List<Produto> produtosVendidos,
            Caixa caixa) {
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + produtos.get(i).getNome() + " - Preço: R$ " + produtos.get(i).getPreco());
        }
        System.out.print("Escolha o produto (1-" + produtos.size() + "): ");
        int escolhaProduto = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Produto produtoEscolhido = produtos.get(escolhaProduto - 1);
        double preco = produtoEscolhido.getPreco();
        double totalInserido = 0.0;

        System.out.println("Insira dinheiro (notas de 2, 5, 10 reais ou moedas de 0.5, 1 real):");
        while (totalInserido < preco) {
            System.out.printf("Falta R$ %.2f. Insira o valor: ", preco - totalInserido);
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            if (caixa.validarNotaOuMoeda(valor)) {
                totalInserido += valor;
                caixa.adicionarDinheiro(valor);
            } else {
                System.out.println("Valor inválido. Aceitamos notas de 2, 5, 10 reais e moedas de 0.5, 1 real.");
            }
        }

        double troco = totalInserido - preco;
        if (troco > 0) {
            System.out.printf("Seu troco é: R$ %.2f%n", troco);
            caixa.darTroco(troco);
        }

        System.out.println("Compra realizada com sucesso!");
        produtosVendidos.add(produtoEscolhido);
    }

    private static void menuManutencao(Scanner scanner, List<Produto> produtos, List<Produto> produtosVendidos,
            Caixa caixa) {
        while (true) {
            System.out.println("==== Parte de Manutenção ====");
            System.out.println("1 - Adicionar dinheiro ao caixa");
            System.out.println("2 - Adicionar produto à máquina");
            System.out.println("3 - Gerar relatório da renda");
            System.out.println("4 - Verificar saldo no caixa");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcaoManutencao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcaoManutencao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado ao caixa: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    caixa.adicionarDinheiro(valor);
                    System.out.println("Valor adicionado ao caixa com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    produtos.add(new Produto(nomeProduto, precoProduto));
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 3:
                    Relatorio.gerarRelatorio(produtosVendidos);
                    break;
                case 4:
                    System.out.printf("Saldo no caixa: R$ %.2f%n", caixa.getSaldo());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Coca-Cola", 4.5));
        produtos.add(new Produto("Pepsi", 4.0));
        produtos.add(new Produto("Fanta", 3.5));
        produtos.add(new Produto("Guaraná Jesus", 5.0));
        produtos.add(new Produto("Pitula", 3.0));
        return produtos;
    }
}
