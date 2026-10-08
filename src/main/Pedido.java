package main;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private StatusPedido status;
    private List<Observer> observers = new ArrayList<>();

    public Pedido() {
        this.status = StatusProcessando.getInstance();
    }

    public Pedido(StatusPedido status) {
        this.status = status;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void enviar() {
        status.enviar(this);
    }

    public void receber() {
        status.receber(this);
    }

    public void devolver() {
        status.devolver(this);
    }

    public void extraviar() {
        status.extraviar(this);
    }

    public void processar() {
        status.processar(this);
    }
}
