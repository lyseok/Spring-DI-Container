package kr.or.ddit.mission.objs;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component
@Scope("prototype")
public class Riffle implements Gun {

}
