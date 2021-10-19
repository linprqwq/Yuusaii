package com.lin.dao.impl;

import com.lin.dao.ProMeetDao;
import com.lin.pojo.ProMeet;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProMeetDaoImpl implements ProMeetDao {


    public int add(ProMeet r) {
        int num = 0;
        //1.写sql
        String sql = "insert into promeet values(null,?,?,?,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{r.getHid(),r.getUid(),r.getBtime(),r.getStime(),r.getJg(),r.getSptime(),r.getSpid()};

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



    //分页并查询所有
    public ArrayList<ProMeet> selectservlet(ProMeet r, int pagenum, int pagesize) {



        ArrayList<ProMeet> list =new ArrayList<ProMeet>();
        ArrayList params=new ArrayList();


        String sql="SELECT * FROM promeet WHERE 1=1";

        if(r.getHid()!=null && r.getHid()>0 ) {
            sql+="  and hid =?";
            params.add(r.getHid());
        }

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<ProMeet>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<ProMeet>(ProMeet.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    //查询总页数
    public int querynewstypecountbycond(ProMeet r){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from promeet where 1=1";

        if(r.getHid()!=null && r.getHid()>0 ) {
            sql+="  and hid =?";
            params = new Object[]{r.getHid()};
        }

        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    public int tg(ProMeet r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE promeet SET jg='ok',sptime=NOW(),spid=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getId()};

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

    public int btg(ProMeet r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE promeet SET jg='no',sptime=NOW(),spid=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getId()};

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


    //改bug新加  查询结果为空的（相当于点操作进行隐藏）
    public ArrayList<ProMeet> selectservlet1(ProMeet r, int pagenum, int pagesize) {

        ArrayList<ProMeet> list =new ArrayList<ProMeet>();
        ArrayList params=new ArrayList();


        String sql="SELECT p.*,u.loginname AS username FROM promeet p LEFT JOIN user_info u ON p.uid=u.id WHERE 1=1";

        if(r.getHid()!=null && r.getHid()>0 ){
            sql+="  and hid =?";
            params.add(r.getHid());
        }

        //通过的隐藏
        sql+=" and p.jg is null";
        sql+=" or p.jg='jqsp'";
        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<ProMeet>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<ProMeet>(ProMeet.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public int querynewstypecountbycond1(ProMeet r){

        int num =0;
        ArrayList params=new ArrayList();
       /* Object[] params = new Object[]{};*/
        String sql="SELECT COUNT(*) FROM promeet p LEFT JOIN user_info u ON p.uid=u.id WHERE 1=1";

        if(r.getHid()!=null && r.getHid()>0 ) {
            sql+="  and hid =?";
            params.add(r.getHid());
        }

        //通过的隐藏
        sql+=" and p.jg is null";
        sql+=" or p.jg='jqsp'";
        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }


    //查询当前用户数据（相当于只能看到自己的记录）
    public ArrayList<ProMeet> selectservlet2(ProMeet r, int pagenum, int pagesize) {

        ArrayList<ProMeet> list =new ArrayList<ProMeet>();
        ArrayList params=new ArrayList();


        String sql="SELECT p.*,u.loginname AS username FROM promeet p LEFT JOIN user_info u ON p.uid=u.id WHERE 1=1";

        if(r.getHid()!=null && r.getHid()>0 ){
            sql+="  and hid =?";
            params.add(r.getHid());
        }

        //判断只有当前用户显示
        sql+=" and p.uid=?";
        params.add(r.getUid());

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<ProMeet>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<ProMeet>(ProMeet.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public int querynewstypecountbycond2(ProMeet r){

        int num =0;
        ArrayList params=new ArrayList();
        /*Object[] params = new Object[]{};*/
        String sql="SELECT COUNT(*) FROM promeet p LEFT JOIN user_info u ON p.uid=u.id WHERE 1=1";

        if(r.getHid()!=null && r.getHid()>0 ) {
            sql+="  and hid =?";
            params.add(r.getHid());
        }

        //判断只有当前用户显示
        sql+=" and p.uid=?";
        params.add(r.getUid());

        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    //时间需求用
    @Override
    public List<ProMeet> cxbyuid(int uid) {
        List<ProMeet> list =new ArrayList<ProMeet>();

        String sql ="select * from promeet where uid=?";

        Object[] params = new Object[]{uid};
        try {
            list=new QueryRunner().query(DBUtil.getConn(),
                    sql,
                    new BeanListHandler<ProMeet>(ProMeet.class),params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    //机器审批
    @Override
    public int jqsp(ProMeet r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE promeet SET jg='jqsp',sptime=NOW(),spid=? WHERE id=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getId()};

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
