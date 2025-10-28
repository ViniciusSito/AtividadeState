public class EnviadoState implements OrderState {

    private static final EnviadoState instance = new EnviadoState();
    private EnviadoState() {}
    public static EnviadoState getInstance() { return instance; }
    
    @Override
    public void pagar(Order order) {
        throw new IllegalStateException("O pedido já foi pago e enviado.");
    }

    @Override
    public void enviar(Order order) {
        throw new IllegalStateException("O pedido já foi enviado.");
    }

    @Override
    public void entregar(Order order) {
        order.addHistory("Entrega confirmada pelo cliente.");
        order.setState(EntregueState.getInstance());
    }

    @Override
    public void cancelar(Order order) {
        throw new IllegalStateException("Não é possível cancelar um pedido que já foi enviado.");
    }
}