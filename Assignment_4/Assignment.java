import java.util.*;
import java.io.*;
import java.lang.*;

class MyException extends Exception
{
	String str1;
	MyException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("OutOfLimitException Occured: "+str1);
	}
}

class MyGenericList <T>
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

class MyException_2 extends Exception
{
	String str1;
	MyException_2(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("Value Error: "+str1);
	}
}

class EmptyNameException extends Exception
{
	String str1;
	EmptyNameException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("Name Error: "+str1);
	}
}

class SnakeBiteException extends Exception
{
	String str1;
	SnakeBiteException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("SnakeBiteException Occured: "+str1);
	}
}

class CricketBiteException extends Exception
{
	String str1;
	CricketBiteException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("CricketBiteException Occured: "+str1);
	}
}

class VultureBiteException extends Exception
{
	String str1;
	VultureBiteException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("VultureBiteException Occured: "+str1);
	}
}

class TrampolineException extends Exception
{
	String str1;
	TrampolineException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("TrampolineException Occured: "+str1);
	}
}

class GameWinnerException extends Exception
{
	String str1;
	GameWinnerException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("GameWinnerException Occured: "+str1);
	}
}
abstract class Tile
{
	private final int moves;
	private final int position;
	protected abstract void Display();
	public Tile()
	{
		this.moves=0;
		this.position=0;
	}
	public int getPosition()
	{
		return this.position;
	}
	public int opertion(int position,int number_of_tiles)
	{
		return 0;
	}
	public String getType()	
	{
		return "Tile";
	}
}

class White_Tile extends Tile
{
	private final int moves;
	private final int position;
	public White_Tile(int position)
	{
		this.moves=0;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("I am a White Tile");
	}
	public int getPosition()
	{
		return this.position;
	}
	public String getType()
	{
		return "White";
	}
	public int getMoves()
	{
		return this.moves;
	}
}

class Snake_Tile extends Tile
{
	private final int moves;
	private final int position;
	public Snake_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Hiss...! I am a Snake, you go back "+this.moves+" tiles!");
	}
	public int getPosition()
	{
		return this.position;
	}
	public String getType()
	{
		return "Snake";
	}
	public int getMoves()
	{
		return this.moves;
	}
	public int opertion(int position,int number_of_tiles)
	{
		position-=this.moves;
		try
		{
			if (position<1)
			{
				position=1;
				throw new MyException("Josh moved to Tile 1 as it can't go back further");
			}
			else
			{
				throw new SnakeBiteException("You go back "+this.moves);
			}
		}
		catch(MyException exp)
		{
			System.out.println(exp);
		}
		catch(SnakeBiteException exp)
		{
			System.out.println(exp);
		}
		return position;
	}
}

class Cricket_Tile extends Tile
{
	private final int moves;
	private final int position;
	public Cricket_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Chirp...! I am a cricket, you go back "+this.moves+" tiles!");
	}
	public int getPosition()
	{
		return this.position;
	}
	public String getType()
	{
		return "Cricket";
	}
	public int getMoves()
	{
		return this.moves;
	}
	public int opertion(int position,int number_of_tiles)
	{
		position-=this.moves;
		try
		{
			if (position<1)
			{
				position=1;
				throw new MyException("Josh moved to Tile 1 as it can't go back further");
			}
			else
			{
				throw new CricketBiteException("You go back "+this.moves);
			}
		}
		catch(MyException exp)
		{
			System.out.println(exp);
		}
		catch(CricketBiteException exp)
		{
			System.out.println(exp);
		}
		return position;
	}
}

class Vulture_Tile extends Tile
{
	private final int moves;
	private final int position;
	public Vulture_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Yapping...! I am a Vulture, you go back "+this.moves+" tiles!");
	}
	public int getPosition()
	{
		return this.position;
	}
	public String getType()
	{
		return "Vulture";
	}
	public int getMoves()
	{
		return this.moves;
	}
	public int opertion(int position,int number_of_tiles)
	{
		position-=this.moves;
		try
		{
			if (position<1)
			{
				position=1;
				throw new MyException("Josh moved to Tile 1 as it can't go back further");
			}
			else
			{
				throw new VultureBiteException("You go back "+this.moves);
			}
		}
		catch(MyException exp)
		{
			System.out.println(exp);
		}
		catch(VultureBiteException exp)
		{
			System.out.println(exp);
		}
		return position;
	}
}

