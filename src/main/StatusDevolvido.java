package main;

public class StatusDevolvido extends StatusPedido {
    private static final StatusDevolvido INSTANCE = new StatusDevolvido();

    private StatusDevolvido() {}

    public static StatusDevolvido getInstance() {
        return INSTANCE;
    }

    @Override
    public String getEstado() {
        return "Devolvido";
    }
}
