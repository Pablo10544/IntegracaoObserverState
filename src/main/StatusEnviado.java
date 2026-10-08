package main;

public class StatusEnviado extends StatusPedido {
    private static final StatusEnviado INSTANCE = new StatusEnviado();

    private StatusEnviado() {}

    public static StatusEnviado getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean extraviar(Pedido pedido) {
        pedido.setStatus(StatusDevolvido.getInstance());
        return true;
    }

    @Override
    public boolean receber(Pedido pedido) {
        pedido.setStatus(StatusRecebido.getInstance());
        return true;
    }

    @Override
    public boolean devolver(Pedido pedido) {
        pedido.setStatus(StatusDevolvido.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Enviado";
    }
}