class Trampoline_Tile extends Tile
{
	private final int moves;
	private final int position;
	public Trampoline_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("PingPong! I am a Trampoline, you advance "+this.moves+" tiles!");
	}
	public int getPosition()
	{
		return this.position;
	}
	public String getType()
	{
		return "Trampoline";
	}
	public int getMoves()
	{
		return this.moves;
	}
	public int opertion(int position,int number_of_tiles)
	{
		position+=this.moves;
		try
		{
			if (position>number_of_tiles)
			{
				throw new MyException("You have won the game!!!");
			}
			else
			{
				throw new TrampolineException("You have advanced "+this.moves+" tiles!");
			}
		}
		catch(MyException exp)
		{
			System.out.println(exp);
		}
		catch(TrampolineException exp)
		{
			System.out.println(exp);
		}
		return position;
	}
}

public class Assignment
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Random randomGenerator=new Random();
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		
		System.out.println("Enter total number of tiles on the race track(length)");
		int number_of_tiles=0;
		try
		{
			number_of_tiles=Integer.parseInt(in.next());
			if (number_of_tiles<10)
			{
				throw new MyException_2("Enter number greater than 10");
			}
		}
		catch(MyException_2 exp)
		{
			System.out.println(exp);
			System.out.println("We are exiting the game");
			System.exit(0);
		}

		System.out.println("Setting up the race track...");
		
		int snakes,crickets,vultures,trampolines,whites;
		snakes=randomGenerator.nextInt((int)(number_of_tiles/10))+1;
		crickets=randomGenerator.nextInt((int)(number_of_tiles/10))+1;
		vultures=randomGenerator.nextInt((int)(number_of_tiles/10))+1;
		trampolines=randomGenerator.nextInt((int)(number_of_tiles/10))+1;
		whites=number_of_tiles-(snakes+crickets+vultures+trampolines);
		System.out.println("Danger: There are "+snakes+", "+crickets+", "+vultures+" numbers of Snakes, Cricket, and Vultures respectively on your track!");
		
		int min_limit=(int)(number_of_tiles/50)+1;
		int max_limit=(int)(number_of_tiles/40)+1;

		int snake_power,cricket_power,vulture_power,trampoline_power;
		snake_power=randomGenerator.nextInt(max_limit)+min_limit;
		cricket_power=randomGenerator.nextInt(max_limit)+min_limit;
		vulture_power=randomGenerator.nextInt(max_limit)+min_limit;
		trampoline_power=randomGenerator.nextInt(max_limit)+min_limit;

		System.out.println("Danger: Each Snake, Cricket and Vulture can throw you back by "+snake_power+", "+cricket_power+", "+vulture_power+" number of tiles respectively!");

		System.out.println("Good News: There are "+trampolines+" number of Trampolines on your track!");
		System.out.println("Good News: Each Trampoline can help you advance by "+trampoline_power+" number of Tiles");

		System.out.println("Enter the Player Name");
		String rand=in.next();
		String player_name=in.nextLine();
		System.out.println("Player name = "+player_name);
		try
		{
			if (player_name==null)
			{
				throw new EmptyNameException("Please Enter proper Name");
			}
		}
		catch (EmptyNameException exp)
		{
			System.out.println(exp);
		}

		tiles=AssignTiles(number_of_tiles,snakes,crickets,vultures,trampolines,snake_power,cricket_power,vulture_power,trampoline_power);

		int number_of_rolls=0;
		int snake_bites=0;
		int cricket_bites=0;
		int vulture_bites=0;
		int trampoline_jumps=0;
		int position=1;
		boolean out_of_cage=false;

		System.out.println("Starting the game with "+player_name+" at Tile-1");
		System.out.println("Hit enter to start the game");
		try
		{	
			System.in.read();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Game Started ====================");
		
		boolean just_out=false;
		while (true)
		{
			if (position>number_of_tiles)
				break;
			number_of_rolls+=1;
			int Die_Roll=randomGenerator.nextInt(6)+1;
			System.out.println("Die_Roll = "+Die_Roll);
			System.out.print("[Roll-"+number_of_rolls+"]: "+player_name+" rolled "+Die_Roll+" at Tile-"+position);
			if (out_of_cage==false)
			{
				if (Die_Roll==6)
				{
					System.out.println(" You are out of the cage! You get a free roll");
					out_of_cage=true;
					just_out=true;
				}
				else
				{
					System.out.println(" OOPs you need 6 to start");
				}
			}
			if (out_of_cage==true && just_out==false)
			{
				System.out.println(" landed on Tile "+(position+Die_Roll));
				try
				{
					position+=Die_Roll;
					if (position>number_of_tiles)
					{
						throw new MyException("You have won the game!!!");
					}
					else
					{
						System.out.println("Trying to shake the Tile-"+position);
					}
				}
				catch(MyException exp)
				{
					System.out.println(exp);
					break;
				}

				Tile current_tile=tiles.get(position-1);
				current_tile.Display();
				if (current_tile.getType().equals("White"))
				{
					System.out.println(player_name+" moved to Tile-"+position);
				}
				else if (current_tile.getType().equals("Snake"))
				{
					position=current_tile.opertion(position,number_of_tiles);
					if (position==1)
					{
						out_of_cage=false;
					}
					snake_bites+=1;
				}
				else if (current_tile.getType().equals("Cricket"))
				{
					position=current_tile.opertion(position,number_of_tiles);
					if (position==1)
					{
						out_of_cage=false;
					}
					cricket_bites+=1;
				}
				else if (current_tile.getType().equals("Vulture"))
				{
					position=current_tile.opertion(position,number_of_tiles);
					if (position==1)
					{
						out_of_cage=false;
					}
					vulture_bites+=1;
				}
				else
				{
					position=current_tile.opertion(position,number_of_tiles);
					trampoline_jumps+=1;
				}
			}
			if (just_out==true)
			{
				just_out=false;
			}
		}
		End_Print(player_name,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps);
	}
	public static MyGenericList<Tile> AssignTiles(int number_of_tiles,int snakes,int crickets,int vultures,int trampolines,int snake_power,int cricket_power,int vulture_power,int trampoline_power)
	{
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		ArrayList<Integer> for_placing=new ArrayList<Integer>();
		for (int i=1;i<number_of_tiles+1;i++)
		{
			for_placing.add(new Integer(i));
		}
		Collections.shuffle(for_placing);

		for (int i=0;i<snakes;i++)
		{
			int snake_position=for_placing.get(i);
			Tile snake_tile=new Snake_Tile(snake_power,snake_position);
			tiles.add(snake_tile);
		}
		for (int i=snakes;i<snakes+crickets;i++)
		{
			int cricket_position=for_placing.get(i);
			Tile cricket_tile=new Cricket_Tile(cricket_power,cricket_position);
			tiles.add(cricket_tile);
		}
		for (int i=snakes+crickets;i<snakes+crickets+vultures;i++)
		{
			int vulture_position=for_placing.get(i);
			Tile vulture_tile=new Vulture_Tile(vulture_power,vulture_position);
			tiles.add(vulture_tile);
		}
		for (int i=snakes+crickets+vultures;i<snakes+crickets+vultures+trampolines;i++)
		{
			int trampoline_position=for_placing.get(i);
			Tile trampoline_tile=new Trampoline_Tile(trampoline_power,trampoline_position);
			tiles.add(trampoline_tile);
		}
		for (int i=snakes+crickets+vultures+trampolines;i<number_of_tiles;i++)
		{
			int white_position=for_placing.get(i);
			Tile white_tile=new White_Tile(white_position);
			tiles.add(white_tile);
		}
		return tiles;		
	}
	public static void End_Print(String player_name,int number_of_rolls,int snake_bites,int cricket_bites,int vulture_bites,int trampoline_jumps)
	{
		System.out.println(player_name+" wins the race in: "+number_of_rolls+" rolls!");
		System.out.println("Total Snake Bites = "+snake_bites);
		System.out.println("Total Cricket Bites = "+cricket_bites);
		System.out.println("Total Vulture Bites = "+vulture_bites);
		System.out.println("Trampoline Jumps = "+trampoline_jumps);
	}
}