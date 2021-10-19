package com.lin.service.impl;

import com.lin.dao.MeetDao;
import com.lin.dao.impl.MeetDaoImpl;
import com.lin.pojo.Meet;
import com.lin.pojo.PageInfo;
import com.lin.service.MeetService;

public class MeetServiceImpl implements MeetService {

            MeetDao meetDao=new MeetDaoImpl();
    public PageInfo<Meet> selm(Meet r, int pagenum, int pagesize){
        PageInfo<Meet> pageInfo = new PageInfo<Meet>();


        pageInfo.setRows(meetDao.selectservlet(r,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = meetDao.querynewstypecountbycond(r);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(r);
        return pageInfo;
    }


    public boolean ad(Meet r){
        return meetDao.add(r)== 1 ? true : false;
    }

    public Meet selById(int id){
        return meetDao.selectByid(id);
    }

    @Override
    public boolean xg(Meet r) {
        return meetDao.xg(r)== 1 ? true : false;
    }

    public boolean del(int id){
        return meetDao.del(id)== 1 ? true : false;
    }


}
