package com.example.desafiosolvelight;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    int numberOfProducts = 0;
    ProductRepository productRepository;
    public ProdutoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public HashMap<Integer, Double> calculateNotes(BigDecimal total) {

        HashMap<Integer, Double> valuesToReturn = new HashMap<>();
        int[] values = {100,50,20,10,5,2,1};
        for(int note : values ){
            double quantity = total.divide(BigDecimal.valueOf(note), 2, RoundingMode.HALF_UP).intValue();
            valuesToReturn.put(note, quantity);
            total = total.subtract(BigDecimal.valueOf(note * quantity));
            if(note == 1 && total.compareTo(BigDecimal.ZERO) > 0){
                double change = note - total.doubleValue();
                valuesToReturn.put(3, change);
            }
        }
        return valuesToReturn;
    }

    public void noteComparer(BigDecimal total) {

    }
    @Transactional
    public Optional<Product> saveProduct(Product product){
        productRepository.save(product);
        return Optional.of(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}

