package kr.or.ddit.case08;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case08.conf.Case08ExpressionLanguageConfig;
import kr.or.ddit.case08.objs.DestVO;
import kr.or.ddit.case08.objs.OriginalVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(Case08ExpressionLanguageConfig.class)
class Case08PlaygroundTest {
	@Autowired
	OriginalVO original;
	
	@Autowired
	DestVO dest;
	
	@Test
	@Disabled
	void test() {
		log.info("주입된 객체 : {}", original);
	}
	
	@Test
	void testDest() {
		log.info("복사된 객체 : {}", dest);
	}

}