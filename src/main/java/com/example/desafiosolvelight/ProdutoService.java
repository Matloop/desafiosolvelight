package com.example.desafiosolvelight;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Optional;

@Service
public class ProdutoService {
    int numberOfProducts = 0;
    ProductRepository productRepository;
    public ProdutoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public HashMap<Integer, Integer> calculateNotes(BigDecimal total) {

        HashMap<Integer, Integer> valuesToReturn = new HashMap<>();
        int[] values = {100,50,20,10,5,2,1};
        for(int note : values ){
            int quantity = total.divide(BigDecimal.valueOf(note), 2, RoundingMode.HALF_UP).intValue();
            valuesToReturn.put(note, quantity);
            total = total.subtract(BigDecimal.valueOf(note * quantity));
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

}

