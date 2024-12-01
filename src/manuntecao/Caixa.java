// src/manutencao/Caixa.java
package src.manuntecao;

import src.cliente.Cliente;
import java.util.List;

public class Caixa {
    public static boolean efetuarCompra(Cliente cliente, Produto produto) {
        if (cliente.getSaldo() >= produto.getPreco()) {
            cliente.debitarSaldo(produto.getPreco());
            return true;
        }
        return false;
    }
}
