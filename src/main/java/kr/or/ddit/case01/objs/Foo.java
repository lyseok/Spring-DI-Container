package kr.or.ddit.case01.objs;

public class Foo {
	private final Bar bar; // 필수 의존 객체
	private Baz baz; // 옵셔널 의존객체
	
	// 생성자 주입방식(constructor injection)
	public Foo(Bar bar) {
		super();
		this.bar = bar;
	}
	// setter injection
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
}
