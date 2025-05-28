package kr.or.ddit.case05.objs;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("service")
@RequiredArgsConstructor
public class Case05Service {
	private final Case05DAO dao;
	
	@PostConstruct
	public void start() {
		log.info("주입된 dao : {}", dao.getClass().getSimpleName());
	}
}
