package com.lin.service.impl;

import com.lin.dao.ProMeetDao;
import com.lin.dao.impl.ProMeetDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.ProMeet;
import com.lin.service.ProMeetService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProMeetServiceImpl implements ProMeetService {
    ProMeetDao proMeetDao=new ProMeetDaoImpl();
    public boolean ad(ProMeet r){
        return proMeetDao.add(r)== 1 ? true : false;
    }

    @Override
    public PageInfo<ProMeet> selm(ProMeet m, int pagenum, int pagesize) {
        PageInfo<ProMeet> pageInfo = new PageInfo<ProMeet>();


        pageInfo.setRows(proMeetDao.selectservlet(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = proMeetDao.querynewstypecountbycond(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;
    }


    public PageInfo<ProMeet> selm1(ProMeet m, int pagenum, int pagesize) {
        PageInfo<ProMeet> pageInfo = new PageInfo<ProMeet>();


        pageInfo.setRows(proMeetDao.selectservlet1(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = proMeetDao.querynewstypecountbycond1(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;
    }

    public PageInfo<ProMeet> selm2(ProMeet m, int pagenum, int pagesize) {
        PageInfo<ProMeet> pageInfo = new PageInfo<ProMeet>();


        pageInfo.setRows(proMeetDao.selectservlet2(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = proMeetDao.querynewstypecountbycond2(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;
    }

    public void tg(ProMeet r) {
        String btime = r.getBtime();

        //??????????????????string???data(sql)
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date btime1 = null;

        Date time1 = null;
        try {
            time1 = df.parse(btime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //?????????????????????sql(data)
        btime1 = new java.sql.Date(time1.getTime());
        //????????????????????????
        int b = btime1.getDate();

        //???????????????id
        int uid = r.getUid();

        //?????????????????????????????????(??????)
        List<ProMeet> litime = proMeetDao.cxbyuid(uid);

        //?????????????????????
        for (ProMeet proMeet : litime) {
            //?????????????????????
            String dbtime = proMeet.getBtime();

            //??????????????????string???data(sql)
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date btime2 = null;

            Date time2 = null;
            try {
                time2 = df1.parse(dbtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //?????????????????????sql(data)
            btime2 = new java.sql.Date(time2.getTime());
            //????????????????????????
            int db = btime2.getDate();

            /*System.out.println(db);*/


            if (b >= db) {
                proMeetDao.jqsp(r);
            } else {
                proMeetDao.tg(r);
            }
        }

    }

    public boolean btg(ProMeet r) {
        return proMeetDao.btg(r)== 1 ? true : false;
    }

}
