import java.util.*;
import java.io.*;
import java.lang.*;

public class RandomDemo
{
	public static void main(String[] args)
	{
		Random randomno=new Random();
		for (int i=0;i<1000;i++)
		{
			System.out.println("Next Gaussian Value: "+randomno.nextGaussian());
		}
	}
}