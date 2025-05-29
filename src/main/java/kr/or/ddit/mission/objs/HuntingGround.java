package kr.or.ddit.mission.objs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HuntingGround {
	private Cabin cabin;
	private HuntingDog dog;
	private List<Hunter> hunters;
	
	public void enter(Hunter hunter) {
		hunters.add(hunter);
	}
}
