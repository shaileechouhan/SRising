package demoBlaze.models;

public class PurchaseData {
    private long id;
    private int amount;
    private long cardNumber;
    private String name;
    private String date;
    public PurchaseData(long id, int amount, long cardNumber, String name, String date) {
        this.id = id;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
