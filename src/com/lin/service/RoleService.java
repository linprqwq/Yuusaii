package com.lin.service;

import com.lin.pojo.PageInfo;
import com.lin.pojo.RoleInfo;

import java.util.List;

public interface RoleService {



    public List<RoleInfo> queryallrole();

    public PageInfo<RoleInfo> selm(RoleInfo r, int pagenum, int pagesize);

    public boolean ad(RoleInfo r);

    public  RoleInfo selById(int id);

    public  boolean xg(RoleInfo r);

    public  boolean del(int id);

}
