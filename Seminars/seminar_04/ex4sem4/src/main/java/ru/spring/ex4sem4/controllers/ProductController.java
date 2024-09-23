package ru.spring.ex4sem4.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spring.ex4sem4.model.Product;
import ru.spring.ex4sem4.services.ProductService;

import java.util.List;

@Controller
@AllArgsConstructor //тогда не надо ставить автовайред в поля, ломбок сам сгенерит конструкторы, а спринг заинжектит
public class ProductController {

    private ProductService service;

    @GetMapping("/products")
    public String allProducts(Model md){
        List<Product> products = service.allProducts();

        md.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Model md, Product product){
        service.addProduct(product);
        md.addAttribute("products", service.allProducts());
        return "products";
    }
}
