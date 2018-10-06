package com.example.service.userInfo.service.impl;

import com.example.service.userInfo.mapper.UserInfoMapper;
import com.example.service.userInfo.model.UserInfo;
import com.example.service.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return 0;
    }

    @Override
    public List<UserInfo> listByObj(UserInfo userInfo) throws Exception{
        return userInfoMapper.listByObj(userInfo);
    }


}
