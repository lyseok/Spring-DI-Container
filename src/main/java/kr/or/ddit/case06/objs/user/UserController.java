package kr.or.ddit.case06.objs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case6.objs.parent.CommonService;

// 회원 정보 조회용 컨트롤러
@Controller
public class UserController {
	private CommonService service;
	
	@Autowired
	public void setService(CommonService service) {
		this.service = service;
	}
}
