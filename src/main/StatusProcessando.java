package main;

public class StatusProcessando extends StatusPedido {
    private static final StatusProcessando INSTANCE = new StatusProcessando();

    private StatusProcessando() {}

    public static StatusProcessando getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean enviar(Pedido pedido) {
        pedido.setStatus(StatusEnviado.getInstance());
        return true;
    }

    @Override
    public boolean processar(Pedido pedido) {
        return true;
    }

    @Override
    public String getEstado() {
        return "Processando";
    }
}
