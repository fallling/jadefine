package com.leng.jadefine.service.impl;

import com.leng.jadefine.mapper.OrderDetailMapper;
import com.leng.jadefine.mapper.OrderMapper;
import com.leng.jadefine.mapper.ProductMapper;
import com.leng.jadefine.model.Product;
import com.leng.jadefine.service.ProductService;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:ProductServiceImpl
 * Author:fall
 * Date:2021/6/6 1:21
 * Description:ProdectService 实现类
 */

@Service
@Component("productService")
public class ProductServiceImpl implements ProductService {


    @Override
    public List<Product> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> productList = productMapper.queryAll();
        sqlSession.close();
        return productList;
    }

    @Override
    public Product queryById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.queryById(id);
        sqlSession.close();
        return product;
    }

    @Override
    public Product queryByName(String name) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.queryByName(name);
        sqlSession.close();
        return product;
    }

    @Override
    public void addProduct(Product product) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.addProduct(product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteProduct(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        Product product = productMapper.queryById(id);
        if(product!=null){

            /*删除子表*/
            SqlSession sqlSession1 = MybatisUtil.getSqlSession();
            OrderDetailMapper orderDetailMapper = sqlSession1.getMapper(OrderDetailMapper.class);
            orderDetailMapper.deleteOrderDetailByProductId(product.getId());
            sqlSession1.commit();
            sqlSession1.close();

            /*删除数据*/
            productMapper.deleteProduct(id);
        }


        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateProduct(Product product) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        productMapper.updateProduct(product);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void saveProduct(Product product){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product1 = productMapper.queryById(product.getId());
        if(product1!=null){
            productMapper.updateProduct(product);
        }else
            productMapper.addProduct(product);
        sqlSession.commit();
        sqlSession.close();
    }
}
