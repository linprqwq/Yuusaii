package com.lin.dao.impl;

import com.lin.dao.RoleDao;
import com.lin.pojo.RoleInfo;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<RoleInfo> queryallrole() {


        List<RoleInfo> list =new ArrayList<RoleInfo>();

        String sql ="select * from role_info";

        try {
            list=new QueryRunner().query(DBUtil.getConn(),
                    sql,
                    new BeanListHandler<RoleInfo>(RoleInfo.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<RoleInfo> selectservlet(RoleInfo r, int pagenum, int pagesize) {



        ArrayList<RoleInfo> list =new ArrayList<RoleInfo>();
        ArrayList params=new ArrayList();


        String sql="SELECT * FROM role_info WHERE 1=1";

        if(r.getName()!=null && r.getName()!="") {
            sql+="  and name like concat('%',?,'%')";
            params.add(r.getName());
        }

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);



        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<RoleInfo>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<RoleInfo>(RoleInfo.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public int querynewstypecountbycond(RoleInfo r){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from role_info where 1=1";

        if(r.getName()!=null && r.getName()!="") {
            sql+="  and name like concat('%',?,'%')";
            params = new Object[]{r.getName()};
        }


        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }


    public int add(RoleInfo r) {
        int num = 0;
        //1.写sql
        String sql = "insert into role_info values(null,?,?)";
        //2.参数
        Object[] params = new Object[]{r.getName(),r.getRemark()};

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

    public RoleInfo selectByid(int id) {


        RoleInfo r = null;
        //1.sql
        String sql = "SELECT * FROM role_info where id=?";
        //2.参数
        Object[] params = new Object[]{id};
        //3.执行器
        QueryRunner queryRunner = new QueryRunner();
        //4.执行
        try {
            r = queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanHandler<RoleInfo>(RoleInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }


    public int xg(RoleInfo r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE role_info SET NAME=?,remark=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getName(),r.getRemark(),r.getId()};

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
        String sql = "DELETE  FROM role_info WHERE id=?";
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
