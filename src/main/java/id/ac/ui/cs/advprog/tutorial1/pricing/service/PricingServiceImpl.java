package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class PricingServiceImpl implements PricingService {
    
    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @Override
    public List<String> calculatePrice(int weight, int value) {
        Kurir chosenKurir = getKurir(weight);
        Asuransi chosenAsuransi = getAsuransi(value);

        int hargaKurir = chosenKurir.calculatePrice(weight);
        int hargaAsuransi = chosenAsuransi.getPrice();
        int totalHarga = hargaKurir + hargaAsuransi;

        List<String> ret = new ArrayList<>();
        ret.add(String.format("Menggunakan Kurir %s\n", chosenKurir.getName()));
        ret.add(chosenKurir.printPrice(weight));
        ret.add(String.format("Menggunakan Asuransi %s\n", chosenAsuransi.getName()));
        ret.add(chosenAsuransi.printPrice());
        ret.add(String.format("total harga: %d + %d = %d civil credits", hargaKurir, hargaAsuransi,
                totalHarga));
        return ret;
    }

    private Kurir getKurir(int weight) {
        if (weight < 10) {
            return kurirRepository.findByName("Kadal");
        } else if (weight <= 50) {
            return kurirRepository.findByName("Kuda");
        } else {
            return kurirRepository.findByName("Garuda");
        }
    }

    private Asuransi getAsuransi(int value) {
        if (value < 1000) {
            return asuransiRepository.findByName("Beta");
        } else if (value <= 50000) {
            return asuransiRepository.findByName("Alpha");
        } else {
            return asuransiRepository.findByName("Sigma");
        }
    }

}
