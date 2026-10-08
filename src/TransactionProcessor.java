import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TransactionProcessor {

    public static void processBatch(List<Transaction> transactions, PaymentRouter router) {
        Supplier<String> traceIdSupplier = () -> UUID.randomUUID().toString();
        String traceId = traceIdSupplier.get();

        System.out.println("PROCESSING BATCH | TRACE ID: " + traceId);

        Predicate<Transaction> isHighValue = t -> t.getAmount() > 10000.0;
        Predicate<Transaction> isHighRiskMerchant = t -> "GAMBLING".equalsIgnoreCase(t.getMerchantCategory());
        Predicate<Transaction> fraudCheck = isHighValue.or(isHighRiskMerchant);

        Function<Transaction, Double> feeCalculator = t -> {
            if (t.isFlagged()) {
                return 50.00; // Investigation fee
            } else {
                return t.getAmount() * 0.025; // 2.5% standard fee
            }
        };

        Consumer<Transaction> auditLogger = t -> {
            String network = router.route(t);
            double fee = feeCalculator.apply(t);
            String status = t.isFlagged() ? "FLAGGED (SUSPICIOUS)" : "APPROVED";


        };

    }
}