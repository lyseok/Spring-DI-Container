package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.conf.Case03ContainerBeanManagementPolicyConfig;

public class EagetLazyTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03ContainerBeanManagementPolicyConfig.class);
		context.registerShutdownHook();
	}
}
