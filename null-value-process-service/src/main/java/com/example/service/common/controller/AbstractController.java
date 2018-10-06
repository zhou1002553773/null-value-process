package com.example.service.common.controller;

import com.example.service.common.JsonResult;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String MESSAGE = "";
    protected String SUCCESS = "1";
    protected String ERROR = "0";

    protected JsonResult getJson(String message, String isSuccess, Object jsonData) {
        return this.getJson(message, isSuccess, jsonData, null, null);
    }

    protected JsonResult getJson(String message, String isSuccess, Object jsonData, String errorCode) {
        return this.getJson(message, isSuccess, jsonData, errorCode, null);
    }


    protected JsonResult getJson(String message, String isSuccess, Object jsonData, String errorCode, String permission) {
        JsonResult result = new JsonResult();
        if (jsonData instanceof PageList) {
            result = this.getJsonMyBatis(message,isSuccess,jsonData,permission,errorCode);
        } else {
            result.setSuccess(isSuccess);
            result.setMessage(message);
            result.setPermission(permission);
            result.setErrorCode(errorCode);
            result.setResult(jsonData);
            result.setResponseTime(new Date(System.currentTimeMillis()));
        }
        return result;
    }

    protected JsonResult getJsonMyBatis(String message, String isSuccess, Object jsonData) {
        return this.getJsonMyBatis(message, isSuccess, jsonData, null, null);
    }

    protected JsonResult getJsonMyBatis(String message, String isSuccess, Object jsonData, String errorCode) {
        return this.getJsonMyBatis(message, isSuccess, jsonData, errorCode, null);
    }

    protected JsonResult getJsonMyBatis(String message, String isSuccess, Object jsonData, String errorCode, String permission) {
        JsonResult result = new JsonResult();
        result.setSuccess(isSuccess);
        result.setMessage(message);
        result.setPermission(permission);
        result.setErrorCode(errorCode);
        if (jsonData instanceof PageList) {
            PageList<Object> pageData = (PageList<Object>) jsonData;
            result.setResult(pageData);
            result.setPageSize(String.valueOf(pageData.getPaginator().getLimit()));
            result.setPageNumber(String.valueOf(pageData.getPaginator().getPage()));
            result.setTotal(String.valueOf(pageData.getPaginator().getTotalCount()));
            result.setTotalPages(String.valueOf(pageData.getPaginator().getTotalPages()));
        } else {
            result.setResult(jsonData);
        }
        result.setResponseTime(new Date(System.currentTimeMillis()));
        return result;
    }
}
