package study.java.lamda;

interface Printable{
	void print(String s);
}
//�ν��Ͻ����� ��� �ϳ��� �ʿ��� ��Ȳ
public class Lamda{
	public static void main(String args[]) {
		
		//1.�͸�Ŭ����
		Printable prn = new Printable() { 
			public void print(String s) {
				System.out.println(s);
			}
		};
		
		//2.���ٽ� 
		Printable prn2 = (s) -> { System.out.println(s); };
		
		prn.print("what is lamda?");
	}

}
