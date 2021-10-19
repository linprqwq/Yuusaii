package com.lin.service;

import com.lin.pojo.Meet;
import com.lin.pojo.PageInfo;


public interface MeetService {

    public PageInfo<Meet> selm(Meet r, int pagenum, int pagesize);

    public boolean ad(Meet r);

    public  Meet selById(int id);

    public  boolean xg(Meet r);

    public  boolean del(int id);
}
