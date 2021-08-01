package com.eight.controller;

import com.eight.service.Impl.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("carts")
public class CartController {
    private Integer userId;
    private Integer productId;
    private Integer productTotalAmount;

    // http://localhost:8080/carts/add?pid=10000017&amount=3
        @PostMapping("add")
        public <JsonResult, JsonResultv> JsonResultv addToCart(Integer pid, Integer amount, HttpSession session) {
            // 从bean中获取userId和username
            Integer userId = getuser_idFromSession(session);
            String username = getusernameFromSession(session);
            // 调用业务方法执行功能
            CartController cartService;
            CartService.addToCart(userId, username, productId, productTotalAmount);
            /* 响应成功 */
            return new JsonResult<List>(OK);
        }

    private Integer getuser_idFromSession(HttpSession session) {
        return null;
    }

    private String getusernameFromSession(HttpSession session) {
        return null;
    }

}



