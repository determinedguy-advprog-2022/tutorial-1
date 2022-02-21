package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class CalculatePriceWithFee implements CalculatePrice{
    private int fee;

    public CalculatePriceWithFee(int fee) {
        this.fee = fee;
    }

    @Override
    public int calculatePrice(int weight, int pricePerKilogram) {
        return fee + (weight * pricePerKilogram);
    }
}
