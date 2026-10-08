public class Transaction {
    private String transactionId;
    private double amount;
    private String currency;
    private String originCountry;
    private String merchantCategory;
    private boolean isFlagged;

    public Transaction(String transactionId, double amount, String currency, String originCountry, String merchantCategory) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.originCountry = originCountry;
        this.merchantCategory = merchantCategory;
        this.isFlagged = false; // default value
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }
    public double getAmount()
    { return amount; }
    public String getCurrency() {
        return currency;
    }
    public String getOriginCountry() {
        return originCountry;
    }
    public String getMerchantCategory() {
        return merchantCategory;
    }
    public boolean isFlagged() {
        return isFlagged;
    }
    public void setFlagged(boolean flagged) {
        isFlagged = flagged; }

    @Override
    public String toString() {
        return String.format("Transaction[ID=%s, Amount=%.2f %s, Country=%s, Merchant=%s, Flagged=%b]",
                transactionId, amount, currency, originCountry, merchantCategory, isFlagged);
    }
}

