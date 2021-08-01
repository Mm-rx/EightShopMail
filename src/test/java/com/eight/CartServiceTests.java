package com.eight;

import com.eight.service.Impl.CartService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class CartServiceTests {

        @Autowired
        private CartService service;

        @Test
        public void addToCart() {
            Integer cartId = 1;
            int userId = 1;
            String username = "小刘同学";
            int productId = 2;
            Integer productTotalAmount = 5;
            service.addToCart(cartId,userId, username, productId, productTotalAmount);
            System.err.println("OK.");
        }

        private class ServiceException extends Throwable {
        }
    }


