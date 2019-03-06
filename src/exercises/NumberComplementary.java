package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This script returns the complementary of a number.
 * Ex: 253 -> 747	(253 + 747 == 1000)
 */

public class NumberComplementary 
{	
	public static void main(String[] args)
	{	 
		Scanner sc = new Scanner(System.in);		
		int inputNo = readNumber(sc);
		System.out.println(findComplementaryNumber(inputNo));		
		sc.close();
	}
	
	private static int findComplementaryNumber(int inputNr)
	{
		int round_perf_no = 1;
		while(round_perf_no < inputNr)
		{
			round_perf_no *= 10;
		}
		int complementary_nr = round_perf_no - inputNr;
		return complementary_nr;
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
