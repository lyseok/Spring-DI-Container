package kr.or.ddit.case02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.case02.objs.dao.Case02DAO;
import kr.or.ddit.case02.objs.service.Case02Service;

@Configuration
public class Case02DependencyInjectionConfig {
	
	@Bean
	public StringBuffer optionBuffer() {
		return new StringBuffer();
	}
	
	@Bean
	public Case02DAO dao1() {
		return new Case02DAO();
	}
	
//	@Bean
//	public Case02DAO dao2() {
//		return new Case02DAO();
//	}
	
	@Bean 
	public Case02Service srvice(Case02DAO dao1, StringBuffer optionBuffer) {
		Case02Service service = new Case02Service(dao1);
		service.setOption(optionBuffer);
		return service;
	}
}
