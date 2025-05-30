package kr.or.ddit.case11.objs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.LprodVO;

@Repository
public interface LprodMapper {
	public List<LprodVO> selectLprodList();

	@Select("""
			SELECT 
				L.LPROD_ID		
			    , L.LPROD_GU GU
			    , L.LPROD_NAME
			    , P.PROD_ID
			    , P.PROD_NAME
			FROM LPROD L LEFT OUTER JOIN PROD P ON(L.LPROD_GU = P.LPROD_GU )
			WHERE L.LPROD_GU = #{gu}
			""")
	@ResultMap("lprodMap")
	public LprodVO selectLprod(@Param("gu") String lprodGu);
	
}	
