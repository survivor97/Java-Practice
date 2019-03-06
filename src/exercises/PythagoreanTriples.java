package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * https://en.wikipedia.org/wiki/Pythagorean_triple
 * This script finds all the Pythagorean triples under the upper limit
 * Ex: upper limit -> 20
 * 3 4 5
 * 5 12 13
 * 6 8 10
 * 8 15 17
 * 9 12 15
 */

public class PythagoreanTriples 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);		
		int inputNo = readNumber(sc);		
		printPythagoreanTriples(inputNo);
		sc.close();
	}
	
	private static void printPythagoreanTriples (int upperLimit)
	{
		for(int i=1; i<upperLimit; i++)
		{
			for(int j=i; j<upperLimit; j++)
			{
				int k = (int)Math.sqrt(i*i + j*j);
				if((k*k == i*i + j*j) && (k < upperLimit))
				{
					System.out.println(i+" "+j+" "+k);	
				}						
			}
		}
	}
	
	private static int readNumber(Scanner sc) {
		int inputNo;		
		
		while(true) {
			try {
				System.out.println("Enter Number:");
				inputNo = sc.nextInt();						
				return inputNo;
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input!");
				sc.nextLine();				
			}
		}
	}
}
