package id.ac.ui.cs.advprog.tutorial1.pricing.service;

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
        // TODO
        List<String> ret = new ArrayList<>();
        return ret;
    }

}
