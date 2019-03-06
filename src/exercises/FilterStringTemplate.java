package exercises;

import java.util.ArrayList;

/*
 * This script filters selectively an array of strings, depending on a key string and a match key that shows the minimum number of identical characters.
 * ex:
 * ARGUMENTS:	[airport, cars, glass, spaceship, star, class, vehicle], "space", 1	
 * RETURN:		[glass, spaceship, star, class]
 * 
 * ARGUMENTS:	[airport, cars, glass, spaceship, star, class, vehicle], "space", 2
 * RETURN:		[spaceship, star]
 * 
 * ARGUMENTS:	[airport, cars, glass, spaceship, star, class, vehicle], "space", 3
 * RETURN:		[spaceship]
 */

public class FilterStringTemplate 
{
	public static void main(String[] args)
	{
		String[] inputStr = {"airport", "cars", "glass", "spaceship", "star", "class", "vehicle"};
		String[] outputStr = filterString(inputStr, "space", 1);		
		print(outputStr);
		//
		outputStr = filterString(inputStr, "space", 2);
		print(outputStr);
		//
		outputStr = filterString(inputStr, "space", 3);
		print(outputStr);
	}
	
	private static String[] filterString(String[] words, String key, int matchKey)
	{
		ArrayList<Character> charList = new ArrayList<>();
		ArrayList<String> stringList = new ArrayList<>();
		
		for(int i=0; i<key.length(); i++)
		{
			charList.add(Character.toLowerCase(key.charAt(i)));
		}
		
		for(int i=0; i<words.length; i++)
		{
			int matchGrade = 0;
			for(int j=0; j<words[i].length(); j++)
			{
				if(j < charList.size())
				{
					if(Character.toLowerCase(words[i].charAt(j)) == charList.get(j))
					{
						matchGrade++;
					}					
				}				
			}
			if(matchGrade >= matchKey)
			{
				stringList.add(words[i]);
			}
		}
		
		String[] output = stringList.toArray(new String[stringList.size()]);		
		return output;
	}	
	
	private static void print(String[] input) {
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println("");
	}
}
