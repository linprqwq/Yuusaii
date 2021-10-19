package com.lin.service;

import com.lin.pojo.PageInfo;
import com.lin.pojo.ProMeet;

public interface ProMeetService {
    public boolean ad(ProMeet r);

    public  PageInfo<ProMeet> selm(ProMeet m, int pagenum, int pagesize);

    public  PageInfo<ProMeet> selm1(ProMeet m, int pagenum, int pagesize);

    public  PageInfo<ProMeet> selm2(ProMeet m, int pagenum, int pagesize);

    public  void tg(ProMeet r);
    public  boolean btg(ProMeet r);
}
