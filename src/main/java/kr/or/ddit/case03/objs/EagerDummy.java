package kr.or.ddit.case03.objs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerDummy {
	private EagerSingletonDummy esd;

	public void setEsd(EagerSingletonDummy esd) {
		this.esd = esd;
		log.info("setter injection 실행");
	}
	
	public EagerDummy() {
		log.info("{} 객체 기본 생성자로 생성", this.getClass().getSimpleName());
	}
	public void start() {
		log.info("start 메소드 실행, 주입된 객체 주소 : {}", esd.hashCode());
	}
	
	public void expire() {
		log.info("expire 메소드 실행");
	}
}
