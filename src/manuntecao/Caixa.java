package src.manuntecao;

import java.util.HashMap;
import java.util.Map;

public class Caixa {
    private Map<Double, Integer> caixa = new HashMap<>();

    public Caixa() {
        caixa.put(0.5, 10); // 10 moedas de 50 centavos
        caixa.put(1.0, 10); // 10 moedas de 1 real
        caixa.put(2.0, 10); // 10 notas de 2 reais
        caixa.put(5.0, 10); // 10 notas de 5 reais
        caixa.put(10.0, 10); // 10 notas de 10 reais
    }

    public boolean validarNotaOuMoeda(double valor) {
        return caixa.containsKey(valor);
    }

    public void adicionarDinheiro(double valor) {
        caixa.put(valor, caixa.getOrDefault(valor, 0) + 1);
    }

    public void darTroco(double troco) {
        for (double valor : new double[] { 10.0, 5.0, 2.0, 1.0, 0.5 }) {
            while (troco >= valor && caixa.get(valor) > 0) {
                troco -= valor;
                troco = Math.round(troco * 100.0) / 100.0; // Evitar problemas de precisão
                caixa.put(valor, caixa.get(valor) - 1);
                System.out.printf("Entregando R$ %.2f%n", valor);
            }
        }
        if (troco > 0) {
            System.out.printf("Troco insuficiente no caixa! Faltou: R$ %.2f%n", troco);
        }
    }

    public double getSaldo() {
        return caixa.entrySet().stream().mapToDouble(e -> e.getKey() * e.getValue()).sum();
    }
}
