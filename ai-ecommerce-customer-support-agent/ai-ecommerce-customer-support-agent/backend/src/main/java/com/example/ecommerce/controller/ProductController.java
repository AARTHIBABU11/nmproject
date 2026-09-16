package com.example.ecommerce.controller;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="*")
public class ProductController {
 private final ProductService service;
 public ProductController(ProductService service){this.service=service;}
 @GetMapping public List<Product> all(){return service.getAllProducts();}
 @GetMapping("/search") public List<Product> search(@RequestParam String keyword){return service.searchProducts(keyword);}
}
