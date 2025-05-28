package kr.or.ddit.case04.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
 
/**
 * 어플리케이션의 볼륨이 커지면, 특정 패지에 있는 일정 조건에 맞는 클래스를 자동으로 빈 등록할 수 있는 방법이 필요함.
 */
@Configuration // marker 어노테이션 
// 1. 현재 클래스 객체를 알아서 생성
// 2. 그 객체들을 
//@Lazy
@ComponentScan(basePackages = "kr.or.ddit.case04.objs", lazyInit = false,
		useDefaultFilters = false,
//		includeFilters = {
//				@Filter(type = FilterType.ANNOTATION, classes = Component.class)
//		},
		includeFilters = {
				@Filter(type = FilterType.ANNOTATION, classes = Controller.class)
		}
	)
public class Case04ComponentScanConfig {
	// 필요한 모든 객체를 빈으로 등록.
	// 의존성 주입을 통해 빈들간의 의존관계 형성.

//	@Bean
//	public Case04DummyMapper case04DummyMapper() {
//		return new Case04DummyMapperImpl_Oracle();
//	}
//	
//	@Bean(initMethod = "start")
//	public Case04DummyService case04DummyService(Case04DummyMapper mapper) {
//		return new Case04DummyServiceImpl(mapper);
//	}
//	
//	@Bean(initMethod = "start")
//	public Case04DummyController case04DummyController(Case04DummyService service) {
//		Case04DummyController controller = new Case04DummyController();
//		controller.setService(service);
//		return controller;
//	}
	
}
