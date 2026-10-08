package test;

import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void testInitialStatusIsProcessando() {
        Assertions.assertEquals("Processando", pedido.getStatus().getEstado());
    }

    @Test
    void testTransitionProcessandoToEnviado() {
        pedido.enviar();
        Assertions.assertEquals("Enviado", pedido.getStatus().getEstado());
    }

    @Test
    void testTransitionEnviadoToRecebido() {
        pedido.enviar();
        pedido.receber();
        Assertions.assertEquals("Recebido", pedido.getStatus().getEstado());
    }

    @Test
    void testTransitionRecebidoToProcessando() {
        pedido = new Pedido(StatusRecebido.getInstance());
        Assertions.assertEquals("Recebido", pedido.getStatus().getEstado());
        
        pedido.processar();
        Assertions.assertEquals("Processando", pedido.getStatus().getEstado());
    }

    @Test
    void testTransitionEnviadoToDevolvido() {
        pedido.enviar();
        pedido.devolver();
        Assertions.assertEquals("Devolvido", pedido.getStatus().getEstado());
    }

    @Test
    void testObserverNotification() {
        ContadorTransacaoStatusObserver obs1 = new ContadorTransacaoStatusObserver();
        ContadorTransacaoStatusObserver obs2 = new ContadorTransacaoStatusObserver();

        pedido.addObserver(obs1);
        pedido.addObserver(obs2);

        pedido.enviar();
        Assertions.assertEquals(1, obs1.getUpdateCount());
        Assertions.assertEquals(1, obs2.getUpdateCount());

        pedido.receber();
        Assertions.assertEquals(2, obs1.getUpdateCount());
        Assertions.assertEquals(2, obs2.getUpdateCount());
    }

    @Test
    void testRemoveObserver() {
        ContadorTransacaoStatusObserver obs = new ContadorTransacaoStatusObserver();

        pedido.addObserver(obs);
        pedido.enviar();
        Assertions.assertEquals(1, obs.getUpdateCount());

        pedido.removeObserver(obs);
        pedido.receber();
        Assertions.assertEquals(1, obs.getUpdateCount());
    }

    @Test
    void testMultipleObserversNotification() {
        ContadorTransacaoStatusObserver obs1 = new ContadorTransacaoStatusObserver();
        ContadorTransacaoStatusObserver obs2 = new ContadorTransacaoStatusObserver();
        ContadorTransacaoStatusObserver obs3 = new ContadorTransacaoStatusObserver();

        pedido.addObserver(obs1);
        pedido.addObserver(obs2);
        pedido.addObserver(obs3);

        pedido.enviar();

        Assertions.assertEquals(1, obs1.getUpdateCount());
        Assertions.assertEquals(1, obs2.getUpdateCount());
        Assertions.assertEquals(1, obs3.getUpdateCount());
    }
}
