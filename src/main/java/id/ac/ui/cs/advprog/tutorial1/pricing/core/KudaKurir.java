package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KudaKurir implements Kurir {
    private int pricePerKilogram;
    
    public KudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kuda";
    }

    public int calculatePrice(int weight) {
        return new CalculatePriceWithoutFee().calculatePrice(weight, this.pricePerKilogram);
    }

    public String printPrice(int weight) {
        return String.format("Harga jasa kurir: %d x %d = %d civil credits\n", weight, this.pricePerKilogram,
                calculatePrice(weight));
    }
}
