package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.conf.Case03ContainerBeanManagementPolicyConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case03Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03ContainerBeanManagementPolicyConfig.class);
		context.registerShutdownHook();
//		StringBuffer sb1 = context.getBean("sb1", StringBuffer.class);
//		StringBuffer sb2 = context.getBean("sb2", StringBuffer.class);
//		log.info("sb1 == sb2 : {} ", sb1 == sb2);
//		
//		log.info("--------------------");
//		EagerDummy ed = context.getBean(EagerDummy.class);

//		EagerSingletonDummy esd = context.getBean(EagerSingletonDummy.class);

//		LazyDummy ld = context.getBean(LazyDummy.class);
//		LazyDummy ld1 = context.getBean(LazyDummy.class);

//		LazyPrototypeDummy lpd = context.getBean(LazyPrototypeDummy.class);
//		LazyPrototypeDummy lpd1 = context.getBean(LazyPrototypeDummy.class);

		
	}
	
}