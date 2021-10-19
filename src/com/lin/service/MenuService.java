package com.lin.service;

import com.lin.pojo.MenuInfo;
import com.lin.pojo.PageInfo;

import java.util.List;

public interface MenuService {

    /**
     * 查询所有菜单信息
     * 菜单信息  是由父子关系的集合数据
     * @return
     */
    public List<MenuInfo> queryallmenus(int rid);

    /**
     * 根据角色id，查询权限表存在的菜单信息
     * 菜单信息  是由父子关系的集合数据
     * @return
     */
    public List<MenuInfo> querymenusbyrid(int rid);


    /**
     * 查询所有菜单信息 没有层级关系 单纯的查出所有数据
     * @return
     */
    public List<MenuInfo> queryallmenus2();

  public  PageInfo<MenuInfo> selm(MenuInfo m, int pagenum, int pagesize);

  public boolean ad(MenuInfo m);

  public  MenuInfo selById(int parseInt);

  public  boolean xg(MenuInfo m);

  public   boolean del(int id);

  public   boolean ff(int id);
}
