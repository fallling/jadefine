package com.leng.jadefine.mapper;

import com.leng.jadefine.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName:ProductMapper
 * Author:fall
 * Date:2021/6/5 23:49
 * Description:产品  Mapper
 */

@Mapper
public interface ProductMapper {

    @Select("select * from product_info")
    List<Product> queryAll();

    @Select("select * from product_info where id=#{id}")
    Product queryById(@Param("id") int id);

    @Select("select * from product_info where name=#{name}")
    Product queryByName(@Param("name") String name);

    @Select("select * from product_info where brand=#{brand}")
    List<Product> queryByBrand(@Param("brand") String brand);

    @Insert("insert into product_info(code,name,type,brand,pic,num,price,intro,status,bigPic)values(#{code},#{name},#{type},#{brand},#{pic},#{num},#{price},#{intro},#{status},#{bigPic})")
    void addProduct(Product product);

    @Delete("delete from product_info where id=#{id}")
    void deleteProduct(@Param("id") int id);

    @Update("update product_info set code=#{code},name=#{name},type=#{type},brand=#{brand},pic=#{pic},num=#{num},price=#{price},intro=#{intro},status=#{status},bigPic=#{bigPic} where id=#{id}")
    void updateProduct(Product product);
}
