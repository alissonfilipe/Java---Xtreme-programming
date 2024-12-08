// tests/TesteMaquinaDeRefrigerante.java
package tests;

import src.manuntecao.Produto;
import src.manuntecao.Caixa;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteMaquinaDeRefrigerante {

    @Test
    public void testEfetuarCompra() {
        Cliente cliente = new Cliente("Maria", 10.0);
        Produto produto = new Produto("Coca-Cola", 4.5);
        assertTrue(Caixa.efetuarCompra(cliente, produto));
        assertEquals(5.5, cliente.getSaldo());
    }

    @Test
    public void testSaldoInsuficiente() {
        Cliente cliente = new Cliente("Pedro", 2.0);
        Produto produto = new Produto("Pepsi", 4.0);
        assertFalse(Caixa.efetuarCompra(cliente, produto));
    }
}
