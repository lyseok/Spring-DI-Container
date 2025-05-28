package kr.or.ddit.case04;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case04.objs.controller.Case04DummyController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case04Playground {
	public static void main(String[] args) throws BeansException {
		// 컨테이너 객체 생성
		// 등록된모든 빈을 주입받고 로그로 출력
		
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext("kr.or.ddit.case04.conf");
		context.registerShutdownHook();
		
//		Case04DummyMapper mapper = context.getBean(Case04DummyMapper.class);
		
//		Case04DummyService service = context.getBean(Case04DummyService.class);
		
		Case04DummyController controller = context.getBean(Case04DummyController.class);
		
//		Case04DummyController controller = context.getBean(Case04DummyController.class);
//		log.info("controller 객체 : {}", controller);
	}
}
