package com.lin.utils;

import java.sql.*;

public class DBUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/meeting?characterEncoding=utf-8";
	private static String name = "root";
	private static String pwd = "123456";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ����Ӷ���
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, name, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * �رն���
	 * 
	 * @param conn
	 *            ���Ӷ���
	 * @param pstmt
	 *            ������
	 */
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �رն���
	 * @param conn ���Ӷ���
	 * @param pstmt ������
	 * @param rs �����
	 */
	public static void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(conn,pstmt);
	}





}
