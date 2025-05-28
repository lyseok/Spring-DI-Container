package kr.or.ddit.dummy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.dummy.conf.DummyContextConfig;
import kr.or.ddit.dummy.service.DummyServiceCase1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyController {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("kr.or.ddit.dummy");
		DummyServiceCase1 service = (DummyServiceCase1) context.getBean(DummyServiceCase1.class);
		StringBuffer infomation = service.readDummy("primary");
		log.info("만들어진 요리 : {} ", infomation);
	}
}
