package kh.java.gui.inner.class_;

/*
 * 내부클래스
 * 
 * 목적
 *  - 외부 클래스에서만 사용할 용도.
 *  - 내부 클래스는 외부 클래스의 필드/메서드에 접근가능(private 포함)
 *  - 외부 클래스안에서만 사용되므로 코드의 복잡성을 줄일 수 있다.
 *  
 *  종류
 *   - static 내부 클래스 (클래스 영역에 선언) : 외부 클래스의 static 자원만 접근 가능
 *   - non-static 내부클래스 (클래스 영역에 선언)
 *   - 지역 내부클래스 (메서드 영역에 선언)
 *   
 *   
 */

public class OuterClass {
	private int num=100; //멤버변수
	private static char ch= 'x'; //클래스변수
	
	public static void main(String[] args) {
		//1.내부 클래스 객체 생성하기
		//non-static
		OuterClass outer = new OuterClass();
		OuterClass.A a = outer.new A();
		
		//static
		OuterClass.B b = new B();
		
		//2.외부 클래스의 자원 사용하기
		a.a();
		b.b();
		
		//3. 내부클래스의 필드 선언
		
		//4.지역내부클래스
		outer.test();
		
		//5.동일한 이름의 필드/메서드 사용하기
		
	}
	
	//non-static 내부클래스
	// - static자원은 상수만 만들수 있고, 반드시 초기화해야함
	public class A {
		private int aNum = 99;
		private static final char aCh='a';
		
		public void a() {
			System.out.println("----- A.a() -----");
			System.out.println(num);
			System.out.println(ch);
			
			System.out.println("=================");
			test();
			OuterClass.this.test(); //Outer클래스의 test메서드
		}
		
		public void test() {
			System.out.println("----- A.test() -----");
		}
		
	}
	//static 내부클래스
	public static class B {
		private int bNum = 88;
		private static char bCh='b';
		public void b() {
			System.out.println("----- B.b() -----");
//			static 내부 클래스에서는 static 자원만 참조가능
//			System.out.println(num);
			System.out.println(ch);
			
		}
		
	}
	
	public void test() {
		//지역 내부 클래스 : 접근제한자를 가질 수 없다.
		class C {
			private int cNum = 77;
			private static final char cCh = 'c';

			public void c() {
				System.out.println("----- test.C.c() -----");
				System.out.println(num);
				System.out.println(ch);
			}
		}
		
		//지역 내부 클래스는 선언후 사용할 것.
		C c = new C();
		c.c();
	}
}
