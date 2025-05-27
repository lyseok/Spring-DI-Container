package kr.or.ddit.case02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case02.conf.Case02DependencyInjectionConfig;
import kr.or.ddit.case02.objs.dao.Case02DAO;
import kr.or.ddit.case02.objs.service.Case02Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case02Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Case02DependencyInjectionConfig.class);
		
		context.registerShutdownHook();
		
		Case02DAO dao = context.getBean(Case02DAO.class);
		Case02Service service = context.getBean(Case02Service.class);
		
		log.info("dao : {} ", dao);
		log.info("service : {} ", service);
	}
}
