package kr.or.ddit.dummy.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("mariadb")
public class DummyDAOImpl_MariaDB implements DummyDAO{

	@Override
	public Map<String, Object> selectDummy(String pk) {
		return Map.of("key1", "돼지고기", "key2", "김치", "key3", "MariaDB");
	}

}
