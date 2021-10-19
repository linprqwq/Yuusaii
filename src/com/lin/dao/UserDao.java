package com.lin.dao;

import com.lin.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /**
     * 根据用户名和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo queryuserbyloginnameandpwd(UserInfo userInfo);


    public List<UserInfo> selectservlet(UserInfo r, int pagenum, int pagesize);

    public int querynewstypecountbycond(UserInfo r);

    public int add(UserInfo r);

    public  UserInfo selectByid(int id);

    public  int xg(UserInfo r);

    public  int del(int id);

   public ArrayList<UserInfo> showuser();
}
