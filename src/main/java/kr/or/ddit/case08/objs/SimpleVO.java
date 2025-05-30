package kr.or.ddit.case08.objs;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Component
@AllArgsConstructor
@Data
public class SimpleVO {
	private Map<String, Object> map;
	private String str;
}
