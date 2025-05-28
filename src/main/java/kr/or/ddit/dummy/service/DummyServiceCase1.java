package kr.or.ddit.dummy.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import kr.or.ddit.dummy.dao.DummyDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DummyServiceCase1 {
	// 1. 필요 객체(의존객체)를 new 키워드로 직접 생성. 결합력 최상(전형적인 망한코드)
//	private DummyDAO dao = new DummyDAOImpl_Oracle();
	// 2. Factory Object 적용: factory객체와의 의존관계에 따른 결합력 잔존
//	private DummyDAO dao = DummyDAOFactory.getDummyDAO();
	// 3. Strategy Pattern 적용 : 전략의 주입자(모든 결합력을 떠안게됨) 필요 
	private DummyDAO dao; 
	
	@Resource(name = "mariadb")
	public void setDao(DummyDAO dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	public void init() {
		log.info("주입된 dao: {}", dao);
	}

	public StringBuffer readDummy(String pk) {
		Map<String, Object> rawData = dao.selectDummy(pk);
		StringBuffer infomation = new StringBuffer();
		
		for(Entry<String, Object> entry : rawData.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			infomation.append(
						String.format("%s - %s\n", key, value)
					);
		}
		infomation.append("이재료들을 지지고 볶아서 김치찌개를 만듦");
		
		return infomation;
	}
}
