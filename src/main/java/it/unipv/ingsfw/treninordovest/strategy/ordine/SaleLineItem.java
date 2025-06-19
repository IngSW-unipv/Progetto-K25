package it.unipv.ingsfw.treninordovest.strategy.ordine;

public class SaleLineItem {
    private int quantity;
    private double unitPrice;

    public SaleLineItem(int quantity, double unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return quantity * unitPrice;
    }

}
