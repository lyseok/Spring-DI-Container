package kr.or.ddit.case01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case01.conf.Case01BeanRegistConfig;
import kr.or.ddit.case01.objs.Bar;
import kr.or.ddit.case01.objs.Baz;
import kr.or.ddit.case01.objs.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case01Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Case01BeanRegistConfig.class);
		Bar bar1 = context.getBean(Bar.class);
		Bar bar2 = context.getBean(Bar.class);
		Baz baz1 = context.getBean(Baz.class);
		Baz baz2 = context.getBean(Baz.class);
		log.info("bar1 : {}", bar1);
		log.info("bar2 : {}", bar2);
		log.info("baz1 : {}", baz1);
		log.info("baz2 : {}", baz2);
		int count = context.getBeanDefinitionCount();
		log.info("count : {}", count);
		String[] names = context.getBeanDefinitionNames();
		for(String name : names) {
			log.info("bean name : {}", name);
		}
		
		Foo foo = context.getBean("foo", Foo.class);
		log.info("foo : {}", foo);
	}
}
