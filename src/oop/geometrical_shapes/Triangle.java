package oop.geometrical_shapes;

public class Triangle extends Shape {
	private int base;
	private int height;
	
	public Triangle(int base, int height) {
		super();
		this.base = base;
		this.height = height;		
	}
	 
	public Triangle(String text, String material, int base, int height) {
		super(text, material);
		this.base = base;
		this.height = height;
	}
	
	public void displayTriangleHeight() {
		System.out.println("Triangle height is: "+height);
	}

	@Override
	public double getSize() {
		return base * height / 2;
	}

	@Override
	public String toString() {
		return "Triangle: height is "+height+", base is: "+base+", "+super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + base;
		result = prime * result + height;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (base != other.base)
			return false;
		if (height != other.height)
			return false;
		return true;
	}
	
}
