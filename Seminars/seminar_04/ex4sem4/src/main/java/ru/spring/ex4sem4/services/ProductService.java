package ru.spring.ex4sem4.services;

import org.springframework.stereotype.Service;
import ru.spring.ex4sem4.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public Product addProduct(Product product){
        products.add(product);
        return product;
    }

    public List<Product> allProducts(){
        return products;
    }
}
