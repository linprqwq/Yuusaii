package com.lin.dao.impl;

import com.lin.dao.EmailDao;
import com.lin.pojo.Email;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmailDaoImpl implements EmailDao {
    /*public int xj(Email e) {
        String sql=" INSERT INTO email_info VALUES(NULL,?,?,?,?,?,?)";
        return DbUtil.update(sql,e.getFromuid(),e.getTouid(),e.getTitle(),e.getContent(),e.getSendtime(),e.getState());
    }*/

    public int xj(Email e) {
        int num = 0;
        //1.写sql
        String sql = "INSERT INTO email_info VALUES(NULL,?,?,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{e.getFromuid(),e.getTouid(),e.getTitle(),e.getContent(),e.getSendtime(),e.getState()};

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
    public ArrayList<Email> sj() {
        ArrayList<Email> list = new ArrayList<Email>();

        String sql = "select * from email_info";

        QueryRunner queryRunner = new QueryRunner();

        try {
            list = (ArrayList<Email>) queryRunner.query(DBUtil.getConn(),
                    sql,
                    new BeanListHandler<Email>(Email.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

   /* @Override
    public int sc(int id) {
        String sql="UPDATE email_info SET state=1 WHERE id=?";
        return DbUtil.update(sql,id);
    }*/

    public int sc(int id) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE email_info SET state=1 WHERE id=?";
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

    /*@Override
    public int hf(int id) {
        String sql="UPDATE email_info SET state=0 WHERE id=?";
        return DbUtil.update(sql,id);
    }*/

    public int hf(int id) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE email_info SET state=0 WHERE id=?";
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
    public int zsc(int id) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE email_info SET state=2 WHERE id=?";
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
