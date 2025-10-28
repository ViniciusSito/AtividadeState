public class EntregueState implements OrderState {
    
    private static final EntregueState instance = new EntregueState();
    private EntregueState() {}
    public static EntregueState getInstance() { return instance; }
    
    private void throwTerminalException() {
        throw new IllegalStateException("O pedido já foi entregue e finalizado. Nenhuma ação adicional é permitida.");
    }

    @Override
    public void pagar(Order order) { throwTerminalException(); }

    @Override
    public void enviar(Order order) { throwTerminalException(); }

    @Override
    public void entregar(Order order) {
        throw new IllegalStateException("O pedido já foi entregue.");
    }

    @Override
    public void cancelar(Order order) { throwTerminalException(); }
}