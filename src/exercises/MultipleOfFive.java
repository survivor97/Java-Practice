package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This script returns the lowest multiple of 5 for an input
 * Ex: 556 -> 560; 15 -> 15;
 */

public class MultipleOfFive 
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);		
		int inputNo = readNumber(sc);
		System.out.println(getMultipleOfFive(inputNo));
		sc.close();
	}
		
	private static int getMultipleOfFive(int inputNr)
	{
		int x = 0;
		while(x < inputNr)
		{
			x += 5;
		}
		return x;
	}
	
	private static int readNumber(Scanner sc) {
		int inputNo;		
		
		while(true) {
			try {
				System.out.println("Enter a number:");
				inputNo = sc.nextInt();						
				return inputNo;
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input!");
				sc.nextLine();				
			}
		}
	}
}
