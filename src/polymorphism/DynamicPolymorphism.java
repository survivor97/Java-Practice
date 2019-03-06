package polymorphism;

public class DynamicPolymorphism {
	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		ParentClass c = new ChildClass();
		System.out.println(p.myMethod(5));
		System.out.println(c.myMethod(5));
	}
}

class ParentClass {
	int myMethod(int nr) {
		return nr * 10;
	}
}

class ChildClass extends ParentClass {
	@Override
	int myMethod(int nr) {
		return nr * 2;
	}	
}