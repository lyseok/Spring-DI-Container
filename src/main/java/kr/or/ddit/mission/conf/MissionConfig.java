package kr.or.ddit.mission.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import kr.or.ddit.mission.objs.Cabin;
import kr.or.ddit.mission.objs.Hunter;
import kr.or.ddit.mission.objs.HuntingDog;
import kr.or.ddit.mission.objs.HuntingGround;
import kr.or.ddit.mission.objs.ShotGun;
import lombok.extern.slf4j.Slf4j;

/**
 * 사냥 게임 모델링
 * 1. Hunter
 * 2. HuntingGround : 사냥터에는 여러명의 사냥꾼이 존재할 수 있음
 * 3. Gun : 사냥꾼은 각자 자기 총을 소유
 *   a. ShotGun
 *   b. Riffle(default)
 * 4. HuntingDog : 한마리의 사냥개를 여러 사냥꾼이 공유함
 * 5. Cabbin : 하나의 오두막을 공유함  
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "kr.or.ddit.mission.objs")
public class MissionConfig {
	@Autowired
	private ConfigurableApplicationContext context;
	
	@Bean
	public List<Hunter> hunters() {
		return new ArrayList<Hunter>();
	}
	@Bean
	public HuntingGround ground(
			Cabin cabin
			, HuntingDog dog
			) {
		return new HuntingGround(cabin, dog, hunters());
	}
	
	@PostConstruct
	public void init() {
		log.info("================ INIT ================");
		HuntingGround ground = context.getBean(HuntingGround.class);
		log.info("ground : {}", ground);
		Hunter hunter1 = context.getBean(Hunter.class);
		ground.enter(hunter1);
		Hunter hunter2 = context.getBean(Hunter.class);
		ShotGun shotGun = context.getBean(ShotGun.class);
		ground.enter(hunter2);
		hunter2.changeGun(shotGun);
		
	}
}
