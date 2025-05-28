package kr.or.ddit.case6.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "kr.or.ddit.case6.objs"
	, excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes =  Controller.class)}
)
public class ParentConfig {

}
