package src.manuntecao;

import src.cliente.Cliente;

public class Caixa {
    private static double saldo = 0.0;

    public static void adicionarDinheiro(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Novo saldo no caixa: " + saldo);
        } else {
            System.out.println("Valor inválido. Adicione um valor positivo.");
        }
    }

    public static boolean efetuarCompra(Cliente cliente, Produto produto) {
        if (cliente.getSaldo() >= produto.getPreco()) {
            cliente.setSaldo(cliente.getSaldo() - produto.getPreco());
            saldo += produto.getPreco();
            return true;
        }
        return false;
    }

    public static double getSaldo() {
        return saldo;
    }
}
