package java_homework_4;

public class calculator {
	private int a;
	private int b;
	public calculator(){
		a = 0;
		b = 0;
	}
	public calculator(int a,int b){
		this.a = a;
		this.b = b;
	}
	private static int sub(int a,int b){
		return a-b;
	}
	private static int add(int a,int b){
		return a+b;
	}
}
