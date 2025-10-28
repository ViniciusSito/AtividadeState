public class NovoState implements OrderState {
    
    private static final NovoState instance = new NovoState();
    
    private NovoState() {}
    
    public static NovoState getInstance() {
        return instance;
    }

    @Override
    public void pagar(Order order) {
        order.addHistory("Pagamento processado com sucesso.");
        order.setState(PagoState.getInstance());
    }

    @Override
    public void enviar(Order order) {
        throw new IllegalStateException("Não é possível enviar um pedido novo. Pagamento pendente.");
    }

    @Override
    public void entregar(Order order) {
        throw new IllegalStateException("Não é possível entregar um pedido novo.");
    }

    @Override
    public void cancelar(Order order) {
        order.addHistory("Pedido cancelado pelo usuário.");
        // Transição de estado
        order.setState(CanceladoState.getInstance());
    }
}