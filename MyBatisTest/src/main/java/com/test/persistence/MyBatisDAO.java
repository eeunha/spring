package com.test.persistence;

import java.util.HashMap;
import java.util.List;

import com.test.domain.MyBatisDTO;

public interface MyBatisDAO {
	
	void test();

	int add(MyBatisDTO dto);

	void m1();

	int m2(String seq);

	int m3(MyBatisDTO dto);

	int m4(HashMap<String, String> map);

	int m5();

	MyBatisDTO m6(String seq);

	List<String> m7();

	List<MyBatisDTO> m8();

	int m9(String table);

	int m10();

	List<MyBatisDTO> m11(String word);

	List<String> m12(String type);

	List<MyBatisDTO> m13(HashMap<String, String> map);
	
}
