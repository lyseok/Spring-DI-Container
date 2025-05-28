package kr.or.ddit.case07.objs;

import org.springframework.core.io.Resource;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ResourcesVO {
	private final Resource fR;
	private final String str;
	private final int number;
	private Resource wR;
	private Resource cR;
	
}
