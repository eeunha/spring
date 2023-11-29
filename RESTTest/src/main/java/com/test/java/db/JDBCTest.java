package com.test.java.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	
	@Test //pom.xml에 test scope 제거해야 실행된다...
	public void testConnection() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "java1234");
			
			//true면 성공
			assertNotNull(conn);
			
			//뒤의 두 값이 같은지 검증
			assertEquals("DB 연결", false, conn.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
