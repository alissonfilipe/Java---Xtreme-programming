package src.manuntecao;

import java.util.List;

public class Relatorio {
    public static void gerarRelatorio(List<Produto> produtosVendidos) {
        for (Produto produto : produtosVendidos) {
            System.out.println("Produto vendido: " + produto.getNome() + ", Preço: " + produto.getPreco());
        }
    }
}