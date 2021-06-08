package com.leng.jadefine.service.impl;

import com.leng.jadefine.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:ProductServiceImplTest
 * Author:fall
 * Date:2021/6/6 1:25
 * Description:
 */

class ProductServiceImplTest {

    ProductServiceImpl productService = new ProductServiceImpl();
    @Test
    void queryAll() {
        productService.queryAll();
    }

    @Test
    void queryById() {
        productService.queryById(1);
    }

    @Test
    void queryByName() {
        productService.queryByName("无尽之刃");
    }

    @Test
    void addProduct() {
        Product product = new Product();
        product.setName("宗师之力");
        product.setType("攻击");
        product.setCode("APX00513");
        productService.addProduct(product);
    }

    @Test
    void deleteProduct() {

        productService.deleteProduct(1);
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("宗师之力");
        product.setType("攻击");
        product.setCode("APX00513");
        productService.updateProduct(product);
    }

    @Test
    void saveProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("宗师之力");
        product.setType("攻击");
        product.setCode("APX00513");
        productService.saveProduct(product);
    }
}