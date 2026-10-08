package main;

public class ContadorTransacaoStatusObserver implements Observer {
    private int updateCount = 0;

    @Override
    public void update(Pedido p) {
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
