package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/add-product")
    public String showAddProductPage(Model model) {
        model.addAttribute("product", new Product()); // Creates a blank product for the form
        return "add-product"; // This must match the name of your add-product.html file
    }


    @PostMapping("/save-product") // This must match your form action exactly
    public String saveProduct(@ModelAttribute("product") Product product) {
        // 1. Save the new product to the database
        productRepository.save(product);

        // 2. Redirect back to the home page so you can see the new list
        return "redirect:/";
    }

    // KEEP THIS - It shows the form pre-filled with existing data
    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(Math.toIntExact(id)).orElseThrow();
        model.addAttribute("product", product);
        return "add-product";
    }
    @GetMapping("/")
    public String viewHomePage(Model model) {
        // 1. Use the repository you already have to get all products
        List<Product> listProducts = productRepository.findAll();

        // 2. Add that list to the model so index.html can see it
        model.addAttribute("listProducts", listProducts);

        return "index";
    }
    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id) {
        // This is where you would save the product to a cart object or session
        System.out.println("Product " + id + " was clicked!");

        // This sends the user back to the store page immediately
        return "redirect:/";
    }


}