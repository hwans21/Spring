package com.spring.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnectionTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "spring";
	private String upw = "spring";
	
	//DB 연결 테스트
	@Test
	public void connectTest() {
		Connection conn = null;
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,uid,upw);
			System.out.println("DB 커넥션 성공!");
			System.out.println("conn: "+conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
