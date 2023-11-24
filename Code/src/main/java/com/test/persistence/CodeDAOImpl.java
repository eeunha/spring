package com.test.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.CodeDTO;

@Repository
public class CodeDAOImpl implements CodeDAO {

	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int add(CodeDTO dto) {

		return this.template.insert("code.add", dto);
	}

	@Override
	public List<CodeDTO> list(List<String> language) {

		return this.template.selectList("code.list", language);
	}

	@Override
	public CodeDTO get(String seq) {

		return this.template.selectOne("code.get", seq);
	}
}
