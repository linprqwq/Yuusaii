package com.lin.service.impl;

import com.lin.dao.ZwDao;
import com.lin.dao.impl.ZwDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.Zw;
import com.lin.servlet.EmailServlet;

public class ZwServiceImpl implements EmailServlet.ZwService {

    ZwDao zwDao=new ZwDaoImpl();

    public PageInfo<Zw> selm(Zw r, int pagenum, int pagesize){
        PageInfo<Zw> pageInfo = new PageInfo<Zw>();


        pageInfo.setRows(zwDao.selectservlet(r,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = zwDao.querynewstypecountbycond(r);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(r);
        return pageInfo;
    }


    public boolean ad(Zw r){
        return zwDao.add(r)== 1 ? true : false;
    }

    public Zw selById(int id){
        return zwDao.selectByid(id);
    }

    @Override
    public boolean xg(Zw r) {
        return zwDao.xg(r)== 1 ? true : false;
    }

    public boolean del(int id){
        return zwDao.del(id)== 1 ? true : false;
    }
}
