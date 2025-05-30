package kr.or.ddit.case11.objs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LprodServiceImpl {
	@Autowired
	LprodMapper mapper;
	
	public List<LprodVO> readLprodList(){
		log.info("mapper : {}", mapper);
		return mapper.selectLprodList();
	}
	
	public Optional<LprodVO> readLprod(String lprodGu) {
		return Optional.ofNullable(mapper.selectLprod(lprodGu));
	}
}