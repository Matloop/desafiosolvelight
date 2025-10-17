package com.example.desafiosolvelight;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    ProdutoService productService;

    public ProductController(ProdutoService produtoService) {
        this.productService = produtoService;
    }
    @GetMapping("/total/{total}")
    public ResponseEntity<Map<Integer,Double>> sendTotalNotes(@PathVariable BigDecimal total){
        HashMap<Integer, Double> notes = productService.calculateNotes(total);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("/product")
    public ResponseEntity<Optional<Product>> saveProduct(@RequestBody Product productResponse){
        Optional<Product> saved = productService.saveProduct(productResponse);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
}
