package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class CalculatePriceWithoutFee implements CalculatePrice{
    @Override
    public int calculatePrice(int weight, int pricePerKilogram) {
        return weight * pricePerKilogram;
    }

    public String getDescription(int weight, int pricePerKilogram) {
        return String.format("Harga jasa kurir: %d x %d = %d civil credits\n", weight, pricePerKilogram,
                this.calculatePrice(weight,pricePerKilogram));
    }
}
