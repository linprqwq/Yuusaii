package com.lin.dao.impl;

import com.lin.dao.MeetDao;
import com.lin.pojo.Meet;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class MeetDaoImpl implements MeetDao {
    public ArrayList<Meet> selectservlet(Meet r, int pagenum, int pagesize) {



        ArrayList<Meet> list =new ArrayList<Meet>();
        ArrayList params=new ArrayList();


        String sql="SELECT * FROM meet WHERE 1=1";

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
            list = (ArrayList<Meet>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<Meet>(Meet.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public int querynewstypecountbycond(Meet r){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from meet where 1=1";

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


    public int add(Meet r) {
        int num = 0;
        //1.写sql
        String sql = "insert into meet values(null,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{r.getName(),r.getAddress(),r.getNum(),r.getRemark()};

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

    public Meet selectByid(int id) {


        Meet r = null;
        //1.sql
        String sql = "SELECT * FROM meet where id=?";
        //2.参数
        Object[] params = new Object[]{id};
        //3.执行器
        QueryRunner queryRunner = new QueryRunner();
        //4.执行
        try {
            r = queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanHandler<Meet>(Meet.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }


    public int xg(Meet r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE meet SET NAME=?,address=?,num=?,remark=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getName(),r.getAddress(),r.getNum(),r.getRemark(),r.getId()};

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
        String sql = "DELETE  FROM meet WHERE id=?";
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
    public ArrayList<Meet> cxmeet() {
        ArrayList<Meet> list =new ArrayList<Meet>();

        String sql ="select * from meet";

        try {
            list=(ArrayList<Meet>)new QueryRunner().query(DBUtil.getConn(),
                    sql,
                    new BeanListHandler<Meet>(Meet.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
