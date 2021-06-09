package com.leng.jadefine.controller.system;

import com.leng.jadefine.conmmon.JsonResult;
import com.leng.jadefine.model.Product;
import com.leng.jadefine.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName:ProductController
 * Author:fall
 * Date:2021/6/7 1:16
 * Description:产品 controller
 */
@Controller
@RequestMapping("/system/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductServiceImpl productService;


    @RequestMapping
    public void index(){
    }

    @RequestMapping({"form","load"})
    public String form(Integer id, Model model){
        if(id!=null){
            /*编辑*/
            Product product = productService.queryById(id);
            model.addAttribute("product",product);
        }
        return "/system/product/form";
    }

    @PostMapping("list")
    @ResponseBody
    public List<Product> list(Integer id){
        if(id!=null){
            Product product = productService.queryById(id);
            List<Product> productList = new ArrayList<Product>();
            productList.add(product);
            return productList;
        }
        return productService.queryAll();
    }

    @PostMapping({"save","update"})
    @ResponseBody
    public JsonResult from(@Valid Product product , BindingResult bindingResult){
        System.out.println(product);
        productService.saveProduct(product);
        return JsonResult.success();
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonResult delete(int id){
        System.out.println(id);
        Product product = productService.queryById(id);
        if(product!=null){
            productService.deleteProduct(id);
            return JsonResult.success();
        }else {
            return JsonResult.error();
        }
    }
}
