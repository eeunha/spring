package com.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {

//	@Autowired
//	private SqlSessionTemplate template;

	@Autowired
	private TestMapper mapper; //구현 클래스가 없는데 왜 작동하지? -> 이를 상속받아 구현하는 클래스를 스프링이 알아서 내부적으로 만든다.

	@Test
	public void testMapper() {
		assertNotNull(mapper); //인스턴스 생성됨
		
		System.out.println(mapper.getTime());
		System.out.println(mapper.getTime2());
	}

}
