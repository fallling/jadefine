package com.leng.jadefine.service;

import com.leng.jadefine.model.Product;

import java.util.List;

/**
 * FileName:ProductService
 * Author:fall
 * Date:2021/6/6 0:45
 * Description:商品Service
 */
public interface ProductService {

    List<Product> queryAll();

    Product queryById(int id);

    Product queryByName(String name);

    void addProduct(Product product);

    /*删除Product @Param id*/
    void deleteProduct(int id);

    void updateProduct(Product product);

    void saveProduct(Product product);
}
