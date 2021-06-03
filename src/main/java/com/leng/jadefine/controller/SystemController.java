package com.leng.jadefine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName:SystemController
 * Author:fall
 * Date:2021/6/3 16:05
 * Description:system controller
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    public String toSystem(){
        return "index";
    }
}
