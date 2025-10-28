import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private OrderState currentState;
    private List<String> history = new ArrayList<>();
    
    private List<OrderObserver> observers = new ArrayList<>();

    public Order() {
        this.currentState = NovoState.getInstance();
        addHistory("Pedido criado. Estado: Novo");
    }
    
    public void addObserver(OrderObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (OrderObserver observer : this.observers) {
            observer.update(this, message);
        }
    }
    public void setState(OrderState newState) {
        this.currentState = newState;
        
        String stateName = newState.getClass().getSimpleName().replace("State", "");
        String message = "Estado alterado para: " + stateName;
        
        addHistory(message);
        notifyObservers(message);
    }

    public void pagar() {
        this.currentState.pagar(this);
    }

    public void enviar() {
        this.currentState.enviar(this);
    }

    public void entregar() {
        this.currentState.entregar(this);
    }

    public void cancelar() {
        this.currentState.cancelar(this);
    }
    
    public void addHistory(String entry) {
        this.history.add(entry);
    }

    public String getCurrentStateName() {
        return this.currentState.getClass().getSimpleName();
    }
    
    public void printHistory() {
        System.out.println("--- Histórico do Pedido ---");
        this.history.forEach(System.out::println);
        System.out.println("---------------------------");
    }
}