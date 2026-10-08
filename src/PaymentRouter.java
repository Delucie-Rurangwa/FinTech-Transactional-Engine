@FunctionalInterface
public interface PaymentRouter {
    String route(Transaction t);
}