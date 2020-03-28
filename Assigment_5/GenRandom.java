import java.util.*;
import java.io.*;
import java.lang.*;

public class GenRandom
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i=1;i<11;i++)
		{
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int i=0;i<3;i++)
		{
			System.out.println(list.get(i));
		}
	}
}