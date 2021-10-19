package com.lin.dao.impl;

import com.lin.dao.MenuDao;
import com.lin.pojo.MenuInfo;
import com.lin.pojo.MenuRoleInfo;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
    @Override
    public List<MenuInfo> querymenusbypid(int pid) {
        List<MenuInfo> list = new ArrayList<MenuInfo>();

        String sql = "select * from menu_info where parentid =?";

        Object[] params = new Object[]{pid};

        QueryRunner queryRunner =new QueryRunner();

        try {
            list=queryRunner.query(DBUtil.getConn(),sql,
                    new BeanListHandler<MenuInfo>(MenuInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }

    @Override
    public List<MenuInfo> querymenusbypidandrid(int pid, int rid) {
        List<MenuInfo> list = new ArrayList<MenuInfo>();

        String sql = "select m.* from menu_info m" +
                " left join rolemenu_info rm" +
                " on m.id = rm.mid" +
                " where m.parentid =? and rm.rid =?";

        Object[] params = new Object[]{pid,rid};

        QueryRunner queryRunner =new QueryRunner();

        try {
            list=queryRunner.query(DBUtil.getConn(),sql,
                    new BeanListHandler<MenuInfo>(MenuInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<MenuInfo> queryallmenu() {
        List<MenuInfo> list = new ArrayList<MenuInfo>();

        String sql = "select * from menu_info ";



        QueryRunner queryRunner =new QueryRunner();

        try {
            list=queryRunner.query(DBUtil.getConn(),sql,
                    new BeanListHandler<MenuInfo>(MenuInfo.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<MenuInfo> selectservlet(MenuInfo l,int pagenum,int pagesize) {

        ArrayList<MenuInfo> list =new ArrayList<MenuInfo>();
        ArrayList params=new ArrayList();


        String sql="SELECT * FROM menu_info WHERE 1=1";

        if(l.getName()!=null && l.getName()!="") {
            sql+="  and name like concat('%',?,'%')";
            params.add(l.getName());
        }

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);



        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<MenuInfo>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<MenuInfo>(MenuInfo.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public int querynewstypecountbycond(MenuInfo l){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from menu_info where 1=1";

        if(l.getName()!=null && l.getName()!="") {
            sql+="  and name like concat('%',?,'%')";
            params = new Object[]{l.getName()};
        }

        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }


    public int add(MenuInfo m) {
        int num = 0;
        //1.写sql
        String sql = "insert into menu_info values(null,?,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{m.getName(),m.getParentid(),m.getNodetype(),m.getLinkurl(),m.getIsdelete()};

        //3.sql执行器
        QueryRunner queryRunner = new QueryRunner();

        //4.执行sql语句
        try {
            num = queryRunner.update(DBUtil.getConn(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    public MenuInfo selectByid(int id) {


        MenuInfo m = null;
        //1.sql
        String sql = "SELECT * FROM menu_info where id=?";
        //2.参数
        Object[] params = new Object[]{id};
        //3.执行器
        QueryRunner queryRunner = new QueryRunner();
        //4.执行
        try {
            m = queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanHandler<MenuInfo>(MenuInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return m;
    }


    public int xg(MenuInfo m) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE menu_info SET NAME=?,parentid=?,nodetype=?,linkurl=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{m.getName(),m.getParentid(),m.getNodetype(),m.getLinkurl(),m.getId()};

        //3.sql执行器
        QueryRunner queryRunner = new QueryRunner();

        //4.执行sql语句
        try {
            num = queryRunner.update(DBUtil.getConn(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    @Override
    public int del(int id) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE menu_info SET isdelete=1 WHERE id=?";
        //2.参数
        Object[] params = new Object[]{id};

        //3.sql执行器
        QueryRunner queryRunner = new QueryRunner();

        //4.执行sql语句
        try {
            num = queryRunner.update(DBUtil.getConn(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    @Override
    public List<MenuRoleInfo> querymenurole(int rid) {
        List<MenuRoleInfo> list = new ArrayList<MenuRoleInfo>();
        List params=new ArrayList();
        String sql = "select * from rolemenu_info where rid =?";
        params.add(rid);
       /* Object[] params = new Object[]{rid};*/

        QueryRunner queryRunner =new QueryRunner();

        try {
            list=queryRunner.query(DBUtil.getConn(),sql,
                    new BeanListHandler<MenuRoleInfo>(MenuRoleInfo.class),
                    params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public int ff(int id) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE menu_info SET isdelete=0 WHERE id=?";
        //2.参数
        Object[] params = new Object[]{id};

        //3.sql执行器
        QueryRunner queryRunner = new QueryRunner();

        //4.执行sql语句
        try {
            num = queryRunner.update(DBUtil.getConn(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

}
