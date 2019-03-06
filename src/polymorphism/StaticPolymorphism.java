package polymorphism;

public class StaticPolymorphism {	
	public static void main(String[] args) {
		StaticPolymorphismClass spm = new StaticPolymorphismClass();
		spm.myMethod(2.0);
		spm.myMethod("my text");
		spm.myMethod(5);
	}	
}

class StaticPolymorphismClass {
	public void myMethod(int nr) {
		System.out.println(nr * 10);
	}
	
	public void myMethod(String text) {
		System.out.println(text);
	}
	
	public void myMethod(double nr) {
		System.out.println(nr * 2.0);
	}
}