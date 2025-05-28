package kr.or.ddit.case6.objs.admin;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case6.objs.parent.CommonService;
import lombok.RequiredArgsConstructor;

//회원 정보 조회용 컨트롤러
@Controller
@RequiredArgsConstructor
public class AdminController {
	private final CommonService service;
}
