public interface OrderObserver {
    void update(Order order, String message);
}