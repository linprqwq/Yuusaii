package com.lin.dao.impl;

import com.lin.dao.QjDao;
import com.lin.pojo.Qj;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QjDaoImpl implements QjDao {

    public int add(Qj r) {
        int num = 0;
        //1.写sql
        String sql = "insert into qj values(null,?,?,?,?,?,?,?)";
        //2.参数
        Object[] params = new Object[]{r.getLy(),r.getUid(),r.getBtime(),r.getStime(),r.getJg(),r.getSptime(),r.getSpid()};

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

    public ArrayList<Qj> selectservlet(Qj r, int pagenum, int pagesize) {

        ArrayList<Qj> list =new ArrayList<Qj>();
        ArrayList params=new ArrayList();


        String sql="SELECT q.*,u.zid FROM qj q INNER JOIN user_info u ON q.uid=u.id WHERE 1=1";

        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
        }

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<Qj>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<Qj>(Qj.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public int querynewstypecountbycond(Qj r){

        int num =0;
        Object[] params = new Object[]{};
        String sql="select count(*) as totalrecord from qj where 1=1";

        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params = new Object[]{r.getUid()};
        }

        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    public int tg(Qj r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE qj SET jg='ok',sptime=NOW(),spid=? WHERE qid=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getQid()};

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

    public int btg(Qj r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE qj SET jg='no',sptime=NOW(),spid=? WHERE qid=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getQid()};

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

    public int jlsp(Qj r) {
        int num = 0;
        //1.写sql
        String sql = "UPDATE qj SET jg='jlsp',sptime=NOW(),spid=? WHERE qid=?";
        //2.参数
        Object[] params = new Object[]{r.getSpid(),r.getQid()};

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


    //查询当前用户数据（相当于只能看到自己的记录）
    @Override
    public List<Qj> selectservlet1(Qj r, int pagenum, int pagesize) {
        ArrayList<Qj> list =new ArrayList<Qj>();
        ArrayList params=new ArrayList();


        String sql="SELECT q.*,u.zid,u.loginname FROM qj q LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";

      /*  if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
        }*/

        //判断只有当前用户显示
        sql+=" and q.uid=?";
        params.add(r.getUid());

        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<Qj>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<Qj>(Qj.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int querynewstypecountbycond1(Qj r) {
        int num =0;
        ArrayList params=new ArrayList();
        /*Object[] params = new Object[]{};*/
        String sql="select count(*) as totalrecord from qj q LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";

       /* if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params = new Object[]{r.getUid()};
        }*/

        //判断只有当前用户显示
        sql+=" and q.uid=?";
        params.add(r.getUid());


        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }


    //改bug新加  查询结果为空的（相当于点操作进行隐藏）
    @Override
    public List<Qj> selectservlet2(Qj r, int pagenum, int pagesize) {
        ArrayList<Qj> list =new ArrayList<Qj>();
        ArrayList params=new ArrayList();


        String sql="SELECT q.*,u.zid,u.loginname FROM qj q LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";

        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
        }


        //判断只有下级显示
        sql+=" and u.zid>?";
        params.add(r.getZid());
        //通过的隐藏
        sql+=" or q.jg is null";
        sql+=" or q.jg='jlsp'";
        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<Qj>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<Qj>(Qj.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int querynewstypecountbycond2(Qj r) {
        int num =0;
        ArrayList params=new ArrayList();
       /* Object[] params = new Object[]{};*/
        String sql="select count(*) as totalrecord from qj q LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";

        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
        }

        //判断只有下级显示
        sql+=" and u.zid>?";
        params.add(r.getZid());

        //通过的隐藏(查询有的)
        sql+=" or q.jg is null";
        sql+=" or q.jg='jlsp'";
        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    //看到下级审批记录
    @Override
    public List<Qj> selectservlet3(Qj r, int pagenum, int pagesize) {
        ArrayList<Qj> list =new ArrayList<Qj>();
        ArrayList params=new ArrayList();


        String sql="SELECT q.*,u.zid,u.loginname FROM qj q" +
                " LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";

        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
        }

        //判断只有下级显示
        sql+=" and u.zid>?";
        params.add(r.getZid());
        //分页功能
        sql+=" LIMIT  ?,?";
        params.add((pagenum-1)*pagesize);
        params.add(pagesize);


        QueryRunner queryRunner = new QueryRunner();
        try {
            list = (ArrayList<Qj>) queryRunner.query(DBUtil.getConn(),sql,new BeanListHandler<Qj>(Qj.class),params.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int querynewstypecountbycond3(Qj r) {
        int num =0;
        /*Object[] params = new Object[]{};*/
        ArrayList params=new ArrayList();
        String sql="select count(*)  from qj q LEFT JOIN user_info u ON q.uid=u.id WHERE 1=1";


        if(r.getUid()!=null && r.getUid()>0 ) {
            sql+="  and uid =?";
            params.add(r.getUid());
            /*params = new Object[]{r.getUid()};*/
        }

        //判断只有下级显示
        sql+=" and u.zid>?";
        params.add(r.getZid());


        QueryRunner queryRunner = new QueryRunner();
        try {
            num =queryRunner.query(DBUtil.getConn(),sql,new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

}
