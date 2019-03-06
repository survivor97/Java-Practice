package oop.geometrical_shapes;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Shape
		Shape sh = new Shape("Shape Text", "CrMo");
		System.out.println(sh);
		System.out.println("--------------------");
		
		//Triangle
		Triangle tr = new Triangle("text", "Al", 2, 2);
		tr.displayTriangleHeight();
		System.out.println(tr);
		System.out.println("--------------------");
		
		//Rectangle
		Rectangle rc = new Rectangle("text", "Zn", 3, 4);
		Rectangle rc2 = new Rectangle("text", "Zn", 3, 4);
		Rectangle rc3 = new Rectangle("text", "Zn", 5, 5);
		rc.displayRectangleHeight();
		System.out.println(rc);
		System.out.println("--------------------\nCompare Objects:\nrc & rc2: "+rc.equals(rc2)+"\nrc2 & rc3: "+rc2.equals(rc3));
		System.out.println("--------------------");
		
		//Upcasting
		Shape ush = new Shape("First Shape", "Cu");
		Shape ush2 = new Shape("Second Shape", "Dilithium");
		
		Triangle utr = new Triangle("First Triangle", "Transparent Aluminium", 6, 6);
		Triangle utr2 = new Triangle("Second Triangle", "Nitrium", 2, 5);
		
		Rectangle urc = new Rectangle("First Rectangle", "Latinum", 77, 77);
		Rectangle urc2 = new Rectangle("Second Rectangle", "Trellium-D", 5, 5);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(ush);
		shapes.add(ush2);
		shapes.add(utr);
		shapes.add(utr2);
		shapes.add(urc);
		shapes.add(urc2);
		
		//Print Array of Shapes
		System.out.println("Shapes toString:");
		for(int i=0; i<shapes.size(); i++) {
			System.out.println(shapes.get(i));
		}
		System.out.println("--------------------");
		
		//Downcasting
		System.out.println("Downcasting:");
		for(int i=0; i<shapes.size(); i++) {
			if(shapes.get(i) instanceof Triangle) {
				Triangle localTriangle = (Triangle) shapes.get(i);
				localTriangle.displayTriangleHeight();
			}
			else if(shapes.get(i) instanceof Rectangle) {
				Rectangle localRectangle = (Rectangle) shapes.get(i);
				localRectangle.displayRectangleHeight();
			}
		}
		System.out.println("--------------------");
		
	}
	
}
