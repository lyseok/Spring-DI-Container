package kr.or.ddit.case04.objs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Scope("prototype")
public class Case04DummyController {
	// 부가적인 의존 객체 : service
	// 주입 여부에 따라 주입된 객체를 로그로 출력
	private Case04DummyService service;
	
	public Case04DummyController() {
		log.info("{} 객체 기본 생성자 실행. ", this.getClass().getSimpleName());
	}

	
//	@Autowired
//	@Qualifier("service1")
//	@Inject
//	@Named("service1")
	@Resource(name = "service1")
	public void setService(Case04DummyService service) {
		this.service = service;
		log.info("setter injection");
	}
	
	@PostConstruct
	public void start() {
		log.info("controller에 주입된 service 객체 : {}", service);		
	}
	
	@PreDestroy
	public void didi() {
		log.info("{} 객체 소멸", this.getClass().getSimpleName());
	}
	
}
