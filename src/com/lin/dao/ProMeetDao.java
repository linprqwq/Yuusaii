package com.lin.dao;

import com.lin.pojo.ProMeet;

import java.util.List;

public interface ProMeetDao {

    public int add(ProMeet r);

   public List<ProMeet> selectservlet(ProMeet m, int pagenum, int pagesize);

   public int querynewstypecountbycond(ProMeet m);

    public List<ProMeet> selectservlet1(ProMeet m, int pagenum, int pagesize);
    public int querynewstypecountbycond1(ProMeet m);

    public List<ProMeet> selectservlet2(ProMeet m, int pagenum, int pagesize);
    public int querynewstypecountbycond2(ProMeet m);

    public  int tg(ProMeet r);
    public  int btg(ProMeet r);


    //时间需求用
    public List<ProMeet> cxbyuid(int uid);

    //机器审批
    public int jqsp(ProMeet r);
}
