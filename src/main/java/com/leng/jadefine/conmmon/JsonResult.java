package com.leng.jadefine.conmmon;

import lombok.Data;

/**
 * FileName:JsonResult
 * Author:fall
 * Date:2021/6/7 1:29
 * Description:
 */

@Data
public final class JsonResult {
    private boolean success = true;
    private String msg;

    public JsonResult(){
    }

    public JsonResult(String msg){
        this.msg = msg;
    }

    public static JsonResult success(){
        return new JsonResult();
    }

    public static JsonResult success(String msg){
        return new JsonResult(msg);
    }

    public static JsonResult error(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        return jsonResult;
    }

    public static JsonResult error(String msg){
        JsonResult jsonResult = new JsonResult(msg);
        jsonResult.setSuccess(false);
        return jsonResult;
    }


}
