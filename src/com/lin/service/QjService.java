package com.lin.service;

import com.lin.pojo.PageInfo;
import com.lin.pojo.Qj;


public interface QjService {

    public boolean ad(Qj r);

    public PageInfo<Qj> selm(Qj m, int pagenum, int pagesize);

    public  boolean tg(Qj r);
    public  boolean btg(Qj r);

    public PageInfo<Qj> selm1(Qj m, int pagenum, int pagesize);

    public PageInfo<Qj> selm2(Qj m, int pagenum, int pagesize);

    public PageInfo<Qj> selm3(Qj m, int pagenum, int pagesize);
}
