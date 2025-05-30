package kr.or.ddit.case06.objs.xmlchild;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case06.objs.parent.CommonService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class XmlChildController {
	private CommonService service;
}
