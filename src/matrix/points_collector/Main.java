package matrix.points_collector;

public class Main {

	/*
	 * This application collects points from a matrix map.
	 * Direction inputs:
	 * 
	 * 		8	1	2		NV	N	NE
	 * 		7		3	=>	V		 E
	 * 		6	5	4		SV	S	SE
	 * 
	 * Current Map:
	 * 
	 * 		 3		14		100		 21
	 * 		 1		23		  3		  5
	 * 		 6		 1		  4		  9
	 * 		16		41		 55		901
	 * 		 2		70		 25		101
	 * 
	 * Start Position:
	 * 	
	 * 	(0, 0)
	 *  
	 */
	
	public static void main(String[] args) {
		new Manager();		
	}
	
}
