import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import java.lang.*;
import java.io.*;

public class TestRunnner
{
	public static void main(String[] args) throws IOException
	{
		Result result=JUnitCore.runClasses(Ser_Des.class);
		for (Failure failure:result.getFailures())
		{
			System.out.println(failure.toString());
		}
		//System.out.println(!result.wasSuccessful());
		System.out.println(result.wasSuccessful());
	}
}