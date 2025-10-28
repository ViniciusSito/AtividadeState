public class PagoState implements OrderState {

    private static final PagoState instance = new PagoState();
    private PagoState() {}
    public static PagoState getInstance() { return instance; }

    @Override
    public void pagar(Order order) {
        throw new IllegalStateException("O pedido já foi pago.");
    }

    @Override
    public void enviar(Order order) {
        order.addHistory("Pedido enviado para a transportadora.");
        order.setState(EnviadoState.getInstance());
    }

    @Override
    public void entregar(Order order) {
        throw new IllegalStateException("O pedido ainda não foi enviado.");
    }

    @Override
    public void cancelar(Order order) {
        order.addHistory("Pedido pago cancelado (processar estorno).");
        order.setState(CanceladoState.getInstance());
    }
}