package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;


//1. Junit
//2. log4j

@Log4j
public class JDBCTest {
	
	@Test //main()가 없어도 실행시킨다.
	public void testConnection() {
		
		//JDBC 연결 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "java1234");
			
			assertNotNull(conn); //Junit기능. conn이 null인지 확인하겠다. not null -> 합격
			
//			System.out.println(conn.isClosed()); //log -> @Log4j
			
			log.info(conn.isClosed());
//			log.warn("경고 메시지");
//			log.error("에러 메시지");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
