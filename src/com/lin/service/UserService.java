package com.lin.service;

import com.lin.pojo.PageInfo;
import com.lin.pojo.UserInfo;

public interface UserService {

    /**
     * 根据用户名和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo queryuserbyloginnameandpwd(UserInfo userInfo);


    public PageInfo<UserInfo> selm(UserInfo u, int pagenum, int pagesize);

    public boolean ad(UserInfo u);

    public  UserInfo selById(int id);

    public  boolean xg(UserInfo u);

    public  boolean del(int id);


}
