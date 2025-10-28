public class EmailNotificationObserver implements OrderObserver {
    @Override
    public void update(Order order, String message) {
        System.out.println("[EMAIL SERVICE] Notificação enviada: " + message);
    }
}