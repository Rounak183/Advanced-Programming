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

class MyGenericList <T> implements Serializable
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

class MyIOException extends Exception
{
	String str1;
	MyIOException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("MyIOException Occured: "+str1);
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

class WrongNameException extends Exception
{
	String str1;
	WrongNameException(String str2)
	{
		str1=str2;
	}
	public String toString()
	{
		return ("WrongNameException Occured: "+str1);
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
	private static final long serialVersionUID=40L; 
	private final int moves;
	private final int position;
	protected abstract void Display();
	protected abstract void Details();
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
	public abstract void shake() throws Exception; 
	public String getType()	
	{
		return "Tile";
	}
}

class White_Tile extends Tile implements Serializable
{
	private final int moves;
	private final int position;
	private static final long serialVersionUID=41L;
	public White_Tile(int position)
	{
		this.moves=0;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("I am a White Tile"+" My Position: "+this.position);
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
	@Override
	public void shake()
	{
		System.out.println("I am White Tile!");
	}
	protected void Details()
	{
		System.out.println("I am a White Tile");
	}
}

class Snake_Tile extends Tile implements Serializable
{
	private final int moves;
	private final int position;
	private static final long serialVersionUID=42L;
	public Snake_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Hiss...! I am a Snake, you go back "+this.moves+" tiles!"+" My Position: "+this.position);
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
	@Override
	public void shake() throws SnakeBiteException
	{
		System.out.println("I am Snake Tile!");
		throw new SnakeBiteException("Snake");
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
	protected void Details()
	{
		System.out.println("I am a Snake Tile");
		System.out.println("Moves = "+this.moves);
		System.out.println("Position = "+this.position);
		System.out.println("serialVersionUID = "+serialVersionUID);
	}
}

class Cricket_Tile extends Tile implements Serializable
{
	private final int moves;
	private final int position;
	private final long serialVersionUID=43L;
	public Cricket_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Chirp...! I am a cricket, you go back "+this.moves+" tiles!"+" My Position: "+this.position);
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
	@Override
	public void shake() throws CricketBiteException
	{
		System.out.println("I am Cricket Tile!");
		throw new CricketBiteException("Cricket");
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
	protected void Details()
	{
		System.out.println("I am a Cricket Tile");
		System.out.println("Moves = "+this.moves);
		System.out.println("Position = "+this.position);
		System.out.println("serialVersionUID = "+serialVersionUID);
	}
}

class Vulture_Tile extends Tile implements Serializable
{
	private final int moves;
	private final int position;
	private static final long serialVersionUID=44L;
	public Vulture_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("Yapping...! I am a Vulture, you go back "+this.moves+" tiles!"+" My Position: "+this.position);
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
	@Override
	public void shake() throws VultureBiteException
	{
		System.out.println("I am Vulture Tile!");
		throw new VultureBiteException("Vulture");
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
	protected void Details()
	{
		System.out.println("I am a Vulture Tile");
		System.out.println("Moves = "+this.moves);
		System.out.println("Position = "+this.position);
		System.out.println("serialVersionUID = "+serialVersionUID);
	}
}

class Trampoline_Tile extends Tile implements Serializable
{
	private final int moves;
	private final int position;
	private static final long serialVersionUID=45L;
	public Trampoline_Tile(int moves,int position)
	{
		this.moves=moves;
		this.position=position;
	}
	protected void Display()
	{
		System.out.println("PingPong! I am a Trampoline, you advance "+this.moves+" tiles!"+" My Position: "+this.position);
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
	@Override
	public void shake() throws TrampolineException
	{
		System.out.println("I am Trampoline Tile!");
		throw new TrampolineException("Trampoline");
	}
	public int opertion(int position,int number_of_tiles)
	{
		position+=this.moves;
		try
		{
			if (position>number_of_tiles)
			{
				throw new GameWinnerException("You have won the game!!!");
			}
			else
			{
				throw new TrampolineException("You have advanced "+this.moves+" tiles!");
			}
		}
		catch(GameWinnerException exp)
		{
			System.out.println(exp);
		}
		catch(TrampolineException exp)
		{
			System.out.println(exp);
		}
		return position;
	}
	protected void Details()
	{
		System.out.println("I am a Trampoline Tile");
		System.out.println("Moves = "+this.moves);
		System.out.println("Position = "+this.position);
		System.out.println("serialVersionUID = "+serialVersionUID);
	}
}

class RaceTrack implements Serializable 
{
	String player_name;
	MyGenericList<Tile> tiles;
	int number_of_tiles;
	int snakes;
	int crickets;
	int vultures;
	int trampolines;
	int whites;
	int snake_power;
	int cricket_power;
	int vulture_power;
	int trampoline_power;
	int number_of_rolls;
	int snake_bites;
	int cricket_bites;
	int vulture_bites;
	int trampoline_jumps;
	int position;
	boolean check_1;
	boolean check_2;
	boolean check_3;
	ArrayList<String> users;
	boolean game_end;
	boolean just_out;
	boolean out_of_cage;
	String filename;

