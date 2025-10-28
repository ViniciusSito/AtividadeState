
public class OrderManagementDemo {
    public static void main(String[] args) {
        
        System.out.println("=== Iniciando Pedido 1 ===");
        Order order1 = new Order();
        
        order1.addObserver(new EmailNotificationObserver());
        order1.addObserver(new SmsNotificationObserver());

        System.out.println("Estado atual: " + order1.getCurrentStateName());
        
        System.out.println("\n--- Ação: Pagar ---");
        order1.pagar();
        System.out.println("Estado atual: " + order1.getCurrentStateName());

        System.out.println("\n--- Ação: Tentar pagar de novo (deve falhar) ---");
        try {
            order1.pagar();
        } catch (IllegalStateException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Ação: Enviar ---");
        order1.enviar();
        System.out.println("Estado atual: " + order1.getCurrentStateName());

        System.out.println("\n--- Ação: Entregar ---");
        order1.entregar();
        System.out.println("Estado atual: " + order1.getCurrentStateName());

        System.out.println("\n");
        order1.printHistory();

        
        System.out.println("\n=== Iniciando Pedido 2 (para cancelamento) ===");
        Order order2 = new Order();
        
        System.out.println("Estado atual: " + order2.getCurrentStateName());

        System.out.println("\n--- Ação: Tentar enviar (deve falhar) ---");
        try {
            order2.enviar();
        } catch (IllegalStateException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
        
        System.out.println("\n--- Ação: Cancelar ---");
        order2.cancelar();
        System.out.println("Estado atual: " + order2.getCurrentStateName());

        System.out.println("\n--- Ação: Tentar pagar (deve falhar) ---");
        try {
            order2.pagar();
        } catch (IllegalStateException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
        
        System.out.println("\n");
        order2.printHistory();
    }
}