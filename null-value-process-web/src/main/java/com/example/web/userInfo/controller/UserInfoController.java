package com.example.web.userInfo.controller;

import com.alibaba.fastjson.JSON;
import com.example.service.common.JsonResult;
import com.example.service.common.controller.AbstractController;
import com.example.service.userInfo.model.UserInfo;
import com.example.service.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("userInfo")
public class UserInfoController extends AbstractController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("listByObj")
    public JsonResult listByObj(@RequestBody UserInfo userInfo){
        try {
            logger.info("查询接到的数据：" + JSON.toJSON(userInfo));
            List<UserInfo> userInfos = userInfoService.listByObj(userInfo);
            return getJson("查询成功", SUCCESS, userInfos);
        }catch (Exception e){
            e.printStackTrace();
            return getJson("查询失败", ERROR, "");
        }
    }

    @RequestMapping("listByObj2")
    public JsonResult listByObj2(@RequestBody UserInfo userInfo){
        try {
            logger.info("查询接到的数据：" + JSON.toJSON(userInfo));
            List<UserInfo> userInfos = userInfoService.listByObj(userInfo);
            List<String> strings = new ArrayList<>();
            strings.add("hello");
            strings.add("world");
            if(userInfos != null && !userInfos.isEmpty()){
                for (UserInfo userInfo1: userInfos){
                    userInfo1.setStrings(strings);
                }
            }
            return getJson("查询成功", SUCCESS, userInfos);
        }catch (Exception e){
            e.printStackTrace();
            return getJson("查询失败", ERROR, "");
        }
    }
}
