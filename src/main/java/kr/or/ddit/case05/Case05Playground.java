package kr.or.ddit.case05;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case05Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
//				new ClassPathXmlApplicationContext("kr/or/ddit/case05/conf/Case05-Context.xml");
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case05/conf/Case05-Context.xml");
		context.registerShutdownHook();
//		log.info("등록된 빈의 갯수 : {}", context.getBeanDefinitionCount());
//		String[] names = context.getBeanDefinitionNames();
//		for(String name : names) {
//			Object bean = context.getBean(name);
//			log.info("{} : {}", name, bean);
//		}
	}
}
