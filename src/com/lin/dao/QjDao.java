package com.lin.dao;




import com.lin.pojo.Qj;

import java.util.List;

public interface QjDao {

    public int add(Qj r);

    public List<Qj> selectservlet(Qj m, int pagenum, int pagesize);

    public int querynewstypecountbycond(Qj m);

    public  int tg(Qj r);
    public  int btg(Qj r);

    public  int jlsp(Qj r);

    public List<Qj> selectservlet1(Qj m, int pagenum, int pagesize);

    public int querynewstypecountbycond1(Qj m);


    public List<Qj> selectservlet2(Qj m, int pagenum, int pagesize);

    public int querynewstypecountbycond2(Qj m);


    public List<Qj> selectservlet3(Qj m, int pagenum, int pagesize);

    public int querynewstypecountbycond3(Qj m);
}
