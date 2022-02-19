package com.example.assignment8.Services;
import java.util.List;
import com.example.assignment8.Dao.ProductRepo;
import com.example.assignment8.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void addProduct(Product product) {
        productRepo.save(product);
    }


    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }


    public Product getProductById(int id) {
        return productRepo.findById(id);
    }


    public Product getProductByName(String name) {
        return productRepo.findByName(name);
    }


    public Product updateProduct(Product product) {
        productRepo.save(product);
        return product;
    }
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

}
