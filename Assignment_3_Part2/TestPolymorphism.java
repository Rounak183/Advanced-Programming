import java.util.*;
import java.io.*;
import java.lang.*;

class Parent
{
	private String Name;
	private int n;

	/*public Parent(int n,String Name)
	{
		this.n=n;
		this.Name=Name;
	}*/
	public void Print()
	{
	}
}
class subclass1 extends Parent
{
	private final String Name;
	private int n;

	public subclass1(int n,String Name)
	{
		this.n=n;
		this.Name=Name;
	}
	public final void Print()
	{
		System.out.println("n = "+n);
		System.out.println("Name = "+Name);
	}	 
}
class subclass2 extends Parent
{
	private final String Name;
	private int n;

	public subclass2(int n,String Name)
	{
		this.n=n;
		this.Name=Name;
	}	 
	public final void Print()
	{
		System.out.println("n = "+n);
		System.out.println("Name = "+Name);
	}
}
class TestPolymorphism
{
	public static void main(String[] args)
	{
		ArrayList<Parent> parents=new ArrayList<Parent>();

		subclass1 a=new subclass1(10,"Hello");
		subclass2 b=new subclass2(5,"Hi");

		parents.add(a);
		parents.add(b);

		for (Parent parent:parents)
		{
			parent.Print();
		}
	}
}