package com.lin.service.impl;

import com.lin.dao.RoleDao;
import com.lin.dao.impl.RoleDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.RoleInfo;
import com.lin.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    RoleDao roleDao =new RoleDaoImpl();

    @Override
    public List<RoleInfo> queryallrole() {
        return roleDao.queryallrole();
    }

    public PageInfo<RoleInfo> selm(RoleInfo r, int pagenum, int pagesize){
        PageInfo<RoleInfo> pageInfo = new PageInfo<RoleInfo>();


        pageInfo.setRows(roleDao.selectservlet(r,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = roleDao.querynewstypecountbycond(r);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(r);
        return pageInfo;
    }


    public boolean ad(RoleInfo r){
        return roleDao.add(r)== 1 ? true : false;
    }

    public RoleInfo selById(int id){
        return roleDao.selectByid(id);
    }

    @Override
    public boolean xg(RoleInfo r) {
        return roleDao.xg(r)== 1 ? true : false;
    }

    public boolean del(int id){
        return roleDao.del(id)== 1 ? true : false;
    }


}
