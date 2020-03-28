class OperatorOVERDD
{
	void operator(String str1,String str2)
	{
		String s=str1+str2;
		System.out.println("Concatenated String - "+s);
	}

	void operator(int a,int b)
	{
		int c=a+b;
		System.out.println("Sum = "+c);
	}
}

class Main
{
	public static void main(String[] args)
	{
		OperatorOVERDD obj=new OperatorOVERDD();
		obj.operator(2,3);
		obj.operator("joe","now");
	}
}