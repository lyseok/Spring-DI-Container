package kr.or.ddit.case08.conf;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import kr.or.ddit.case08.objs.OthersVO;
import kr.or.ddit.case08.objs.SimpleVO;
import lombok.extern.slf4j.Slf4j;

@ComponentScan(basePackages = "kr.or.ddit.case08.objs")
@Slf4j
public class Case08MapInjectTestConfig {
	@Bean
	public StringBuffer dummy2(
		Map<String, Object> beanFactory	
		, @Value("${username}") String username
	) {
		log.info("==> username : {}", username);
		log.info("bean facroty size : {}", beanFactory.size());
		beanFactory.forEach((k, v) -> {
			log.info("{} - {}", k, v);			
		});
		return null;
	}
//	
//	@Bean
//	public Map<String, Object> map () {
//		return Map.of("k1",34, "k2","value");
//	}
//	
//	
//	@Bean
//	public SimpleVO dummy(
//		Map<String, Object> map
//		, @Value("TEXT") String str
//	) {
//		map.forEach((k, v) -> {
//			log.info("{} - {}", k, v);			
//		});
//		return new SimpleVO(map, str);
//	}
//	
//	@Bean
//	public OthersVO others(
//		@Value("#{dummy.str}") String str	
//	) {
//		return new OthersVO(str);
//	}
}
