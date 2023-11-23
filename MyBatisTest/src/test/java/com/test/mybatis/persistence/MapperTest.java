package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testQuery() {

		assertNotNull(sqlSessionFactory);

		//SqlSessionTemplate > SQL 실행(Statement 역할)
		SqlSession session = sqlSessionFactory.openSession();

		//session.executeQuery("select");
		
		String time = session.selectOne("test.time"); //xml 파일에서 name이 test이고 id가 time인 쿼리 실행
		log.info(time);
	}
}
