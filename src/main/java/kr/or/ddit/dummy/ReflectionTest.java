package kr.or.ddit.dummy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionTest {
	public static void main(String[] args) throws Exception {
		Method mtd = ReflectionTest.class.getMethod("testMtd", String.class, Integer.class);
		Parameter[] params = mtd.getParameters();
		log.info("첫번째 파라미터 : {}", params[0].getName());
		log.info("두번째 파라미터 : {}", params[1].getName());
	}
	
	public StringBuffer testMtd(String strArg, Integer intArg) {
		return null;
	}
}
