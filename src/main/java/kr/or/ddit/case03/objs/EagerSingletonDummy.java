package kr.or.ddit.case03.objs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerSingletonDummy {

	public EagerSingletonDummy() {
		log.info("{} 객체 기본 생성자로 생성", this.getClass().getSimpleName());
	}

}
