package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class CalculatePriceWithoutFee implements CalculatePrice{
    @Override
    public int calculatePrice(int weight, int pricePerKilogram) {
        return weight * pricePerKilogram;
    }
}
