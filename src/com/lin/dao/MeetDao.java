package com.lin.dao;


import com.lin.pojo.Meet;

import java.util.ArrayList;
import java.util.List;

public interface MeetDao {
    public List<Meet> selectservlet(Meet r, int pagenum, int pagesize);

    public int querynewstypecountbycond(Meet r);

    public int add(Meet r);

    public   Meet selectByid(int id);

    public  int xg(Meet r);

    public  int del(int id);

   public ArrayList<Meet> cxmeet();
}
