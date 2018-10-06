package com.example.service.common.config;

public class ConfigConstant {

    /*表中数据的状态*/
    public final static String TABLE_STATUS_DELETE = "0"; // 逻辑删除
    public final static String TABLE_STATUS_NORMAL = "1"; // 正常

    /*用户的状态*/
    public final static String USER_STATUS_DELETE = "0"; // 逻辑删除
    public final static String USER_STATUS_NORMAL = "1"; // 正常
    public final static String USER_STATUS_ACCOUNT_LOCKED = "2"; // 账号锁定
    public final static String USER_STATUS_PASSWORD_LOCKED = "3"; // 输入密码次数锁定

    /*错误码*/
    public final static String REQUEST_ERROR_CODE_0001 = "0001"; // 参数缺失
    public final static String REQUEST_ERROR_CODE_0002 = "0002"; // 查询数据不存在


}
