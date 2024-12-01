package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("==== Bem-vindo à Máquina de Refrigerantes ====");
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    efetuarCompra();
                    break;
                case 2:
                    acessarManutencao();
                    break;
                case 3:
                    System.out.println("Obrigado por usar a Máquina de Refrigerantes!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    // Exibe o menu principal
    private static void exibirMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1 - Efetuar Compra");
        System.out.println("2 - Parte de Manutenção");
        System.out.println("3 - Sair");
    }

    // Simula a lógica de efetuar uma compra
    private static void efetuarCompra() {
        System.out.println("\n[Compra] Função ainda em desenvolvimento...");
        // Aqui você pode chamar métodos para selecionar produtos, calcular troco, etc.
    }

    // Simula o acesso à parte de manutenção
    private static void acessarManutencao() {
        System.out.println("\n[Manutenção] Função ainda em desenvolvimento...");
        // Aqui você pode chamar métodos para adicionar produtos, gerar relatórios, etc.
    }
}
