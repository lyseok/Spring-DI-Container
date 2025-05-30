package kr.or.ddit.case09.conf;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.annotation.Resource;
import kr.or.ddit.case09.objs.DBInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case09ReadPropertiesConfig.class)
class Case09ReadPropertiesConfigTest {
	@Resource(name = "dbInfo1")
	DBInfoVO dbInfo1;
	@Resource(name = "dbInfo2")
	DBInfoVO dbInfo2;
	
	@Test
	@Disabled
	void test() {
		log.info("주입된 VO : {}", dbInfo1);
	}
	
	@Test
	void test2() {
		log.info("주입된 VO : {}", dbInfo2);
	}
	
	@Autowired
	String[] array;
	
	@Test
	void test3() {
		log.info("주입된 array : {}", Arrays.toString(array));
	}

}
