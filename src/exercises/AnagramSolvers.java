package exercises;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This script checks if two strings are anagrams.
 * Anagrams are those strings that can form another words by repositioning the chars.
 * ex:
 * Listen = Silent
 * The Morse Code = Here comes dots
 * Eleven plus two = Twelve plus one
 */

public class AnagramSolvers 
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		String firstWord = readString(sc, "Enter the first word:");
		String secondWord = readString(sc, "Enter the second word:");
		//
		System.out.println(solveAnagram(firstWord, secondWord));
		//Debug
		System.out.println("\nDebug: (true)");
		System.out.println(solveAnagram("Astronomer", "Moon starer"));
		sc.close();
	}
	
	private static boolean solveAnagram(String firstString, String secondString)
	{	
		String finalFirstString = clearTheString(firstString);
		String finalSecondString = clearTheString(secondString);
		
		char[] firstCharArray = finalFirstString.toCharArray();
		Arrays.sort(firstCharArray);
		
		char[] secondCharArray = finalSecondString.toCharArray();
		Arrays.sort(secondCharArray);
			
		if(new String(firstCharArray).equals(new String(secondCharArray)))
		{
			return true;
		}
		
		return false;
	}
	
	private static String clearTheString(String inputString)
	{
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0; i<inputString.length(); i++)
		{
			if(Character.isLetterOrDigit(inputString.charAt(i)))
			{
				strBuilder.append(Character.toLowerCase(inputString.charAt(i)));
			}
		}
		return strBuilder.toString();
	}
	
	private static String readString(Scanner sc, String message) {
		System.out.println(message);
		String read = sc.nextLine();
		return read;
	}
}
