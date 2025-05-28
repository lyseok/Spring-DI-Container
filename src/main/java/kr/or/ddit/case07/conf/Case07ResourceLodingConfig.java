package kr.or.ddit.case07.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case07.objs.ResourcesVO;

@Configuration
public class Case07ResourceLodingConfig {
	
	@Bean
	public ResourcesVO resVO(
			@Value("file:/Users/eehdbs/Desktop/스크린샷 2025-05-25 21.29.21.png") Resource fR
			, @Value("classpath:kr/or/ddit/case05/conf/Case05-Context.xml") Resource cR
			, @Value("https://commons.apache.org/proper/commons-io/dependency-info.html") Resource wR
			, @Value("strTest") String str
			, @Value("123") int number 
		) {
		ResourcesVO resVO = new ResourcesVO(fR, str, number);
		resVO.setCR(cR);
		resVO.setWR(wR);
		return resVO;
	}
}
