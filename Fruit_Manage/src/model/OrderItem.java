package model;

public class OrderItem {
    private String fruitName;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String fruitName, int quantity, double price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getAmount() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format(
                "%-15s %-10d %-10.2f %-10.2f",
                fruitName,
                quantity,
                price,
                getAmount()
        );
    }
}
