package kr.or.ddit.case03.objs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerObj {
	public EagerObj() {
		log.info("contructor 메소드 실행");
	}

	public void init() {
		log.info("init 메서드 실행");
	}
	
	public void destroy() {
		log.info("destroy 메서드 실행");
	}
}
