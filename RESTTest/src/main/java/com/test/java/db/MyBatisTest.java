package com.test.java.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	@Autowired
	private SqlSessionTemplate template;

	@Test
	public void testQuery() {

		int count = template.selectOne("rest.test");

		// template이 생성되었는가?
		assertNotNull(template);

		// 기대치와 query 결과값이 같은가?
		assertEquals(12, count);

	}

	@Test // pom.xml에 test scope 제거해야 실행된다...
	public void testConnection() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "java1234");

			// true면 성공
			assertNotNull(conn);

			// 뒤의 두 값이 같은지 검증
			assertEquals("DB 연결", false, conn.isClosed());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private HikariDataSource dataSource;

	@Test
	public void testConnectionPool() {

		// 우리가 직접 Connection을 생성하지 않고
		// Connection Pool을 통해 Connection이 잘 생성되는지 테스트

		assertNotNull(dataSource); // dataSource가 생성되었나?

		try {

			Connection conn = dataSource.getConnection();
			assertEquals(false, conn.isClosed()); // conn이 열렸나?

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
