package com.example.sessionjdbc.controller;

import com.example.sessionjdbc.repository.ProductRepository;
import com.example.sessionjdbc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String showHomePage(HttpSession session, Model model) {
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("cartCount", cartService.counItemInCart(session));
        return "index";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
        cartService.addToCart(id, session);
        return "redirect:/";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        model.addAttribute("cart", cartService.getCart(session));
        return "checkout";
    }
}
