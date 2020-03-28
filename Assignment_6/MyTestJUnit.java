import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.io.*;
import java.lang.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyTestJUnit
{
	@Test
	public void testIncr()
	{
		Sum mySum=new Sum(1,1);
		mySum.incr();
		Sum expected=new Sum(3,3);
		assertEquals(expected,mySum);
		mySum.incr();
		assertEquals(expected,mySum);
	}
}

class Sum
{
	private int var1,var2;
	public Sum(int v1,int v2)
	{
		var1=v1;
		var2=v2;
	}
	public void incr()
	{
		var1++;
		var2++;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o!=null && getClass()==o.getClass())
		{
			Sum s=(Sum)o;
			return ((var1==s.var1) && (var2==s.var2));
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "("+Integer.toString(var1)+","+Integer.toString(var2)+")";
	}
}