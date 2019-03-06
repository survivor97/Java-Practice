package exercises;

public class PowerOfNumberRecursive 
{
	
	public static void main(String[] args)
	{	
		System.out.println("Iterative: ");
		System.out.println(powIterative(22, 10));		
		System.out.println();
		System.out.println("Recursive: ");
		System.out.println(powRecursive(22,10));
	}
	
	private static long powRecursive(long nr, long pow)
	{
		if(pow == 0)
		{
			return 1;
		}
		else
		{
			pow -= 1;
			return nr * powRecursive(nr, pow);
		}
	}
	
	private static long powIterative(long nr, long putere)
	{
		long n = nr;
		long p = putere;
				
		while(p>1)
		{
			n *= nr;
			p--;
		}
		
		return n;
	}
}
