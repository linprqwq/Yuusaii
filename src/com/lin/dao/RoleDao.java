package com.lin.dao;

import com.lin.pojo.RoleInfo;

import java.util.List;

public interface RoleDao {

    public List<RoleInfo> queryallrole();



    public  List<RoleInfo> selectservlet(RoleInfo r, int pagenum, int pagesize);

    public int querynewstypecountbycond(RoleInfo r);

    public int add(RoleInfo r);

    public   RoleInfo selectByid(int id);

    public  int xg(RoleInfo r);

    public  int del(int id);
}
