package main;

public class StatusRecebido extends StatusPedido {
    private static final StatusRecebido INSTANCE = new StatusRecebido();

    private StatusRecebido() {}

    public static StatusRecebido getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean processar(Pedido pedido) {
        pedido.setStatus(StatusProcessando.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Recebido";
    }
}
