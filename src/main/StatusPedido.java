package main;

public abstract class StatusPedido {

    public abstract String getEstado();

    public boolean enviar(Pedido pedido) {
        return false;
    }

    public boolean extraviar(Pedido pedido) {
        return false;
    }

    public boolean receber(Pedido pedido) {
        return false;
    }

    public boolean devolver(Pedido pedido) {
        return false;
    }

    public boolean processar(Pedido pedido) {
        return false;
    }
}
