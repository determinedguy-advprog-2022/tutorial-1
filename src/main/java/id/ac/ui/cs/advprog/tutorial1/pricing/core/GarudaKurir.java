package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class GarudaKurir implements Kurir {
    private int pricePerKilogram;
    private int priceFlat;
    
    public GarudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
        this.priceFlat = 2000;
    }

    public String getName() {
        return "Garuda";
    }

    public int calculatePrice(int weight) {
        return new CalculatePriceWithFee(this.priceFlat).calculatePrice(weight, this.pricePerKilogram);
    }
}
