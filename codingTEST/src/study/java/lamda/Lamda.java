package study.java.lamda;

interface Printable{
	void print(String s);
}
//인스턴스보다 기능 하나가 필요한 상황
public class Lamda{
	public static void main(String args[]) {
		
		//1.익명클래스
		Printable prn = new Printable() { 
			public void print(String s) {
				System.out.println(s);
			}
		};
		
		//2.람다식 
		Printable prn2 = (s) -> { System.out.println(s); };
		
		prn.print("what is lamda?");
	}

}
