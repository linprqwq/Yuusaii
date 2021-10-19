package com.lin.dao;

import com.lin.pojo.MenuInfo;
import com.lin.pojo.MenuRoleInfo;

import java.util.List;

public interface MenuDao {

    /**
     * 根据父id，查询菜单信息
     * @param pid
     * @return
     */
    public List<MenuInfo> querymenusbypid(int pid);

    /**
     * 根据父id和角色id，查找菜单集合
     * @param pid
     * @param rid
     * @return
     */
    public List<MenuInfo> querymenusbypidandrid(int pid,int rid);

    public List<MenuInfo> queryallmenu();

    public  List<MenuInfo> selectservlet(MenuInfo m, int pagenum, int pagesize);

   public int querynewstypecountbycond(MenuInfo m);

   public int add(MenuInfo m);

  public   MenuInfo selectByid(int id);

  public  int xg(MenuInfo m);

  public  int del(int id);

  public  List<MenuRoleInfo> querymenurole(int rid);

  public  int ff(int id);
}
