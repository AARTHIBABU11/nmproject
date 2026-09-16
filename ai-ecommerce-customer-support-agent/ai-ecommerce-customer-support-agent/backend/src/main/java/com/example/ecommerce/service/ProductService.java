package com.example.ecommerce.service;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
 private final List<Product> products = List.of(
  new Product(1L,"Nova X Smartphone","Electronics",24999,"Bright display and long battery life.","https://images.unsplash.com/photo-1511707171634-5f897ff02aa9"),
  new Product(2L,"AirBeat Wireless Headphones","Electronics",2999,"Wireless headphones with clear audio.","https://images.unsplash.com/photo-1505740420928-5e560c06d30e"),
  new Product(3L,"Urban Travel Backpack","Accessories",1499,"Water-resistant backpack for college and travel.","https://images.unsplash.com/photo-1553062407-98eeb64c6a62"),
  new Product(4L,"Smart Fitness Watch","Wearables",3999,"Fitness tracking and notification support.","https://images.unsplash.com/photo-1523275335684-37898b6baf30")
 );
 public List<Product> getAllProducts(){ return products; }
 public List<Product> searchProducts(String keyword){
  String q=keyword==null?"":keyword.toLowerCase();
  return products.stream().filter(p -> (p.name()+" "+p.category()+" "+p.description()).toLowerCase().contains(q)).toList();
 }
}
