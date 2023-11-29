package com.test.java.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //이렇게 두개 적으면 root-context 파일 읽어올 수 있음. 아래에서 사용 가능
public class HikariCPTest {
	
	@Autowired
	private HikariDataSource dataSource;
	
	@Test
	public void testConnectionPool() {
		
		//우리가 직접 Connection을 생성하지 않고 
		//Connection Pool을 통해 Connection이 잘 생성되는지 테스트
		
		assertNotNull(dataSource); // dataSource가 생성되었나?

		try {
			
			Connection conn = dataSource.getConnection();
			assertEquals(false, conn.isClosed()); //conn이 열렸나?
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
