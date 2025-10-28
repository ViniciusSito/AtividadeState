### Arquivos do Padrão State

  * `OrderState.java`
      * A **Interface State**. Define o contrato (métodos como `pagar`, `enviar`, etc.) que todos os estados concretos devem implementar.
  * `Order.java`
      * A classe de **Contexto**. Mantém a referência ao seu estado atual (`currentState`).
      * Delega todas as ações (como `pagar()`) para o objeto de estado atual.
      * Também atua como **Subject** (Observable) para o padrão Observer.
  * `NovoState.java`, `PagoState.java`, `EnviadoState.java`, `EntregueState.java`, `CanceladoState.java`
      * As classes de **Concrete State**.
      * Cada classe implementa `OrderState` e define o comportamento específico para aquele estado. (Ex: `NovoState` implementa `pagar()`, mas lança exceção em `enviar()`).
      * São responsáveis pela transição, chamando `order.setState(...)` para mudar o estado do Contexto.
      * Implementadas como **Singleton** (ex: `NovoState.getInstance()`), pois não possuem estado próprio.
  * `OrderObserver.java`
      * A interface **Observer**. Define o método `update()` que será chamado quando o estado da `Order` mudar.
  * `EmailNotificationObserver.java`, `SmsNotificationObserver.java`
      * **Observers Concretos**. Implementam `OrderObserver` para reagir à mudança de estado (ex: "enviar email").
  * `OrderManagementDemo.java`
      * Classe de **Demonstração (Cliente)**.
      * Cria a `Order` (Contexto), anexa os `Observers` e executa ações (`pagar`, `enviar`) para demonstrar a mudança de estado e as notificações.

-----

## Como Executar
Execute a classe principal:
    ```bash
    java OrderManagementDemo
    ```
