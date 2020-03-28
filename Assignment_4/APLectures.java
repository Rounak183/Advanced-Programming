import java.util.*;
import java.io.*;
import java.lang.*;

class Student
{
	String Name;
	int age;

	public Student(String Name,int Age)
	{
		this.Name=Name;
		this.age=age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String Name)
	{
		this.Name=Name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age=age;
	}

	@Override
	public String toString()
	{
		return "Customer{ "+"Name = "+Name+", Age = "+Age+'}';
	}

	static class CustomerSortingComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student customer1,Student customer2)
		{
			int NameCompare=customer1.getName().compareTo(customer2.getName());
			int AgeCompare=customer1.getAge().compareTo(customer2.getAge());

			if (NameCompare==0)
			{
				return ((AgeCompare==0)?NameCompare:AgeCompare);
			}
			else
			{
				return NameCompare;
			}
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Student> al=new ArrayList<Student>();

		Student obj1=new Student("abc",27);
		Student obj2=new Student("Sneha",23);
		Student obj3=new Student("Simran",37);
		Student obj4=new Student("abc",22);
		Student obj5=new Student("abc",29);
		Student obj6=new Student("Sneha",22);

		al.add(obj1);
		al.add(obj2);
		al.add(obj3);
		al.add(obj4);
		al.add(obj5);
		al.add(obj6);

		Iterator<Student> cusIterator=al.iterator();

		System.out.println("Before Sorting:\n");
		while (cu)
	}

/////////// 

public class MyGenericList<T>
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

public class Main
{
	public static void main(String[] args)
	{
		MyGenericList<String> strList=new MyGenericList<String>();
		MyGenericList<Integer> inList=new MyGenericList<Integer>();

		strList.add("hello");
		inList.add(1);
	}
}