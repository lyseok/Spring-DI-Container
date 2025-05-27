package kr.or.ddit.case03.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case03.objs.EagerDummy;
import kr.or.ddit.case03.objs.EagerSingletonDummy;
import kr.or.ddit.case03.objs.LazyDummy;
import kr.or.ddit.case03.objs.LazyPrototypeDummy;
import lombok.extern.slf4j.Slf4j;

/**
 * 스프링 컨테이너의 빈 관리 특성
 * 1. 싱글턴 scope를 기본으로 사용함
 * 	* Design patter (singleton) : 어플리케이션 실행 중 힙 메모리 상에 특정 클래스의 인스턴스가 하나만 로딩되는 구조
 * 		: 싱글턴 스코프의 대상을 등록된 빈을 기준으로 측정함
 * 		@Scope 어노테이션으로 기본 설정을 변경할 수 있음
 * 			singleton(기본설정) : 미리 객체를 생성하고, 주입할때마다 동일한 객체가 주입됨.
 * 			prototype :객체 생성을 뒤로 미루고, 주입직전에 생성하며, 주입할때마다 새로운 객체가 생성됨 
 * 			request : 요청 객체와 동일 생명주기를 갖는 빈
 * 			session : 세션 객체와 동일 생명주기를 갖는 빈
 *			application : servletContext와 동일한 생명주기를 갖는 빈.
 * 2. 구체적인 설정이 없으면, eager-loading 방식으로 객체를 미리 생성함
 */
@Slf4j
@Lazy
public class Case03ContainerBeanManagementPolicyConfig {
//	@Bean
//	@Lazy
//	@Scope()
//	public StringBuffer sb1() {
//		log.info("sb1 팩토리 메소드 실행 : {}");
//		return new StringBuffer();
//	}
//	@Bean
//	public StringBuffer sb2() {
//		log.info("sb2 팩토리 메소드 실행 : {}");
//		return new StringBuffer();
//	}
	
	@Bean(initMethod = "start", destroyMethod = "expire")
//	@Scope("prototype")
	@Lazy(false)
	public EagerDummy eagerDummy(EagerSingletonDummy esd) {
		EagerDummy ed = new EagerDummy();
		ed.setEsd(esd);
		return ed;
	}
	
	@Bean
	@Lazy(false)
	@Scope("singleton")
	public EagerSingletonDummy eagerSingletonDummy() {
		return new  EagerSingletonDummy();
	}
	
	@Bean
	@Lazy
	public LazyDummy lazyDummy() {
		return new LazyDummy();
	}
	
	@Bean
	@Scope("prototype")
	public LazyPrototypeDummy lazyPrototypeDummy() {
		return new LazyPrototypeDummy();
	}
}
