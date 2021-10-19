package com.lin.dao;


import com.lin.pojo.Zw;

import java.util.List;

public interface ZwDao {
  public  List<Zw> queryallzw();


  public  List<Zw> selectservlet(Zw r, int pagenum, int pagesize);

  public int querynewstypecountbycond(Zw r);

  public int add(Zw r);

  public   Zw selectByid(int id);

  public  int xg(Zw r);

  public  int del(int id);
}