	RaceTrack(boolean check_1,boolean check_2,boolean check_3,String player_name,MyGenericList<Tile> tiles,int number_of_tiles,int snakes,int crickets,int vultures,int trampolines,int whites,int snake_power,int cricket_power,int vulture_power,int trampoline_power,int number_of_rolls,int snake_bites,int cricket_bites,int vulture_bites,int trampoline_jumps,int position,ArrayList<String> users,boolean game_end,boolean just_out,boolean out_of_cage,String filename)
	{
		this.check_1=check_1;
		this.check_2=check_2;
		this.check_3=check_3;
		this.player_name=player_name;
		this.tiles=tiles;
		this.number_of_tiles=number_of_tiles;
		this.snakes=snakes;
		this.crickets=crickets;
		this.vultures=vultures;
		this.trampolines=trampolines;
		this.whites=whites;
		this.snake_power=snake_power;
		this.cricket_power=cricket_power;
		this.vulture_power=vulture_power;
		this.trampoline_power=trampoline_power;
		this.number_of_rolls=number_of_rolls;
		this.snake_bites=snake_bites;
		this.cricket_bites=cricket_bites;
		this.vulture_bites=vulture_bites;
		this.trampoline_jumps=trampoline_jumps;
		this.position=position;
		this.users=users;
		this.game_end=game_end;
		this.just_out=just_out;
		this.out_of_cage=out_of_cage;
		this.filename=filename;
	}
}
public class Assignment
{
	public static void main(String[] args) throws IOException,ClassNotFoundException
	{
		Scanner in=new Scanner(System.in);
		Random randomGenerator=new Random();
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		ObjectInputStream in_2=null;
		ArrayList<String> users=new ArrayList<String>();

		System.out.println("Enter the total number of tiles on the race track(length)");
		int number_of_tiles=0;
		boolean done_taking_number_of_tiles=false;
		while (done_taking_number_of_tiles==false)
		{
			boolean all_digits=true;
			try
			{
				String number_of_tiles_input=in.next();
				for (char c: number_of_tiles_input.toCharArray())
				{
					if (Character.isDigit(c)==false)
					{
						all_digits=false;
					}
				}
				if (all_digits==false)
				{
					throw new MyIOException("Enter Integer Value");
				}
				else
				{
					number_of_tiles=Integer.parseInt(number_of_tiles_input);
				}
				if (number_of_tiles<10)
				{
					throw new MyException_2("Enter number greater than 10");
				}
				else
				{
					done_taking_number_of_tiles=true;
				}
			}
			catch(MyException_2 exp)
			{
				System.out.println(exp);
			}
			catch(MyIOException exp)
			{
				System.out.println(exp);
			}
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
		String player_name="";
		boolean done_taking_name_input=false;
		while (done_taking_name_input==false)
		{
			boolean all_Letters=true;
			try
			{
				player_name=in.next();
				for (char c:player_name.toCharArray())
				{
					if (Character.isLetter(c)==false)
					{
						all_Letters=false;
					}
				}
				if (all_Letters==true)
				{
					done_taking_name_input=true;
				}
				else
				{
					throw new WrongNameException("Enter only Letters in Name");
				}
			}
			catch (WrongNameException exp)
			{
				System.out.println(exp);
			}
		}

		users.add(player_name);

		tiles=AssignTiles(number_of_tiles,snakes,crickets,vultures,trampolines,snake_power,cricket_power,vulture_power,trampoline_power,player_name);

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
		String filename=player_name+".txt";
		System.out.println("filename = "+filename);
		
		boolean just_out=false;
		boolean check_1=false;
		boolean check_2=false;
		boolean check_3=false;
		boolean game_end=false;
		while (true)
		{
			ObjectOutputStream out_2=null;
			if (position>((int)number_of_tiles/4) && check_1==false)
			{	
				int option=CheckPointControl_1();
				check_1=true;
				if (option==2)
				{
					RaceTrack racetrack=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)number_of_tiles/2) && check_2==false)
			{	
				int option=CheckPointControl_2();
				check_2=true;
				if (option==2)
				{
					RaceTrack racetrack=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)(3*number_of_tiles)/4) && check_3==false)
			{	
				int option=CheckPointControl_3();
				check_3=true;
				if (option==2)
				{
					RaceTrack racetrack=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}

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
						game_end=true;
						throw new GameWinnerException("You have won the game!!!");
					}
					else
					{
						System.out.println("Trying to shake the Tile-"+position);
					}
				}
				catch(GameWinnerException exp)
				{
					System.out.println(exp);
					break;
				}
				Tile current_tile=deserialize(tiles,position,number_of_tiles,player_name);
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
		if (game_end==true)
		{
			End_Print(player_name,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps);
		}
		else
		{
			System.out.println("If you want to exit the game completely type 'exit', else enter the username of other player");
			while (true)
			{
				String further_run=in.next();
				if (further_run.equals("exit"))
				{
					System.exit(0);
				}
				else
				{
					boolean found=false;
					for (String check_user:users)
					{
						if (check_user.equals(further_run))
						{
							RaceTrack[] now_racetrack=deserializeUser(further_run,0);
							found=true;
							Saved_Game(now_racetrack[0]);
							break;
						}
					}
					if (found==false)
					{
						System.out.println("Sorry please Enter apt. user or input 'exit'");
						System.out.println("Is it that you want new user game?(y or n)");
						String new_user_input=in.next();
						if (new_user_input.equals("y"))
						{
							Assignment.main(null);
						}
					}
					else
					{
						break;
					}
				}
			}
		}
	}	
	public static void isWinner() throws GameWinnerException
	{
		throw new GameWinnerException("Game Won");
	}
	public static void Saved_Game(RaceTrack racetrack) throws IOException,ClassNotFoundException
	{
		Scanner in=new Scanner(System.in);
		ObjectInputStream in_2=null;
		Random randomGenerator=new Random();
		RaceTrack raceTrack=racetrack;
		String player_name=racetrack.player_name;
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		int number_of_tiles=racetrack.number_of_tiles;
		int snakes=racetrack.snakes;
		int crickets=racetrack.crickets;
		int vultures=racetrack.vultures;
		int trampolines=racetrack.trampolines;
		int whites=racetrack.whites;
		int snake_power=racetrack.snake_power;
		int cricket_power=racetrack.cricket_power;
		int vulture_power=racetrack.vulture_power;
		int trampoline_power=racetrack.trampoline_power;
		int number_of_rolls=racetrack.number_of_rolls;
		int snake_bites=racetrack.snake_bites;
		int cricket_bites=racetrack.cricket_bites;
		int vulture_bites=racetrack.vulture_bites;
		int trampoline_jumps=racetrack.trampoline_jumps;
		int position=racetrack.position;
		boolean check_1=racetrack.check_1;
		boolean check_2=racetrack.check_2;
		boolean check_3=racetrack.check_3;
		ArrayList<String> users=racetrack.users;	
		boolean game_end=racetrack.game_end;
		boolean just_out=racetrack.just_out;
		boolean out_of_cage=racetrack.out_of_cage;
		String filename=racetrack.filename;
		
		while (true)
		{
			ObjectOutputStream out_2=null;
			if (position>((int)number_of_tiles/4) && check_1==false)
			{	
				int option=CheckPointControl_1();
				check_1=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)number_of_tiles/2) && check_2==false)
			{	
				int option=CheckPointControl_2();
				check_2=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)(3*number_of_tiles)/4) && check_3==false)
			{	
				int option=CheckPointControl_3();
				check_3=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}

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
						game_end=true;
						throw new GameWinnerException("You have won the game!!!");
					}
					else
					{
						System.out.println("Trying to shake the Tile-"+position);
					}
				}
				catch(GameWinnerException exp)
				{
					System.out.println(exp);
					break;
				}
				Tile current_tile=new White_Tile(0);
				current_tile=deserialize(tiles,position,number_of_tiles,player_name);
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
		if (game_end==true)
		{
			End_Print(player_name,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps);
		}
		else
		{
			System.out.println("If you want to exit the game completely type 'exit', else enter the username of other player");
			while (true)
			{
				String further_run=in.next();
				if (further_run.equals("exit"))
				{
					System.exit(0);
				}
				else
				{
					boolean found=false;
					for (String check_user:users)
					{
						if (check_user.equals(further_run))
						{
							RaceTrack[] now_racetrack2=deserializeUser(further_run,0);
							found=true;
							Saved_Game2(now_racetrack2[0]);
							break;
						}
					}
					if (found==false)
					{
						System.out.println("Sorry please Enter apt. user or input 'exit'");
						System.out.println("Is it that you want new user game?(y or n)");
						String new_user_input=in.next();
						if (new_user_input.equals("y"))
						{
							Assignment.main(null);
						}
					}
					else
					{
						break;
					}
				}
			}
		}
	}
	public static void Saved_Game2(RaceTrack racetrack) throws IOException,ClassNotFoundException
	{
		Scanner in=new Scanner(System.in);
		ObjectInputStream in_2=null;
		Random randomGenerator=new Random();
		RaceTrack raceTrack=racetrack;
		String player_name=racetrack.player_name;
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		int number_of_tiles=racetrack.number_of_tiles;
		int snakes=racetrack.snakes;
		int crickets=racetrack.crickets;
		int vultures=racetrack.vultures;
		int trampolines=racetrack.trampolines;
		int whites=racetrack.whites;
		int snake_power=racetrack.snake_power;
		int cricket_power=racetrack.cricket_power;
		int vulture_power=racetrack.vulture_power;
		int trampoline_power=racetrack.trampoline_power;
		int number_of_rolls=racetrack.number_of_rolls;
		int snake_bites=racetrack.snake_bites;
		int cricket_bites=racetrack.cricket_bites;
		int vulture_bites=racetrack.vulture_bites;
		int trampoline_jumps=racetrack.trampoline_jumps;
		int position=racetrack.position;
		boolean check_1=racetrack.check_1;
		boolean check_2=racetrack.check_2;
		boolean check_3=racetrack.check_3;
		ArrayList<String> users=racetrack.users;	
		boolean game_end=racetrack.game_end;
		boolean just_out=racetrack.just_out;
		boolean out_of_cage=racetrack.out_of_cage;
		String filename=racetrack.filename;
		
		while (true)
		{
			ObjectOutputStream out_2=null;
			if (position>((int)number_of_tiles/4) && check_1==false)
			{	
				int option=CheckPointControl_1();
				check_1=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)number_of_tiles/2) && check_2==false)
			{	
				int option=CheckPointControl_2();
				check_2=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)(3*number_of_tiles)/4) && check_3==false)
			{	
				int option=CheckPointControl_3();
				check_3=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}

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
						game_end=true;
						throw new GameWinnerException("You have won the game!!!");
					}
					else
					{
						System.out.println("Trying to shake the Tile-"+position);
					}
				}
				catch(GameWinnerException exp)
				{
					System.out.println(exp);
					break;
				}
				Tile current_tile=new White_Tile(0);
				current_tile=deserialize(tiles,position,number_of_tiles,player_name);
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
		if (game_end==true)
		{
			End_Print(player_name,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps);
		}
		else
		{
			System.out.println("If you want to exit the game completely type 'exit', else enter the username of other player");
			while (true)
			{
				String further_run=in.next();
				if (further_run.equals("exit"))
				{
					System.exit(0);
				}
				else
				{
					boolean found=false;
					for (String check_user:users)
					{
						if (check_user.equals(further_run))
						{
							RaceTrack[] now_racetrack=deserializeUser(further_run,0);
							found=true;
							Saved_Game3(now_racetrack[0]);
							break;
						}
					}
					if (found==false)
					{
						System.out.println("Sorry please Enter apt. user or input 'exit'");
						System.out.println("Is it that you want new user game?(y or n)");
						String new_user_input=in.next();
						if (new_user_input.equals("y"))
						{
							Assignment.main(null);
						}
					}
					String new_user_input=in.next();
					if (new_user_input.equals("y"))
					{
						Assignment.main(null);
					}
					else
					{
						break;
					}
				}
			}
		}
	}
	public static void Saved_Game3(RaceTrack racetrack) throws IOException,ClassNotFoundException
	{
		Scanner in=new Scanner(System.in);
		ObjectInputStream in_2=null;
		Random randomGenerator=new Random();
		RaceTrack raceTrack=racetrack;
		String player_name=racetrack.player_name;
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		int number_of_tiles=racetrack.number_of_tiles;
		int snakes=racetrack.snakes;
		int crickets=racetrack.crickets;
		int vultures=racetrack.vultures;
		int trampolines=racetrack.trampolines;
		int whites=racetrack.whites;
		int snake_power=racetrack.snake_power;
		int cricket_power=racetrack.cricket_power;
		int vulture_power=racetrack.vulture_power;
		int trampoline_power=racetrack.trampoline_power;
		int number_of_rolls=racetrack.number_of_rolls;
		int snake_bites=racetrack.snake_bites;
		int cricket_bites=racetrack.cricket_bites;
		int vulture_bites=racetrack.vulture_bites;
		int trampoline_jumps=racetrack.trampoline_jumps;
		int position=racetrack.position;
		boolean check_1=racetrack.check_1;
		boolean check_2=racetrack.check_2;
		boolean check_3=racetrack.check_3;
		ArrayList<String> users=racetrack.users;	
		boolean game_end=racetrack.game_end;
		boolean just_out=racetrack.just_out;
		boolean out_of_cage=racetrack.out_of_cage;
		String filename=racetrack.filename;
		
		while (true)
		{
			ObjectOutputStream out_2=null;
			if (position>((int)number_of_tiles/4) && check_1==false)
			{	
				int option=CheckPointControl_1();
				check_1=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)number_of_tiles/2) && check_2==false)
			{	
				int option=CheckPointControl_2();
				check_2=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}
			if (position>((int)(3*number_of_tiles)/4) && check_3==false)
			{	
				int option=CheckPointControl_3();
				check_3=true;
				if (option==2)
				{
					RaceTrack racetrack_2=new RaceTrack(check_1,check_2,check_3,player_name,tiles,number_of_tiles,snakes,crickets,vultures,trampolines,whites,snake_power,cricket_power,vulture_power,trampoline_power,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps,position,users,game_end,just_out,out_of_cage,filename);
					try
					{
						out_2=new ObjectOutputStream(new FileOutputStream(filename));
						out_2.writeObject(racetrack_2);
					}
					finally
					{
						out_2.close();
					}
					break;
				}
				else
				{
					continue;
				}
			}

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
						game_end=true;
						throw new GameWinnerException("You have won the game!!!");
					}
					else
					{
						System.out.println("Trying to shake the Tile-"+position);
					}
				}
				catch(GameWinnerException exp)
				{
					System.out.println(exp);
					break;
				}
				Tile current_tile=new White_Tile(0);
				current_tile=deserialize(tiles,position,number_of_tiles,player_name);
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
		if (game_end==true)
		{
			End_Print(player_name,number_of_rolls,snake_bites,cricket_bites,vulture_bites,trampoline_jumps);
		}
		else
		{
			System.out.println("If you want to exit the game completely type 'exit', else enter the username of other player");
			while (true)
			{
				String further_run=in.next();
				if (further_run.equals("exit"))
				{
					System.exit(0);
				}
				else
				{
					boolean found=false;
					for (String check_user:users)
					{
						if (check_user.equals(further_run))
						{
							RaceTrack[] now_racetrack=deserializeUser(further_run,0);
							found=true;
							break;
						}
					}
					if (found==false)
					{
						System.out.println("Sorry please Enter apt. user or input 'exit'");
						System.out.println("Is it that you want new user game?(y or n)");
						String new_user_input=in.next();
						if (new_user_input.equals("y"))
						{
							Assignment.main(null);
						}
					}
					else
					{
						break;
					}
				}
			}
		}
	}
	public static MyGenericList<Tile> AssignTiles(int number_of_tiles,int snakes,int crickets,int vultures,int trampolines,int snake_power,int cricket_power,int vulture_power,int trampoline_power,String player_name)
	{
		MyGenericList<Tile> tiles=new MyGenericList<Tile>();
		ArrayList<Integer> for_placing=new ArrayList<Integer>();

		String filename=player_name;

		try
		{
			FileOutputStream file=new FileOutputStream(filename);
			ObjectOutputStream out=null;

			try
			{
				out=new ObjectOutputStream(new FileOutputStream(filename));
				for (int i=0;i<number_of_tiles;i++)
				{
					for_placing.add(new Integer(i));
				}
				Collections.shuffle(for_placing);

				for (int i=0;i<snakes;i++)
				{
					int snake_position=for_placing.get(i);
					Tile snake_tile=new Snake_Tile(snake_power,snake_position+1);
					tiles.add(snake_tile);
					out.writeObject(snake_tile);	
				}
				for (int i=snakes;i<snakes+crickets;i++)
				{
					int cricket_position=for_placing.get(i);
					Tile cricket_tile=new Cricket_Tile(cricket_power,cricket_position+1);
					tiles.add(cricket_tile);
					out.writeObject(cricket_tile);
				}
				for (int i=snakes+crickets;i<snakes+crickets+vultures;i++)
				{
					int vulture_position=for_placing.get(i);
					Tile vulture_tile=new Vulture_Tile(vulture_power,vulture_position+1);
					tiles.add(vulture_tile);
					out.writeObject(vulture_tile);
				}
				for (int i=snakes+crickets+vultures;i<snakes+crickets+vultures+trampolines;i++)
				{
					int trampoline_position=for_placing.get(i);
					Tile trampoline_tile=new Trampoline_Tile(trampoline_power,trampoline_position+1);
					tiles.add(trampoline_tile);
					out.writeObject(trampoline_tile);
				}
				for (int i=snakes+crickets+vultures+trampolines;i<number_of_tiles;i++)
				{
					int white_position=for_placing.get(i);
					Tile white_tile=new White_Tile(white_position+1);
					tiles.add(white_tile);
					out.writeObject(white_tile);
				}
			}
			finally
			{
				out.close();
				file.close();
			}
		}
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
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
	public static Tile deserialize(MyGenericList<Tile> tiles,int position,int number_of_tiles,String player_name) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in_2=null;
		Tile tile_of_position=new White_Tile(0);
		try
		{
			in_2=new ObjectInputStream(new FileInputStream(player_name));
			for (int i=0;i<number_of_tiles;i++)
			{
				tile_of_position=(Tile)in_2.readObject();
				if (tile_of_position.getPosition()==position)
					break;
			}
		}
		finally
		{
			in_2.close();
			return tile_of_position;
		}
	}
	public static RaceTrack[] deserializeUser(String username, int flag) throws IOException,ClassNotFoundException
	
	{
		ObjectInputStream in=null;
		String filename=username+".txt";
		try
		{
			in=new ObjectInputStream(new FileInputStream(filename));
			RaceTrack racetrack=(RaceTrack)in.readObject();
			RaceTrack[] a = new RaceTrack[2];
			a[0] = racetrack;	
			if(flag == 1) {
				RaceTrack racetrack1 = racetrack;
				RaceTrack[] arr = new RaceTrack[2];
				arr[0] = racetrack;
				arr[1] = racetrack1;
				return arr;
			}
			return a;
		}
		finally
		{
			in.close();
		}
	} 
	public static void Serializable()
	{

	}
	public static int CheckPointControl_1()
	{
		Scanner in_3=new Scanner(System.in);
		System.out.println("CHECKPOINT 1 has been reached!");
		System.out.println("You can choose to continue or save the current game and exit. (Enter 1 or 2): ");
		int option=0;
		boolean done_taking_option=false;
		while (done_taking_option==false)
		{
			boolean all_digits=true;
			try
			{
				String option_input=in_3.next();
				for (char c: option_input.toCharArray())
				{
					if (Character.isDigit(c)==false)
					{
						all_digits=false;
					}
				}
				if (all_digits==false)
				{
					throw new MyIOException("Enter Integer Value");
				}
				else
				{
					option=Integer.parseInt(option_input);
					done_taking_option=true;
				}
			}
			catch(MyIOException exp)
			{
				System.out.println(exp);
			}
		}
		System.out.println("Chosen option is: "+option);
		return option;
	}
	public static int CheckPointControl_2()
	{
		Scanner in_4=new Scanner(System.in);
		System.out.println("CHECKPOINT 2 has been reached!");
		System.out.println("You can choose to continue or save the current game and exit. (Enter 1 or 2): ");
		int option=0;
		boolean done_taking_option=false;
		while (done_taking_option==false)
		{
			boolean all_digits=true;
			try
			{
				String option_input=in_4.next();
				for (char c: option_input.toCharArray())
				{
					if (Character.isDigit(c)==false)
					{
						all_digits=false;
					}
				}
				if (all_digits==false)
				{
					throw new MyIOException("Enter Integer Value");
				}
				else
				{
					option=Integer.parseInt(option_input);
					done_taking_option=true;
				}
			}
			catch(MyIOException exp)
			{
				System.out.println(exp);
			}
		}
		System.out.println("Chosen option is: "+option);
		return option;
	}
	public static int CheckPointControl_3()
	{
		Scanner in_5=new Scanner(System.in);
		System.out.println("CHECKPOINT 3 has been reached!");
		System.out.println("You can choose to continue or save the current game and exit. (Enter 1 or 2): ");
		int option=0;
		boolean done_taking_option=false;
		while (done_taking_option==false)
		{
			boolean all_digits=true;
			try
			{
				String option_input=in_5.next();
				for (char c: option_input.toCharArray())
				{
					if (Character.isDigit(c)==false)
					{
						all_digits=false;
					}
				}
				if (all_digits==false)
				{
					throw new MyIOException("Enter Integer Value");
				}
				else
				{
					option=Integer.parseInt(option_input);
					done_taking_option=true;
				}
			}
			catch(MyIOException exp)
			{
				System.out.println(exp);
			}
		}
		System.out.println("Chosen option is: "+option);
		return option;
	}
}