package kr.or.ddit.case08;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case08.conf.Case08ExpressionLanguageConfig;

public class Case08Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Case08ExpressionLanguageConfig.class);
		
	}
}
