package matrix.math;

/*
 * 	This script operates between matrices:
 * 	Addition, Subtraction, Multiplication, Scalar Multiplication
 * 
 * 	Example matrices:
 * 	
 * 	First Matrix:
 * 	
 * 		2	3
 * 		6	1
 * 		5	1
 * 
 * 	Second Matrix:
 * 	
 * 		4	3	0
 * 		5	5	1
 * 
 * 	Third Matrix:
 * 
 * 		55	23	13
 * 		 6	51	 1
 * 		 5	51	 1
 * 
 * 	Fourth Matrix:
 * 
 * 		4	3	0
 * 		5	5	1
 * 		1	1	1
 * 
 *  */

public class MatrixOperator {
	
	//MAIN
	public static void main(String[] args) {
		int[][] firstMatrix = new int[3][2];
		int[][] secondMatrix = new int[2][3];
		int[][] thirdMatrix = new int [3][3];
		int[][] fourthMatrix = new int[3][3];
		//
		firstMatrix[0][0] = 2;
		firstMatrix[0][1] = 3;
		firstMatrix[1][0] = 6;
		firstMatrix[1][1] = 1;
		firstMatrix[2][0] = 5;
		firstMatrix[2][1] = 1;
		//
		secondMatrix[0][0] = 4;
		secondMatrix[0][1] = 3;
		secondMatrix[0][2] = 0;
		secondMatrix[1][0] = 5;
		secondMatrix[1][1] = 5;
		secondMatrix[1][2] = 1;
		//
		thirdMatrix[0][0] = 55;
		thirdMatrix[0][1] = 23;
		thirdMatrix[0][2] = 13;
		thirdMatrix[1][0] = 6;
		thirdMatrix[1][1] = 51;
		thirdMatrix[1][2] = 1;
		thirdMatrix[2][0] = 5;
		thirdMatrix[2][1] = 51;
		thirdMatrix[2][2] = 1;
		//
		fourthMatrix[0][0] = 4;
		fourthMatrix[0][1] = 3;
		fourthMatrix[0][2] = 0;
		fourthMatrix[1][0] = 5;
		fourthMatrix[1][1] = 5;
		fourthMatrix[1][2] = 1;
		fourthMatrix[2][0] = 1;
		fourthMatrix[2][1] = 1;
		fourthMatrix[2][2] = 1;
		
		//Addition		
		System.out.println("SUM: ");
		int[][] sumMatrix = MatrixOperator.sum(firstMatrix, fourthMatrix);
		System.out.println("---");
		sumMatrix = MatrixOperator.sum(thirdMatrix, fourthMatrix);
		MatrixOperator.print(sumMatrix);
		System.out.println();
		
		//Subtraction
		System.out.println("DIFF: ");
		int[][] diffMatrix = MatrixOperator.difference(firstMatrix, fourthMatrix);
		System.out.println("---");
		diffMatrix = MatrixOperator.sum(thirdMatrix, fourthMatrix);
		MatrixOperator.print(diffMatrix);
		System.out.println();
		
		//Multiply
		System.out.println("MULTIPLY: ");
		int[][] finalMatrix = MatrixOperator.product(firstMatrix, secondMatrix);
		MatrixOperator.print(finalMatrix);
		//
		int[][] finalSecondMatrix = MatrixOperator.product(thirdMatrix, fourthMatrix);
		System.out.println("---");
		MatrixOperator.print(finalSecondMatrix);
		System.out.println();
		
		//Scalar Multiply
		System.out.println("SCALAR MULTIPLY: ");
		int[][] finalMatrixScalar = MatrixOperator.product(2, firstMatrix);
		MatrixOperator.print(finalMatrixScalar);
	}
	
	//Addition
	public static int[][] sum(int[][] firstMatrix, int[][] secondMatrix) {
		if((firstMatrix.length == secondMatrix.length) && (firstMatrix[0].length == secondMatrix[0].length)) {
			int[][] finalMatrix = new int[firstMatrix.length][firstMatrix.length];
			for(int i=0; i<firstMatrix.length; i++) {
				for(int j=0; j<firstMatrix.length; j++) {
					finalMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
				}
			}
			return finalMatrix;
		}
		else {
			System.out.println("The matrices can't be summed!");
			return null;
		}
	}
	
	//Subtraction
	public static int[][] difference(int[][] firstMatrix, int[][] secondMatrix) {
		if((firstMatrix.length == secondMatrix.length) && (firstMatrix[0].length == secondMatrix[0].length)) {
			int[][] finalMatrix = new int[firstMatrix.length][firstMatrix.length];
			for(int i=0; i<firstMatrix.length; i++) {
				for(int j=0; j<firstMatrix.length; j++) {
					finalMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
				}
			}
			return finalMatrix;
		}
		else {
			System.out.println("The matrices can't be subtracted!");
			return null;
		}
	}	
	
	//Multiply
	public static int[][] product(int[][] firstMatrix, int[][] secondMatrix) {
		if(firstMatrix.length == secondMatrix[0].length) {
			int length = firstMatrix.length;
			int minLength = (firstMatrix.length < firstMatrix[0].length) ? firstMatrix.length : firstMatrix[0].length;
			
			int[][] finalMatrix = new int[length][length];
			//
			for(int i=0; i<length; i++) {
				for(int j = 0; j<length; j++) {
					finalMatrix[i][j] = productByPosition(firstMatrix, secondMatrix, i, j, minLength);
				}
			}
			//
			return finalMatrix;
		}
		else {
			System.out.println("The matrices can't be multiplied!");
			return null;
		}		
	}
	
	private static int productByPosition(int[][] firstMatrix, int[][] secondMatrix, int currentRow, int currentColumn, int length) {
		int value = 0;
		for(int i=0; i<length; i++) {
			value += firstMatrix[currentRow][i] * secondMatrix[i][currentColumn];
		}
		return value;
	}
	
	//Scalar Multiply
	public static int[][] product(int value, int[][] inputMatrix) {
		int[][] finalMatrix = new int[inputMatrix.length][inputMatrix[0].length];
		for(int i=0; i<inputMatrix.length; i++) {
			for(int j=0; j<inputMatrix[0].length; j++) {
				finalMatrix[i][j] = inputMatrix[i][j] * value;
			}
		}
		return finalMatrix;
	}
	
	//Print
	public static void print(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}	
}
