package matrix.math;

import java.util.Random;

/*
 * 	This script generates random sized, alternative and ordered matrix, horizontally or vertically
 * 
 * 	Ex:
 * 	
 * 	 	1  16  17  
 *		2  15  18  
 *		3  14  19  
 *		4  13  20  
 *		5  12  21  
 *		6  11  22  
 *		7  10  23  
 *		8   9  24  
 *
 *		---------
 *
 *		24  23  22  21  20  19  
 *		13  14  15  16  17  18  
 *		12  11  10   9   8   7  
 *		 1   2   3   4   5   6 
 *
 */

public class AlternativeMatrix {

	private int rows, columns;
	private int[][] matrix;
	private Random rand;
	
	//MAIN
	public static void main(String[] args) {
		
		AlternativeMatrix firstMatrixClass = new AlternativeMatrix("horizontal");
		System.out.println("Horizontally ordered:\n");	
		firstMatrixClass.print();
		//
		System.out.println("_______________________");	
		//
		AlternativeMatrix sndMatrixClass =  new AlternativeMatrix("vertical");
		System.out.println("Vertically Ordered:\n");
		sndMatrixClass.print();
		
	}
	
	public AlternativeMatrix(String type) {
		
		rand = new Random();
		
		rows = rand.nextInt(8) + 3;
		columns = rand.nextInt(8) + 3;
				
		matrix = new int[rows][columns];
		
		switch(type) {
		case "horizontal":
			horizontalArrange();
			break;
		
		case "vertical":
			verticalArrange();
			break;
		
		default:
			System.out.println("unknown type");
		}	

		
	}
	
	private void horizontalArrange() {		
		int currentRow = 0;
		boolean goRight = true;
		int number = 0;
		
		//Randomize a number
		//number = rand.nextInt(99 - rows * columns);
		number = 1;
		
		while(currentRow < rows) {
			//Set Direction
			if(currentRow % 2 == 0) {
				goRight = true;
			}
			else {
				goRight = false;
			}

			//Set values
			if(goRight) {
				for(int i=0; i<columns; i++) {					
					matrix[rows - currentRow-1][i] = number;
					number++;
				}
			} 
			else {
				for(int i=columns-1; i>=0; i--) {
					matrix[rows - currentRow-1][i] = number;
					number++;
				}
			}

			//Increase the row
			currentRow++;
		}
	}
	
	private void verticalArrange() {			    
		int currentColumn = 0;
		boolean goDown = true;
		int number = 0;
		
		//Randomize a number
		//number = rand.nextInt(99 - rows * columns);
		number = 1;
		
		while(currentColumn < columns) {
			//Set Direction
			if(currentColumn % 2 == 0) {
				goDown = true;
			}
			else {
				goDown = false;
			}

			//Set values
			if(goDown) {
				for(int i=0; i<rows; i++) {					
					matrix[i][currentColumn] = number;
					number++;
				}
			} 
			else {
				for(int i=rows-1; i>=0; i--) {
					matrix[i][currentColumn] = number;
					number++;
				}
			}

			//Increase the row
			currentColumn++;
		}
	}
	
	//PUBLIC	
	//Print
	public void print() {
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[i].length; j++) {
				if(this.matrix[i][j] <= 9) {
					System.out.print(" "+this.matrix[i][j]+"  ");
					continue;
				}
				System.out.print(this.matrix[i][j]+"  ");
			}
			System.out.println("");
		}
	}	
}
