public interface OrderState {
    void pagar(Order order);
    void enviar(Order order);
    void entregar(Order order);
    void cancelar(Order order);
}