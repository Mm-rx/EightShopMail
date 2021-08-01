package com.eight.service.Impl;

import com.eight.bean.OrderCart;
import com.eight.bean.ProductCategory;
import com.eight.mapper.CartMapper;

import java.sql.Timestamp;
import java.util.Date;

public interface
CartService<modifiedTime> {
    static void addToCart(int userId, String username, Long productId, Integer productTotalAmount) {
        // 创建当前时间对象now
        Date now = new Date();
        // 调用findByUidAndPid()查询购物车详情
        CartMapper result = result.findByUidAndPid();
        // 判断查询结果是否为null
        Long cartId = null;
        if (result == null) {
            // 是：表示该用户的购物车没有该商品，则需要执行insert操作
            // -- 调用productServiceImpl.queryAllProductInfo()得到商品详情，该数据中包含商品价格
            ProductCategory product = ProductServiceImpl.queryAllProductInfo(productId);
            // -- 创建新的OrderCart对象
            OrderCart OrderCart = new OrderCart();
            // -- 补全Cart对象的属性：cartId > 参数cartId
            OrderCart.setCartId(cartId);
            // -- 补全Cart对象的属性：uid > 参数uid
            OrderCart.setUserId(userId);
            // -- 补全Cart对象的属性：pid > 参数pid
            OrderCart.setProductId(productId);
            // -- 补全Cart对象的属性：num > 参数amount
            OrderCart.setProductTotalAmount(productTotalAmount);
            // -- 补全Cart对象的属性：price > 以上查询到的商品详情中包含价格
            OrderCart.setPrice(OrderCart.getPrice());
            // -- 补全Cart对象的属性：4个日志 > 参数username, now
            OrderCart.setAddTime((Timestamp) now);
            OrderCart.setModifiedTime((Timestamp) now);
            // -- 调用insert()插入数据
            result.insert(OrderCart);
        } else {
            // 否：表示该用户的购物车已有该商品，则需要执行update操作增加数量
            // -- 从查询结果中获取cid
            cartId = result.getCartId();
            // -- 从查询结果中取出原有数量，与参数amount相加，得到新的数量
            Integer amount = null;
            Integer num = result.getAmount() + amount;
            // -- 调用updateNumByCid()执行修改数量
            CartMapper.updateAmountByCid(cartId, username, now);
        }
    }



    /**
     * 将商品添加到购物车
     * @param cartId              购物车id
     * @param userId              用户id
     * @param username            用户名
     * @param productId           商品的id
     * @param productTotalAmount  添加的商品数量
     */

    public default void addToCart(Integer cartId, Integer userId, String username, Integer productId, Integer productTotalAmount){
    }

}




