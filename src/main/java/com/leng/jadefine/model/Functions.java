package com.leng.jadefine.model;

import lombok.Data;

/**
 * FileName:Functions
 * Author:fall
 * Date:2021/6/5 23:38
 * Description:系统功能
 */

@Data
public class Functions {
    private int id;
    private String name;
    private int parentId;
    private String url;
    private boolean isLeaf;
    private int nodeOrder;
}
