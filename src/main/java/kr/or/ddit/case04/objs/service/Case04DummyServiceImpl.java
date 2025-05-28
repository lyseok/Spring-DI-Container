package kr.or.ddit.case04.objs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import kr.or.ddit.case04.objs.mapper.Case04DummyMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("service1")
public class Case04DummyServiceImpl implements Case04DummyService {
	// 필수 의존 객체 : mapper
	// 해당 의존 객체의 주입이 완료된 이후, 주입된 객체를 로그로 출력
	private final Case04DummyMapper daoOracle;
	
	
	@Autowired
	public Case04DummyServiceImpl(Case04DummyMapper daoOracle) {
		super();
		this.daoOracle = daoOracle;
		log.info("{} 객체 생성 및 생성자 주입, {} ", this.getClass().getSimpleName(), daoOracle);
	}
	
	@PostConstruct
	public void start() {
		log.info("service 에 주입된 mapper 객체 : {}", daoOracle.getClass().getSimpleName());		
	}
	
}
