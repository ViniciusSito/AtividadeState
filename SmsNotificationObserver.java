public class SmsNotificationObserver implements OrderObserver {
    @Override
    public void update(Order order, String message) {
        // Em um sistema real, isso chamaria um gateway de SMS.
        System.out.println("[SMS SERVICE] Notificação enviada: " + message);
    }
}