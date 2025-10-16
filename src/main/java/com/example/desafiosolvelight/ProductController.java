package com.example.desafiosolvelight;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    ProdutoService productService;

    public ProductController(ProdutoService produtoService) {
        this.productService = produtoService;
    }
    @GetMapping("/total/{total}")
    public ResponseEntity<Map<Integer,Integer>> sendTotalNotes(@PathVariable BigDecimal total){
        HashMap<Integer, Integer> notes = productService.calculateNotes(total);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("/product")
    public ResponseEntity<Optional<Product>> saveProduct(@RequestBody Product productResponse){
        Optional<Product> saved = productService.saveProduct(productResponse);
        return ResponseEntity.ok(saved);
    }
}
