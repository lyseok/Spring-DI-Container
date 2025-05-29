package kr.or.ddit.mission;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.mission.conf.MissionConfig;
import kr.or.ddit.mission.objs.HuntingGround;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MissionPlayground {
	public static void main(String[] args) {
//		HuntingGround를 주입받고 로그로 출력
//		(몇명의 사냥꾼이 어떤 총을 가지고 있는지..)
		
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(MissionConfig.class);
		context.registerShutdownHook();
		HuntingGround ground = context.getBean(HuntingGround.class);
		log.info("주입된 객체 : {}",ground);
		
	}
}
