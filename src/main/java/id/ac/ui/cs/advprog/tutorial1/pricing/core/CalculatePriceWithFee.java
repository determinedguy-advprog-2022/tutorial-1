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

    public String getDescription(int weight, int pricePerKilogram) {
        return String.format("Harga jasa kurir: %d x %d + %d = %d civil credits\n", weight, pricePerKilogram,
                this.fee, this.calculatePrice(weight,pricePerKilogram));
    }
}
