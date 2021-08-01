package com.eight.service.Impl;

import com.eight.bean.OrderCart;
import com.eight.mapper.CartMapper;
import com.eight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartServiceImpl<cartMapper> {

    private cartMapper mapper;
    private CartMapper cartMapper;
    private OrderCart cart;
    @Autowired
    private ProductService productService;

    /**
     * 插入购物车数据
     *
     * @param ("cart") 购物车数据
     */
    public void insert(OrderCart cart) {
        Integer rows = cartMapper.insert(cart);

    }

    /**
     * 修改购物车中商品的数量
     *
     * @param userId             用户id
     * @param cartId             购物车数据id
     * @param productTotalAmount 种类数量
     * @param addTime            添加时间
     * @param modifiedTime       最后修改时间
     */
    private void updateAmountByCid(Integer cartId,
                                   Integer userId,
                                   Integer productTotalAmount,
                                   Integer price,
                                   Date addTime,
                                   Date modifiedTime) throws UpdateException {
        Integer rows = cartMapper.updateAmountByCid(userId, cartId, productTotalAmount, price, addTime, modifiedTime);
        if (rows != 1) {
            throw new UpdateException("修改商品数量失败！更新购物车数据时出现未知错误，请联系系统管理员！");
        }
    }

    /**
     * 查询某用户在购物车添加的某商品的详情
     *
     * @param ("cartId")    Integer cartId; 购物车id;
     * @param ("userId")    Integer userId ;用户的id
     * @param ("productId") Integer productId;  商品的id
     * @return 匹配的购物车详情，如果该用户没有将该商品添加到购物车，则返回null
     */
    private CartMapper findByUidAndPid(Integer cartId, Integer userId, Integer productId) {
        return CartMapper.findByUidAndPid(cartId, userId, productId);
    }


}


