package src.main;

import src.cliente.Cliente;
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
        Cliente cliente = new Cliente("João", 50.0);
        List<Produto> produtosVendidos = new ArrayList<>();

        while (true) {
            System.out.println("==== Bem-vindo à Máquina de Refrigerantes ====");
            System.out.println("Menu Principal:");
            System.out.println("1 - Efetuar Compra");
            System.out.println("2 - Parte de Manutenção");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (opcao == 1) {
                efetuarCompra(scanner, produtos, cliente, produtosVendidos);
            } else if (opcao == 2) {
                menuManutencao(scanner, produtos, produtosVendidos);
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void efetuarCompra(Scanner scanner, List<Produto> produtos, Cliente cliente,
            List<Produto> produtosVendidos) {
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i).getNome() + " - Preço: " + produtos.get(i).getPreco());
        }
        System.out.print("Escolha o produto (1-" + produtos.size() + "): ");
        int escolhaProduto = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Produto produtoEscolhido = produtos.get(escolhaProduto - 1);

        if (cliente.getSaldo() >= produtoEscolhido.getPreco()) {
            double troco = cliente.getSaldo() - produtoEscolhido.getPreco();
            cliente.setSaldo(troco); // Atualiza o saldo do cliente
            System.out.println("Compra realizada com sucesso!");
            System.out.printf("Seu troco é: R$ %.2f%n", troco);
            produtosVendidos.add(produtoEscolhido);
        } else {
            System.out.println("Saldo insuficiente! Por favor, adicione mais dinheiro.");
        }
    }

    private static void menuManutencao(Scanner scanner, List<Produto> produtos, List<Produto> produtosVendidos) {
        while (true) {
            System.out.println("==== Parte de Manutenção ====");
            System.out.println("1 - Adicionar dinheiro ao caixa");
            System.out.println("2 - Adicionar produto à máquina");
            System.out.println("3 - Gerar relatório da renda");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcaoManutencao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (opcaoManutencao == 1) {
                System.out.print("Digite o valor a ser adicionado ao caixa: ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha
                Caixa.adicionarDinheiro(valor);
                System.out.println("Valor adicionado ao caixa com sucesso!");
            } else if (opcaoManutencao == 2) {
                System.out.print("Digite o nome do produto: ");
                String nomeProduto = scanner.nextLine();
                System.out.print("Digite o preço do produto: ");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha
                produtos.add(new Produto(nomeProduto, precoProduto));
                System.out.println("Produto adicionado com sucesso!");
            } else if (opcaoManutencao == 3) {
                Relatorio.gerarRelatorio(produtosVendidos);
            } else if (opcaoManutencao == 4) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Coca-Cola", 4.5));
        produtos.add(new Produto("Pepsi", 4.0));
        produtos.add(new Produto("Fanta", 3.5));
        produtos.add(new Produto("guarana Jesus", 5.0));
        produtos.add(new Produto("pitlula", 3));
        return produtos;
    }
}
