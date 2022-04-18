package com.example.sessionjdbc.service;

import com.example.sessionjdbc.model.Cart;
import com.example.sessionjdbc.model.OrderLine;
import com.example.sessionjdbc.model.Product;
import com.example.sessionjdbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Long id, HttpSession session) {
        HashMap<Long, OrderLine> cart;
        var rawCart = session.getAttribute("CART");
        if (rawCart instanceof HashMap) {
            cart = (HashMap<Long, OrderLine>) rawCart;
        } else {
            cart = new HashMap<>();
        }
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            OrderLine orderLine = cart.get(id);
            if (orderLine == null) {
                cart.put(id, new OrderLine(product.get(), 1));
            } else {
                orderLine.increaseByOne();
                cart.put(id, orderLine);
            }
        }
        session.setAttribute("CART", cart);
    }

    public int counItemInCart(HttpSession session) {
        Map<Long, OrderLine> cart;

        var rawCart = session.getAttribute("CART");

        if (rawCart instanceof HashMap) {
            cart = (Map<Long, OrderLine>) rawCart;
            return cart.values().stream().mapToInt(OrderLine::getCount).sum();
        } else {
            return 0;
        }


    }

    public Cart getCart(HttpSession session) {
        HashMap<Long, OrderLine> cart;

        var rawCart = session.getAttribute("CART");

        if (rawCart instanceof HashMap) {
            cart = (HashMap<Long, OrderLine>) rawCart;
            return new Cart(
                    cart.values().stream().toList(),  //danh sách các mặt hàng mua
                    0.01f, //%Giảm giá
                    true   //Có tính thuế VAT không?
            );
        } else {
            return new Cart();
        }
    }


}
