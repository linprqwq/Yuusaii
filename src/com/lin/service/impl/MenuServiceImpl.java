package com.lin.service.impl;

import com.lin.dao.MenuDao;
import com.lin.dao.impl.MenuDaoImpl;
import com.lin.pojo.MenuInfo;
import com.lin.pojo.MenuRoleInfo;
import com.lin.pojo.PageInfo;
import com.lin.service.MenuService;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {

    MenuDao menuDao =new MenuDaoImpl();


    @Override
    public List<MenuInfo> queryallmenus(int rid) {
       /* 旧代码*/
       /* List<MenuInfo> list = new ArrayList<MenuInfo>();

        //  先查询pid=0的数据   可以查到所有的一级菜单
        list = menuDao.querymenusbypid(0);

        //循环一级菜单   拿着一级菜单的id，当成pid，找下级菜单
        for (MenuInfo menuInfo : list) {

            List<MenuInfo> childmenus =
                    menuDao.querymenusbypid(menuInfo.getId());

            menuInfo.setChildmenus(childmenus);
        }
        return list;*/


        //*********************为权限优化准备
        //根据角色id，查询权限表   得到一个集合  集合中菜单id，就是当前需要勾上的菜单
        //集合1
        List<MenuRoleInfo> menuRoleInfos=new ArrayList<MenuRoleInfo>();
        menuRoleInfos=menuDao.querymenurole(rid);

        List<MenuInfo> list = new ArrayList<MenuInfo>();

        //  先查询pid=0的数据   可以查到所有的一级菜单
        list = menuDao.querymenusbypid(0);
        //集合2 list

        //循环一级菜单   拿着一级菜单的id，当成pid，找下级菜单
        for (MenuInfo menuInfo : list) {
            //循环集合1
            for (MenuRoleInfo menuRoleInfo : menuRoleInfos) {
                // 集合1 中菜单id == 集合2中菜单id
                if(menuRoleInfo.getMid()==menuInfo.getId()){
                    //菜单对像.setIsChecked=true;
                    menuInfo.setIschecked(true);
                }
            }

            List<MenuInfo> childmenus =
                    menuDao.querymenusbypid(menuInfo.getId());
            //集合3 childmenus
            //循环集合3


            for (MenuInfo childmenu : childmenus) {
                for (MenuRoleInfo menuRoleInfo : menuRoleInfos) {
                    // 集合1 中菜单id == 集合3中菜单id
                    if(menuRoleInfo.getMid()==childmenu.getId()){
                        //菜单对像.setIsChecked=true;
                        childmenu.setIschecked(true);
                    }
                }
            }
            menuInfo.setChildmenus(childmenus);
        }
        return list;
    }

    @Override
    public List<MenuInfo> querymenusbyrid(int rid) {
        List<MenuInfo> list = new ArrayList<MenuInfo>();

        //  先查询pid=0的数据   可以查到所有的一级菜单
        list = menuDao.querymenusbypidandrid(0,rid);

        //循环一级菜单   拿着一级菜单的id，当成pid，找下级菜单
        for (MenuInfo menuInfo : list) {

            List<MenuInfo> childmenus =
                    menuDao.querymenusbypidandrid(menuInfo.getId(),rid);

            menuInfo.setChildmenus(childmenus);
        }
        return list;
    }

    @Override
    public List<MenuInfo> queryallmenus2() {
        return menuDao.queryallmenu();
    }



    public PageInfo<MenuInfo> selm(MenuInfo m, int pagenum, int pagesize){
        PageInfo<MenuInfo> pageInfo = new PageInfo<MenuInfo>();


        pageInfo.setRows(menuDao.selectservlet(m,pagenum,pagesize));


        pageInfo.setPagenum(pagenum);


        int totalrecord = menuDao.querynewstypecountbycond(m);


        int totalpage = totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;

        pageInfo.setTotalpage(totalpage);

        pageInfo.setObj(m);
        return pageInfo;
    }


    public boolean ad(MenuInfo m){
        return menuDao.add(m)== 1 ? true : false;
    }

    public MenuInfo selById(int id){
        return menuDao.selectByid(id);
    }

    @Override
    public boolean xg(MenuInfo m) {
        return menuDao.xg(m)== 1 ? true : false;
    }

    @Override
    public boolean del(int id) {
        return menuDao.del(id)== 1 ? true : false;
    }

    public boolean ff(int id) {
        return menuDao.ff(id)== 1 ? true : false;
    }

}
