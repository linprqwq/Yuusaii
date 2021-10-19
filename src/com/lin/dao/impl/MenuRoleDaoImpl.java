package com.lin.dao.impl;

import com.lin.dao.MenuRoleDao;
import com.lin.pojo.MenuRoleInfo;
import com.lin.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuRoleDaoImpl implements MenuRoleDao {
    @Override
    public int delmrbyrid(int rid) {
        int num =0;
        String sql ="delete  from rolemenu_info where rid =?";
        Object[] params = new Object[]{rid};
        try {
            num =new QueryRunner().update(DBUtil.getConn(),
                    sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return num;
    }

    @Override
    public List<MenuRoleInfo> querymenurolebyrid(int rid) {

        List<MenuRoleInfo> list = new ArrayList<MenuRoleInfo>();

        String sql ="select * from rolemenu_info where rid=?";
        Object[] params = new Object[]{rid};
        try {
            list= new QueryRunner().query(DBUtil.getConn(),
                    sql,new BeanListHandler<MenuRoleInfo>(MenuRoleInfo.class),
                    params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }

    @Override
    public boolean addauthc(List<MenuRoleInfo> list) {
        boolean result =false;
        String sql ="insert into rolemenu_info(rid,mid) values(?,?)";

        Connection connection =null;
        PreparedStatement pstmt =null;

        try{
            connection = DBUtil.getConn();

            connection.setAutoCommit(false);

            pstmt = connection.prepareStatement(sql);

            for (MenuRoleInfo menuRoleInfo : list) {
                pstmt.setInt(1,menuRoleInfo.getRid());
                pstmt.setInt(2,menuRoleInfo.getMid());
                pstmt.addBatch();
            }
            pstmt.executeBatch();

            connection.commit();
            result=true;

        }catch (Exception e){
            result=false;
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,pstmt);
        }
        return result;
    }

}
