package com.eight;

import com.eight.bean.OrderCart;
import com.eight.mapper.CartMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {

    @Autowired
    private CartMapper mapper;

    @Test
    public void insert(Long productId, int userId, Object cartId, Integer productTotalAmount, BigDecimal price, Timestamp addTime, Timestamp modifiedTime) {
        OrderCart cart = new OrderCart();
        cart.setCartId((Long) cartId);
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setProductTotalAmount(productTotalAmount);
        cart.setPrice(price);
        cart.setAddTime(addTime);
        cart.setModifiedTime(modifiedTime);
        Integer rows = mapper.insert(cart);
        System.err.println("rows=" + rows);
        System.err.println(cart);
    }

    @Test
    public void updateAmountByCid() {
        Integer userId = 1;
        Integer cartId = 1;
        Integer productTotalAmount = 10;
        Integer price = 2;
        Date addTime= new Date();
        Date modifiedTime = new Date();
        Integer rows = mapper.updateAmountByCid(userId,cartId, productTotalAmount,price, addTime, modifiedTime);
        System.err.println("rows=" + rows);
    }

    @Test
    public void findByUidAndPid() {
        Integer cartId = 1;
        Integer userId = 1;
        Integer productId = 2;
        CartMapper result = CartMapper.findByUidAndPid(cartId,userId,productId);
        System.err.println(result);
    }

}
