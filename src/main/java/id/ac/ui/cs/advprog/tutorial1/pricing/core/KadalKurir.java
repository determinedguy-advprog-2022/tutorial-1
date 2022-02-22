package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KadalKurir implements Kurir {
    private int pricePerKilogram;
    
    public KadalKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kadal";
    }

    public int calculatePrice(int weight) {
        return new CalculatePriceWithoutFee().calculatePrice(weight, this.pricePerKilogram);
    }

    public String printPrice(int weight) {
        return new CalculatePriceWithoutFee().getDescription(weight, this.pricePerKilogram);
    }
}
