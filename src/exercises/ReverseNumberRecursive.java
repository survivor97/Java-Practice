package exercises;

public class ReverseNumberRecursive 
{
	public static void main(String[] args)
	{
		System.out.println("Iterative:");
		System.out.println(reverseIterative(1234567890));
		System.out.println();
		System.out.println("Recursive:");
		System.out.println(reverseRecursive(1234567890));
	}

	static int reverseRecursive(int nr)
	{
		if(nr/10 == 0)
		{
			return nr % 10;
		}
		else
		{	
			int i=1;
			
			while(i <= nr/10)
			{
				i*=10;
			}
			
			return nr % 10 * i + reverseRecursive(nr/10);		
		}
	}
	
	static int reverseIterative(int nr)
	{
		int result = 0;
		while(nr>0)
		{
			result = result * 10 + (nr % 10);
			nr /= 10;
		}
		return result;
	}
}
