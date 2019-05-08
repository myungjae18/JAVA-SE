/*
 * �����ͺ��̽� ���Ӱ� ���õ� �ߺ��� ������ �� Ŭ������ �����Ͽ�
 * */
package com.javaclient.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="adams";
	String password="1234";
	
	//���� ��ü�� ��ȯ�ϴ� �޼���
	public Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public void disconnect(Connection con) {//���� Ŀ�ؼ� ����
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}