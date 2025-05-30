package kr.or.ddit.case10.conf;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.vo.MbtiVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case10jdbcConfig.class)
class Case10jdbcConfigTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	@Test
	void testInsert() {
		MbtiVO newMBTI = new MbtiVO();
		newMBTI.setMtType("1111");
		newMBTI.setMtTitle("2222");
		newMBTI.setMtContent("concon");
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO TB_MBTIDESC (   ");
		sql.append("	MT_TYPE     ");
		sql.append("	, MT_TITLE  ");
		sql.append("	, MT_CONTENT ");
		sql.append(") VALUES (      ");
		sql.append("	:mtType, :mtTitle, :mtContent       ");
		sql.append(")               ");
//		int res = jdbcTemplate.update(sql.toString(), newMBTI);
		int res = npjt.update(sql.toString(), new BeanPropertySqlParameterSource(newMBTI));
		log.info("결과 : {}", res);
		
	}
	
	@Test
	@Disabled
	void testMultiColumn() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MT_TYPE, MT_TITLE, MT_CONTENT ");
		sql.append("FROM TB_MBTIDESC");
		List<MbtiVO> list = jdbcTemplate.query(sql.toString(), new RowMapper<MbtiVO>() {

			@Override
			public MbtiVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MbtiVO mbti = new MbtiVO();
				mbti.setMtType(rs.getString("MT_TYPE"));
				mbti.setMtTitle(rs.getString("MT_TITLE"));
				mbti.setMtContent("MT_CONTENT");
				return mbti;
			}
		});
		list.forEach(r -> log.info("recode : {}", r));
	}
	
	
	@Test
	void testJdbcTemplate() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MT_TYPE ");
		sql.append("FROM TB_MBTIDESC");
		List<String> list = jdbcTemplate.queryForList(sql.toString(), String.class);
		list.forEach(type -> log.info("type : {}", type));
	}
	
	@Test
	void test() {
		log.info("주입된 객체 : {}", dataSource);
		assertDoesNotThrow(() -> {
			try(
				Connection conn = dataSource.getConnection()
			){
				log.info("conn : {}", conn);
			}
		});
	}
	
	

}
