package com.lin.service.impl;

import com.lin.dao.QjDao;
import com.lin.dao.impl.QjDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.Qj;
import com.lin.service.QjService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QjServiceImpl implements QjService {

    QjDao qjDao=new QjDaoImpl();
    public boolean ad(Qj r){
        return qjDao.add(r)== 1 ? true : false;
    }

    @Override
    public PageInfo<Qj> selm(Qj m, int pagenum, int pagesize) {


        PageInfo<Qj> pageInfo = new PageInfo<Qj>();


        pageInfo.setRows(qjDao.selectservlet(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = qjDao.querynewstypecountbycond(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;
    }

    public boolean tg(Qj r) {


       String btime=r.getBtime();
       String stime=r.getStime();
       //开始时间转化string转data(sql)
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date btime1=null;

        Date time1= null;
        try {
            time1 = df.parse(btime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取毫秒数转换sql(data)
        btime1=new java.sql.Date(time1.getTime());

        int b= btime1.getDate();
       //结束时间转化
        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date stime1=null;

        Date time2= null;
        try {
            time2 = df1.parse(stime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        stime1=new java.sql.Date(time2.getTime());

        int s=stime1.getDate();

        //获取结果
        String jg=r.getJg();
        if(jg.equals("jlsp")){
        return qjDao.tg(r)==1 ? true : false;
        }

       //获取副经理zid(为副经理请假专用)
        int zid=r.getZid();
        if(zid==2){
            return qjDao.tg(r)==1 ? true : false;
        }

        //判断
        if(s-b>=3){
        return  qjDao.jlsp(r)==1 ? true : false;
        }else{
          return qjDao.tg(r)==1 ? true : false;
        }


    }

    public boolean btg(Qj r) {
            return qjDao.btg(r)== 1 ? true : false;
    }

    @Override
    public PageInfo<Qj> selm1(Qj m, int pagenum, int pagesize) {

        PageInfo<Qj> pageInfo = new PageInfo<Qj>();


        pageInfo.setRows(qjDao.selectservlet1(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = qjDao.querynewstypecountbycond1(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;

    }


    @Override
    public PageInfo<Qj> selm2(Qj m, int pagenum, int pagesize) {

        PageInfo<Qj> pageInfo = new PageInfo<Qj>();


        pageInfo.setRows(qjDao.selectservlet2(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = qjDao.querynewstypecountbycond2(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;

    }


    @Override
    public PageInfo<Qj> selm3(Qj m, int pagenum, int pagesize) {

        PageInfo<Qj> pageInfo = new PageInfo<Qj>();


        pageInfo.setRows(qjDao.selectservlet3(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = qjDao.querynewstypecountbycond3(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;

    }
}
