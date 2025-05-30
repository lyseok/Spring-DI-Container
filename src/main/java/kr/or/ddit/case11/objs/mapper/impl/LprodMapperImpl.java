package kr.or.ddit.case11.objs.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Repository
public class LprodMapperImpl implements LprodMapper {
//	private final SqlSessionFactory sessionFactory;
	private final SqlSession session;
	
	@Override
	public List<LprodVO> selectLprodList() {
//		try (
//			SqlSession session = sessionFactory.openSession();
//		){
//			LprodMapper proxy = session.getMapper(LprodMapper.class);
//			return proxy.selectLprodList();
//		}

		LprodMapper proxy = session.getMapper(LprodMapper.class);
		return proxy.selectLprodList();
		
	}

	@Override
	public LprodVO selectLprod(String lprodGu) {
		// TODO Auto-generated method stub
		return null;
	}

}
