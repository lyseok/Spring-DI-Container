package kr.or.ddit.case11.objs.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.annotation.Resource;
import kr.or.ddit.case11.conf.Case11MybatisSpringConfig;
import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case11MybatisSpringConfig.class)
class LprodServiceImplTest {
	
	@Resource(name = "lprodServiceImpl")
	LprodServiceImpl service;
	
	@Test
	@Disabled
	void testReadLprodList() {
//		log.info("주입된 객체 {} ", service);
//		List<LprodVO> lprodList = service.readLprodList();
//		lprodList.forEach(lvo -> log.info("{}", lvo));
		assertDoesNotThrow(() -> service.readLprodList());
	}

	@Test
	void testReadLprod() {
//		LprodVO lvo = service.readLprod("P101").get();
//		log.info("{}", lvo);
		assertDoesNotThrow(() -> {
			LprodVO lprod = service.readLprod("P501").get();
			log.info("{} 상품갯수 : {}", lprod.getLprodGu(), lprod.getProdList().size());
			if(!lprod.getProdList().isEmpty()) {
				log.info("첫번째 상품 : {}", lprod.getProdList().get(0));				
			}
		});
	}

}
