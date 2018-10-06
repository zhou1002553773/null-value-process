package com.example.service.userInfo.service;

import com.example.service.userInfo.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> listByObj(UserInfo userInfo) throws Exception;
}
