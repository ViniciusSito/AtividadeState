public class CanceladoState implements OrderState {
    
    private static final CanceladoState instance = new CanceladoState();
    private CanceladoState() {}
    public static CanceladoState getInstance() { return instance; }
    
    private void throwTerminalException() {
        throw new IllegalStateException("O pedido está cancelado e não pode sofrer mais ações.");
    }

    @Override
    public void pagar(Order order) { throwTerminalException(); }

    @Override
    public void enviar(Order order) { throwTerminalException(); }

    @Override
    public void entregar(Order order) { throwTerminalException(); }

    @Override
    public void cancelar(Order order) {
        throw new IllegalStateException("O pedido já está cancelado.");
    }
}