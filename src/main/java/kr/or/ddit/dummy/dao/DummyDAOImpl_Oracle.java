package kr.or.ddit.dummy.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class DummyDAOImpl_Oracle implements DummyDAO{

	@Override
	public Map<String, Object> selectDummy(String pk) {
		return Map.of("key1", "돼지고기", "key2", "김치", "key3", "Oracle");
	}

}
