import java.util.*;
import java.lang.*;
import java.io.*;

public class GetGaussian
{
	public static void main(String[] args)
	{
		Random rand=new Random();
		double val=rand.nextGaussian()*100+500;
		System.out.println("Val = "+(int)val);
	}
}