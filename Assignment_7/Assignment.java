import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.concurrent.*;

public class Assignment
{
	public static void main(String[] args) throws InterruptedException
	{
		RestOfTheWork work=new RestOfTheWork();
		work.call();
	}
}

class RestOfTheWork
{
	private volatile static Queue<Integer> queue=new LinkedList<>();
	private volatile static Map<Integer,Float> results=new HashMap<Integer,Float>();
	private volatile Map<Integer,Integer> savedlist=new HashMap<Integer,Integer>();
	private volatile boolean exit=false;
	boolean done=false;
	Rest_Of_Functions functions=new Rest_Of_Functions();
	Scanner in=new Scanner(System.in);

	void call() throws InterruptedException
	{
		Main_Interaction main_interaction=new Main_Interaction();
		new Thread(main_interaction).start();
	}

	private class Main_Interaction extends Display implements Runnable
	{
		volatile ArrayList<Fibonnaci_Computing_Threads> computing_threads=new ArrayList<Fibonnaci_Computing_Threads>();
		RestOfTheWork work=new RestOfTheWork();
		public void run() 
		{
			Main_Work();
		}	

		private void Main_Work()
		{
			computing_threads=work.create_threads();
			while (true)
			{
				for (Fibonnaci_Computing_Threads computing_thread: computing_threads)
				{
					Thread new_thread=new Thread(computing_thread);
					new_thread.start();
				}
				int chosen_option=this.display();
				int number;
				switch (chosen_option)
				{
					case 1: 
						number=Integer.parseInt(in.next());
						//System.out.println("number = "+number)	
						/*if (savedlist.containsKey(number))
						{
							System.out.println("Inside saved list");
							for (Map.Entry mapElement : savedlist.entrySet())
							{
								int key=(int)mapElement.getKey();
								if (key==number)
								{
									int answer=(int)mapElement.getValue();
									System.out.println("answer = "+answer);
									break;
								}
							}	
						}*/
						functions.putNumber(number);
						//System.out.println("done");
						break;
					case 2:		
						for (Map.Entry mapElement : results.entrySet())
						{
							int answer=(int)mapElement.getKey();
							System.out.println("answer = "+answer);
						}
						break;
					case 3:
						exit=true;
						for (Fibonnaci_Computing_Threads computing_thread: computing_threads)
						{
							Thread end_thread=new Thread(computing_thread);
							while (end_thread.interrupted())
							{
								System.out.println("Ended");
							}
						}
						System.exit(0);
						break;
					default:
						System.out.println("Choose an option");
						break;
				}
			}
		}

		private class Display
		{
			int display()
			{
				System.out.println("Display to Override");
				return 0;
			}
		}

		@Override
		int display()
		{
			System.out.println("Choose an option :");
			System.out.println("1) Enter number whose Fibo is to be calculated");
			System.out.println("2) Show the result of all pending queries");
			System.out.println("3) Terminate the program");
			int chosen_option=Integer.parseInt(in.next());
			return chosen_option;
		}

	}

	private ArrayList<Fibonnaci_Computing_Threads> create_threads()
	{
		System.out.println("Enter the number of consumer threads to be created: ");
		int number_of_threads=Integer.parseInt(in.next());
		ArrayList<Fibonnaci_Computing_Threads> computing_threads=new ArrayList<Fibonnaci_Computing_Threads>();
		for (int i=0;i<number_of_threads;i++)
		{
			Fibonnaci_Computing_Threads computing_thread=new Fibonnaci_Computing_Threads();
			computing_threads.add(computing_thread);
		} 				
		return computing_threads;
	}

	private class Fibonnaci_Computing_Threads implements Runnable
	{
		public void run()
		{
			while (true)
			{
				functions.getResults();
				if (exit==true)
				{
					return;
				}
			}
		}
	}

	private void stop_call()
	{

	}

	private class Rest_Of_Functions
	{
		private synchronized int calculate_fibo(int num)
		{
			if (num<=1)
				return num;
			return calculate_fibo(num-1)+calculate_fibo(num-2);
		}

		private synchronized void putNumber(int number)
		{
			queue.add(number);
			//System.out.println("queue = "+queue);
			notifyAll();
		}

		private synchronized void getResults()
		{
			boolean printed_answer=false;
			while (queue.size()==0)
			{
				//System.out.println("Shit empty queue");
				try
				{
					wait();
				}
				catch(InterruptedException e) {}
				if (exit==true)
					return;
			}
			//System.out.println("I'm here");
			int number=queue.remove();
			if (savedlist.containsKey(number))
			{
				//System.out.println("Inside saved list");
				for (Map.Entry mapElement : savedlist.entrySet())
				{
					int key=(int)mapElement.getKey();
					if (key==number)
					{
						int answer=(int)mapElement.getValue();
						System.out.println("answer = "+answer);
						printed_answer=true;
						break;
					}
				}
				if (exit==true)
				{
					System.exit(0);
				}	
			}
			if (printed_answer!=true)
			{
				System.out.println("queue = "+queue);
				int number_of_elements_of_queue=queue.size();
				notifyAll();
				long start=System.nanoTime();
				int answer=calculate_fibo(number);
				notifyAll();
				long end=System.nanoTime();
				float sec=(end-start)*(10^9);
				System.out.println("answer = "+answer);
				System.out.println("queue had this many elements "+number_of_elements_of_queue);
				results.put(answer,sec);
				savedlist.put(number,answer);
				//System.out.println("exit = "+exit);
				if (exit==true)
				{
					System.exit(0);
				}
			}
			//return answer;
			/*for (Map.Entry mapElement : savedlist.entrySet())
			{
				System.out.println("andar hai");
				int key=(int)mapElement.getKey();
				System.out.println("key = "+key);
			}*/
		}
	}
}