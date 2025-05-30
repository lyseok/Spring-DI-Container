package kr.or.ddit.case08.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case08MapInjectTestConfig.class)
class Case08MapInjectTestConfigTest {
	@Autowired
	ConfigurableApplicationContext context;
	
	@Test
	void test() {
		log.info("컨테이너에 등록된 빈의 갯수 : {}",context.getBeanDefinitionCount());
	}

}
