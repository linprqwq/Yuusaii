package com.lin.dao.impl;

import com.lin.dao.UserDao;
import com.lin.pojo.UserInfo;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    @Override
    public UserInfo queryuserbyloginnameandpwd(UserInfo userInfo) {

        UserInfo userInfo1 =null;

        //sql
        String sql ="select * from user_info where " +
                "loginname=? and password=?";

        //params
        Object[] params = new Object[]{userInfo.getLoginname(),userInfo.getPassword()};

        //QueryRunner
        QueryRunner queryRunner =new QueryRunner();

        //执行
        try {
            userInfo1=queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanHandler<UserInfo>(UserInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userInfo1;
    }


    public ArrayList<UserInfo> selectservlet(UserInfo r, int pagenum, int pagesize) {



        ArrayList<UserInfo> list =new ArrayList<UserInfo>();
        ArrayList params=new ArrayList();


        String sql="SELECT * FROM user_info WHERE 1=1";

        if(r.getRealname()!=null && r.getRealname()!="") {
            sql+="  and realname like concat('%',?,'%')";
            params.add(r.getRealname());
        }

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);



        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<UserInfo>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<UserInfo>(UserInfo.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public int querynewstypecountbycond(UserInfo r){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from user_info where 1=1";

        if(r.getRealname()!=null && r.getRealname()!="") {
            sql+="  and realname like concat('%',?,'%')";
            params = new Object[]{r.getRealname()};
        }


        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }


    public int add(UserInfo r) {
        int num = 0;
        //1.写sql
        String sql = "insert into user_info values(null,?,?,?,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{r.getRealname(),r.getLoginname(),r.getPassword(),r.getPhone(),r.getAddress(),r.getRid(),r.getZid()};

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

    public UserInfo selectByid(int id) {


        UserInfo r = null;
        //1.sql
        String sql = "SELECT * FROM user_info where id=?";
        //2.参数
        Object[] params = new Object[]{id};
        //3.执行器
        QueryRunner queryRunner = new QueryRunner();
        //4.执行
        try {
            r = queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanHandler<UserInfo>(UserInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }


    public int xg(UserInfo r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE user_info SET realname=?,loginname=?,password=?,phone=?,address=?,rid=?,zid=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getRealname(),r.getLoginname(),r.getPassword(),r.getPhone(),r.getAddress(),r.getRid(),r.getZid(),r.getId()};

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

    public int del(int id){

        int num = 0;
        //1.写sql
        String sql = "DELETE  FROM user_info WHERE id=?";
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
    public ArrayList<UserInfo> showuser() {
        ArrayList<UserInfo> list =new ArrayList<UserInfo>();

        String sql ="select * from user_info";

        try {
            list=(ArrayList)new QueryRunner().query(DBUtil.getConn(),
                    sql,
                    new BeanListHandler<UserInfo>(UserInfo.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
