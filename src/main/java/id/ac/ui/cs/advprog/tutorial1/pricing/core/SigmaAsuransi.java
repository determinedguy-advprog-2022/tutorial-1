package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class SigmaAsuransi implements Asuransi {
    private int price;
    
    public SigmaAsuransi(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "Sigma";
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public String printPrice() {
        return String.format("Harga jasa asuransi: %d civil credits\n", this.price);
    }

}
