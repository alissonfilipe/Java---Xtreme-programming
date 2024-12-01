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
                System.out.println("Produtos disponíveis:");
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println(
                            (i + 1) + " - " + produtos.get(i).getNome() + " - Preço: " + produtos.get(i).getPreco());
                }
                System.out.print("Escolha o produto (1-" + produtos.size() + "): ");
                int escolhaProduto = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                Produto produtoEscolhido = produtos.get(escolhaProduto - 1);
                if (Caixa.efetuarCompra(cliente, produtoEscolhido)) {
                    System.out.println("Compra realizada com sucesso!");
                    produtosVendidos.add(produtoEscolhido);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            } else if (opcao == 2) {
                Relatorio.gerarRelatorio(produtosVendidos);
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Coca-Cola", 4.5));
        produtos.add(new Produto("Pepsi", 4.0));
        produtos.add(new Produto("Fanta", 3.5));
        return produtos;
    }
}