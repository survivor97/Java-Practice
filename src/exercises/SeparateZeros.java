package exercises;

/*
 * This script moves all the 0s from an array to the left. The other elements maintain their position.
 * ex:
 * [1, 0, -2, 33, 0, 100] -> [0, 0, 1, -2, 33, 100]
 * [1, -222, 3, 0, 0, 0] -> [0, 0, 0, 1, -222, 3]
 */

public class SeparateZeros 
{
	public static void main(String[] args)
	{
		//int[] inputValues = {1, 2, 0, -5};
		//int[] inputValues2 = {0, 2, 1, 0, -1, 14, 0, -6};
		//int[] inputValues3 = {1, 0, -2, 33, 0, 100};
		int[] inputValues4 = {1, -222, 3, 0, 0, 0};
		
		int[] result = rearrange(inputValues4);		
		printArray(result);		
	}
		
	private static int[] rearrange(int[] input)
	{
		int[] localArray = input;
		int iterator = localArray.length - 1;
		
		for(int i=localArray.length - 1; i>=0; i--)
		{
			if(localArray[i] != 0)
			{
				localArray[iterator] = localArray[i];
				iterator--;
			}
		}
		
		for(int i=iterator; i>=0; i--)
		{
			localArray[i] = 0;
		}
		
		return localArray;
	}
	
	private static void printArray(int[] input)
	{
		for(int i=0; i<input.length; i++)
		{
			System.out.print(input[i]+" ");
		}
	}
}
