import java.util.*;
import java.io.*;
import java.lang.*;

public class Code
{
	public static void main(String[] args)
	{
		CookieJar jar=new CookieJar();

		Homer homer=new Homer(jar);
		Marge marge=new Marge(jar);

		new Thread(homer).start();
		new Thread(marge).start();
	}

	public static class Homer implements Runnable 
	{
		CookieJar jar;

		public Homer(CookieJar jar)
		{
			this.jar=jar;
		}

		public void eat()
		{
			jar.getCookie("Homer");
			try
			{
				Thread.sleep((int)Math.random()*500);
			}
			catch(InterruptedException e) {}
		}


		public void run()
		{
			for (int i=0;i<5;i++)
			{
				eat();
			}
		}
	}

	public static class Marge implements Runnable
	{
		CookieJar jar;

		public Marge(CookieJar jar)
		{
			this.jar=jar;
		}

		public void bake(int cookieNumber)
		{
			jar.putCookie("Marge",cookieNumber);
			try
			{
				Thread.sleep((int)Math.random()*500);
			}
			catch(InterruptedException e) {}
		}

		public void run()
		{
			for (int i=0;i<5;i++)
			{
				bake(i);
			}
		}
	}

	public static class CookieJar
	{
		private volatile int contents;
		private volatile boolean available = false;

		public synchronized void getCookie(String who)
		{
			while (!available)
			{
				try
				{
					wait();
				}
				catch (InterruptedException e) { }
			}
			available=false;
			notifyAll();
			System.out.println(who+" ate cookie "+contents);
		}

		public synchronized void putCookie(String who,int value)
		{
			while (available)
			{
				try 
				{
					wait();
				}
				catch(InterruptedException e) {}
			}
			contents=value;
			available=true;
			System.out.println(who+" put cookie "+contents+" in the jar");
			notifyAll();		
		}
	}
}