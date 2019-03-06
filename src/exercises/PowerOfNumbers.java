package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This script returns all the power of bases from b^0 to b^e
 * 2 10 -> 1 2 4 8 16 32 64 128 256 512 1024
 */

public class PowerOfNumbers 
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);		
		int b = readNumber(sc, "Enter the base number:");
		int e = readNumber(sc, "Enter the number of exponents:");
		getPowersOfNumber(b, e);		
		sc.close();
	}
	
	private static void getPowersOfNumber(int baseNumber, int noOfExponents)
	{		
		for(int i=0; i<=noOfExponents; i++)
		{
			int currentNr = (int) Math.pow(baseNumber, i);
			System.out.print(currentNr+" ");			
		}
	}
	
	private static int readNumber(Scanner sc, String message) {
		int inputNo;		
		
		while(true) {
			try {
				System.out.println(message);
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
