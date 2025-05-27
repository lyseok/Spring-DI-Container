package kr.or.ddit.case01.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.case01.objs.Bar;
import kr.or.ddit.case01.objs.Baz;
import kr.or.ddit.case01.objs.Foo;

/**
 *  Spring DI Container(Bean Container) 사용 단계
 *  Bean : 컨테이너 내부에서 관리되는 객체
 *  1. 사용할 객체에 대한 모델링 작업
 *  	- 의존성 주입 방법에 대한 설계 필수
 *  		- constructor injection (필수 의존 객체에 대해 주로 사용)
 *    		- setter injection
 *  2. Core Container 를 사용할 수 있는 메이븐 의존성 추가.(pom.xml)
 *  3. 컨테이너의 설정 파일 역할을 하는 config 클래스 정의
 *  	- factory 메소드 정의 : 객체를 생성하고 반환하는 메소드
 *  	- @Bean("beanName") 어노테이션으로 빈을 등록.
 *  	  bean name을 생략한 경우, 메소드명이 이름으로 반영됨.
 *  4. 어플리케이션의 엔트리포인트에서 컨테이너 객체를 생성함.
 *  	- ApplicationContext(ConfigurableApplicationContext)의 구현체 선택
 *  5. 필요객체를 컨테이너로부터 주입. : getBean(빈 검색조건 - class, String)
 */
@Configuration
public class Case01BeanRegistConfig {
	@Bean
	public Bar barSpecific() {
		return new Bar();
	}
	@Bean("bazSpecific")
	public Baz baz() {
		return new Baz();
	}
	
	@Bean
	public Foo foo() {
		Foo foo = new Foo(barSpecific());
		foo.setBaz(baz());
		return foo;	
	}
	
	@Bean
	public Foo fooAuther() {
		Foo foo = new Foo(barSpecific());
		foo.setBaz(baz());
		return foo;	
	}
}
