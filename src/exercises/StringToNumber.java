package exercises;


/*
 * This script converts a String to an integer
 */

public class StringToNumber 
{
	public static void main(String[] args)
	{
		System.out.println(convertStringToNumber("12334"));		
	}
	
	public static int convertStringToNumber(String numberStr) 
	{
		 char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		 int numValue = 0;

		 for(int i=0; i<numberStr.length(); i++)
		 {
			for(int j=0; j<digits.length; j++)
			{
				if(numberStr.charAt(i) == digits[j])
				{
					numValue = numValue * 10 + (int)(digits[j] - 48);
				}		
			}
		 }
		 
		 return numValue;
	}	
	
}
