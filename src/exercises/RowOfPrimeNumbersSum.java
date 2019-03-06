package exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This script prints the succession of prime numbers sum under the upper limit
 * 2, 5(2+3), 7(2+3+5), 17(2+3+5+7) 
 * Ex: upper limit -> 100
 * 2 5 10 17 28 41 58 77 100
 */

public class RowOfPrimeNumbersSum 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int inputNo = readNumber(sc);
		createRow(inputNo);
		sc.close();
	}
	
	static void createRow(int upperLimit)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] finalList;
		
		for(int i=2; i<=upperLimit; i++)
		{
			if(isPrime(i))
			{
				list.add(i);					
			}
		}
		
		finalList = new int[list.size()-1];
		int k = 1;
		
		while(k < list.size())
		{
			int sum = 0;
			for(int i=0; i<k; i++)
			{				
				sum += list.get(i);				
			}
			finalList[k-1] = sum;
			k++;
		}
		
		for(int i=0; i<finalList.length; i++)
		{
			if(finalList[i] <= upperLimit)
			{
				System.out.print(finalList[i]+" ");
			}
		}
		
	}
	
	private static boolean isPrime(int n)
	{
		for(int i=2; i<=n/2; i++)
		{
			if(n%i == 0 && n != i)
			{
				return false;
			}
		}
		return true;
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
