package kr.or.ddit.dummy.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.dummy.dao.DummyDAOImpl_MariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImpl_Oracle;
import kr.or.ddit.dummy.service.DummyServiceCase1;

@Configuration
public class DummyContextConfig {
	@Bean
	public DummyDAOImpl_Oracle dao() {
		return new DummyDAOImpl_Oracle();
	}
	
	@Bean
	public DummyDAOImpl_MariaDB daoMariaDB() {
		return new DummyDAOImpl_MariaDB();
	}
	
	@Bean
	public DummyServiceCase1 service() {
		DummyServiceCase1 service = new DummyServiceCase1();
		service.setDao(daoMariaDB());
		return service;
	}
}
