import java.util.*;
public class RandomGenerator
{
	public static void main(String[] args)
	{
		Random rand=new Random();
		int RandomInt=rand.nextInt(2)+1;
		System.out.println("RandomInt = "+RandomInt);
	}
}