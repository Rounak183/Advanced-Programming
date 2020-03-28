import java.util.*;
import java.io.*;
import java.lang.*;

class MyGenericList<T>
{
	private ArrayList<T> myList;
	public MyGenericList()
	{
		myList=new ArrayList<T>();
	}

	public void add(T o)
	{
		myList.add(o);
	}
	public T get(int i)
	{
		return myList.get(i);
	}
}
public class GenericTesting
{
	public static void main(String[] args)
	{
		MyGenericList<String> strList=new MyGenericList<String>();
		MyGenericList<Integer> inList=new MyGenericList<Integer>();

		strList.add("hello");
		inList.add(1);

		String str=strList.get(0);
		int integer=inList.get(0);

		System.out.println(str);
		System.out.println(integer);
	}
}