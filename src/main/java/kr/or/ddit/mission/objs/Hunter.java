package kr.or.ddit.mission.objs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import lombok.Getter;
import lombok.ToString;

@Component
@Scope("prototype")
@Getter
@ToString
public class Hunter {
	private Gun gun;
	@ToString.Exclude
	private Cabin cabin;
	@ToString.Exclude
	private HuntingDog dog;
	
	public Hunter(Gun gun) {
		super();
		this.gun = gun;
	}
	
	@Inject
	public void setCabin(Cabin cabin) {
		this.cabin = cabin;
	}
	
	public void changeGun(Gun gun) {
		this.gun = gun;
	}
	
	@Autowired
	public void setDog(HuntingDog dog) {
		this.dog = dog;
	}

}
