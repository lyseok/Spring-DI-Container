package kr.or.ddit.case02.objs.service;

import kr.or.ddit.case02.objs.dao.Case02DAO;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class Case02Service {
	private final Case02DAO dao;
	
	private StringBuffer option;
	
	
	
}
