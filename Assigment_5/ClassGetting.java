public class ClassGetting
{
	public static void main(String[] args)
	{
		Object n=new Integer(5);
		if (n.getClass()==Integer)
			System.out.println("Hi");
		System.out.println(n.getClass());
	}
}