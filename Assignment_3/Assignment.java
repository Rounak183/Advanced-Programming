import java.lang.*;
import java.util.*;
import java.io.*;

class GameControl
{
	protected final void Display()
	{
		System.out.println("Welcome to ArchLegends");
		System.out.println("Choose your option");
		System.out.println("1) New User");
		System.out.println("2) Existing User");
		System.out.println("3) Exit");
	}
	protected final void HeroListDisplay()
	{
		System.out.println("1) Warrior");
		System.out.println("2) Thief");
		System.out.println("3) Mage");
		System.out.println("4) Healer");
	}	
	protected final String return_Hero_Type(int index)
	{
		if (index==1)
		{
			return "Warrior";
		}
		else if (index==2)
		{
			return "Thief";
		}
		else if (index==3)
		{
			return "Mage";
		}
		else 
		{
			return "Healer";
		}
	}
	protected final void DisplayStartPosition()
	{
		System.out.println("You are at the starting location. Choose path: ");
		System.out.println("1) Go to location 1");
		System.out.println("2) Go to location 2");
		System.out.println("3) Go to location 3");
		System.out.println("Enter -1 to exit");
	}
	protected final void DisplayPosition_1()
	{
		System.out.println("You are at location 1. Choose path: ");
		System.out.println("1) Go back to location 0");
		System.out.println("2) Go to location 2");
		System.out.println("3) Go to location 4");
		System.out.println("Enter -1 to exit");
	}
	protected final void DisplayPosition_2()
	{
		System.out.println("You are at location 2. Choose path: ");
		System.out.println("1) Go back to location 0");
		System.out.println("2) Go to location 4");
		System.out.println("3) Go to location 5");
		System.out.println("Enter -1 to eixt");
	}
	protected final void DisplayPosition_3()
	{
		System.out.println("You are at location 3. Choose path: ");
		System.out.println("1) Go back to location 0");
		System.out.println("2) Go to location 1");
		System.out.println("3) Go to location 2");
		System.out.println("Enter -1 to exit");
	}
	protected final void DisplayPosition_4()
	{
		System.out.println("You are at location 4. Choose path: ");
		System.out.println("1) Go back to location 1");
		System.out.println("2) Go back to location 2");
		System.out.println("3) Go to location 5");
		System.out.println("4) Go to location 6");
		System.out.println("Enter -1 to exit");
	}
	protected final void DisplayPosition_5()
	{
		System.out.println("You are at location 5. Choose path: ");
		System.out.println("1) Go back to postion 2");
		System.out.println("2) Go to position 4");
		System.out.println("3) Go to position 6");
		System.out.println("Enter -1 to exit");
	}	
	protected final void DisplayPosition_6()
	{
		System.out.println("You are at location 6. Choose path: ");
		System.out.println("1) Go back to location 4");
		System.out.println("2) Go back to location 5");
		System.out.println("3) Go to location 7");
	}
	protected final void DisplayPosition_7()
	{
		System.out.println("You are at the location of LionFang.");
	}
}

class Hero
{
	private int HP;
	private int level;
	private int XP;
	private int Attack;
	private int Defense;
	private int moves;
	private final String Name="";
	private final String type="";

	protected static void Choose_Move_Menu(Hero hero)
	{
		int moves=hero.getMoves();
		if (moves>=3)
		{
			System.out.println("Choose move: ");
			System.out.println("1) Attack");
			System.out.println("2) Defense");
			System.out.println("3) Special Attack");
		}
		else
		{
			System.out.println("Choose move: ");
			System.out.println("1) Attack");
			System.out.println("2) Defense");
		}
	}

	protected void setLevel(int level)
	{
		this.level=level;
	}
	protected void setAttack(int Attack)
	{
		this.Attack=Attack;
	}
	protected void setDefense(int Defense)
	{
		this.Defense=Defense;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void setXP(int XP)
	{
		this.XP=XP;
	}
	protected void setMoves(int moves)
	{
		this.moves=moves;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getAttack()
	{
		return this.Attack;
	}
	protected int getDefense()
	{
		return this.Defense;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getXP()
	{
		return this.XP;
	}
	protected int getMoves()
	{
		return this.moves;
	}
	protected String getName()
	{
		return this.Name;
	}
	protected String getType()
	{
		return this.type;
	}
	protected void Display()
	{
	}			
}

class Warrior extends Hero
{
	private int HP;
	private int level;
	private int XP;
	private int Attack;
	private int Defense;
	private int moves;
	private final String type;
	private final String Name;	

	public Warrior(String type,String Name)
	{
		this.type=type;
		this.Name=Name;
		this.HP=100;
		this.XP=0;
		this.level=1;
		this.moves=0;
		this.Attack=10;
		this.Defense=3;		
	}
	protected void setLevel(int level)
	{
		this.level=level;
	}
	protected void setAttack(int Attack)
	{
		this.Attack=Attack;
	}
	protected void setDefense(int Defense)
	{
		this.Defense=Defense;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void setXP(int XP)
	{
		this.XP=XP;
	}
	protected void setMoves(int moves)
	{
		this.moves=moves;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getAttack()
	{
		return this.Attack;
	}
	protected int getDefense()
	{
		return this.Defense;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getXP()
	{
		return this.XP;
	}
	protected int getMoves()
	{
		return this.moves;
	}
	protected String getName()
	{
		return this.Name;
	}
	protected String getType()
	{
		return this.type;
	}
	protected void Display()
	{
		System.out.println("User's Name: "+this.Name);
		System.out.println("Hero's HP = "+this.HP);
		System.out.println("Hero's XP = "+this.XP);
		System.out.println("Hero's level = "+this.level);
		System.out.println("Hero's Attack = "+this.Attack);
		System.out.println("Hero's Defense = "+this.Defense);
		System.out.println("Hero's current moves = "+this.moves);
		System.out.println("Hero's type = "+this.type);
	}
}

class Thief extends Hero
{
	private int HP;
	private int level;
	private int XP;
	private int Attack;
	private int Defense;
	private int moves;
	private final String type;
	private final String Name;

	public Thief(String type,String Name)
	{
		this.type=type;
		this.Name=Name;
		this.HP=100;
		this.XP=0;
		this.level=1;
		this.moves=0;
		this.Attack=6;
		this.Defense=4;
	}

	protected void setLevel(int level)
	{
		this.level=level;
	}
	protected void setAttack(int Attack)
	{
		this.Attack=Attack;
	}
	protected void setDefense(int Defense)
	{
		this.Defense=Defense;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void setXP(int XP)
	{
		this.XP=XP;
	}
	protected void setMoves(int moves)
	{
		this.moves=moves;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getAttack()
	{
		return this.Attack;
	}
	protected int getDefense()
	{
		return this.Defense;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getXP()
	{
		return this.XP;
	}
	protected int getMoves()
	{
		return this.moves;
	}
	protected String getName()
	{
		return this.Name;
	}
	protected String getType()
	{
		return this.type;
	}
	protected void Display()
	{
		System.out.println("User's Name: "+this.Name);
		System.out.println("Hero's HP = "+this.HP);
		System.out.println("Hero's XP = "+this.XP);
		System.out.println("Hero's level = "+this.level);
		System.out.println("Hero's Attack = "+this.Attack);
		System.out.println("Hero's Defense = "+this.Defense);
		System.out.println("Hero's current moves = "+this.moves);
		System.out.println("Hero's type = "+this.type);
	}
}

class Mage extends Hero
{
	private int HP;
	private int level;
	private int XP;
	private int Attack;
	private int Defense;
	private int moves;
	private final String type;
	private final String Name;

	public Mage(String type,String Name)
	{
		this.type=type;
		this.Name=Name;
		this.HP=100;
		this.XP=0;
		this.level=1;
		this.moves=0;
		this.Attack=5;
		this.Defense=5;
	}

	protected void setLevel(int level)
	{
		this.level=level;
	}
	protected void setAttack(int Attack)
	{
		this.Attack=Attack;
	}
	protected void setDefense(int Defense)
	{
		this.Defense=Defense;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void setXP(int XP)
	{
		this.XP=XP;
	}
	protected void setMoves(int moves)
	{
		this.moves=moves;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getAttack()
	{
		return this.Attack;
	}
	protected int getDefense()
	{
		return this.Defense;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getXP()
	{
		return this.XP;
	}
	protected int getMoves()
	{
		return this.moves;
	}
	protected String getName()
	{
		return this.Name;
	}
	protected String getType()
	{
		return this.type;
	}
	protected void Display()
	{
		System.out.println("User's Name: "+this.Name);
		System.out.println("Hero's HP = "+this.HP);
		System.out.println("Hero's XP = "+this.XP);
		System.out.println("Hero's level = "+this.level);
		System.out.println("Hero's Attack = "+this.Attack);
		System.out.println("Hero's Defense = "+this.Defense);
		System.out.println("Hero's current moves = "+this.moves);
		System.out.println("Hero's type = "+this.type);
	}
}

class Healer extends Hero
{
	private int HP;
	private int level;
	private int XP;
	private int Attack;
	private int Defense;
	private int moves;
	private final String type;
	private final String Name;

	public Healer(String type,String Name)
	{
		this.type=type;
		this.Name=Name;
		this.HP=100;
		this.XP=0;
		this.level=1;
		this.moves=0;
		this.Attack=4;
		this.Defense=8;
	}

	protected void setLevel(int level)
	{
		this.level=level;
	}
	protected void setAttack(int Attack)
	{
		this.Attack=Attack;
	}
	protected void setDefense(int Defense)
	{
		this.Defense=Defense;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void setXP(int XP)
	{
		this.XP=XP;
	}
	protected void setMoves(int moves)
	{
		this.moves=moves;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getAttack()
	{
		return this.Attack;
	}
	protected int getDefense()
	{
		return this.Defense;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getXP()
	{
		return this.XP;
	}
	protected int getMoves()
	{
		return this.moves;
	}
	protected String getName()
	{
		return this.Name;
	}	
	protected String getType()
	{
		return this.type;
	}
	protected void Display()
	{
		System.out.println("User's Name: "+this.Name);
		System.out.println("Hero's HP = "+this.HP);
		System.out.println("Hero's XP = "+this.XP);
		System.out.println("Hero's level = "+this.level);
		System.out.println("Hero's Attack = "+this.Attack);
		System.out.println("Hero's Defense = "+this.Defense);
		System.out.println("Hero's current moves = "+this.moves);
		System.out.println("Hero's type = "+this.type);
	}
}

class Monster
{
	private final int level=0;
	private int HP;
	private final int location=0;

	protected int getLevel()
	{
		return this.level;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getLocation()
	{
		return this.location;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void Display()
	{}
}

class Level_12_Monster extends Monster
{
	private final int level;
	private int HP;
	private final int location;

	public Level_12_Monster(int level,int location)
	{
		this.level=level;
		this.location=location;
		this.HP=100;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getLocation()
	{
		return this.location;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void Display()
	{
		System.out.println("Monster level: "+this.level);
		System.out.println("Monster HP: "+this.HP);
		System.out.println("Monster Location: "+this.location);
	}
}

class Level_3_Monster extends Monster
{
	private final int level;
	private int HP;
	private final int location;

	public Level_3_Monster(int level,int location)
	{
		this.level=level;
		this.location=location;
		this.HP=200;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getLocation()
	{
		return this.location;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void Display()
	{
		System.out.println("Monster level: "+this.level);
		System.out.println("Monster HP: "+this.HP);
		System.out.println("Monster Location: "+this.location);
	}
}

class LionFang extends Monster
{
	private final int level;
	private int HP;
	private final int location;

	public LionFang(int level,int location)
	{
		this.level=level;
		this.location=location;
		this.HP=250;
	}
	protected int getLevel()
	{
		return this.level;
	}
	protected int getHP()
	{
		return this.HP;
	}
	protected int getLocation()
	{
		return this.location;
	}
	protected void setHP(int HP)
	{
		this.HP=HP;
	}
	protected void Display()
	{
		System.out.println("Monster level: "+this.level);
		System.out.println("Monster HP: "+this.HP);
		System.out.println("Monster Location: "+this.location);
	}
}

class Assignment
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		GameControl game_control=new GameControl();					// Initializing Game Start Class
		ArrayList<Hero> heros=new ArrayList<Hero>();
		ArrayList<Monster> monsters=new ArrayList<Monster>();
		Random rand=new Random();
	
		int[] locations=new int[8];
		for (int i=1;i<7;i++)
		{
			int random_level=rand.nextInt(3)+1;
			if (random_level==1 || random_level==2)
			{
				Level_12_Monster new_monster=new Level_12_Monster(random_level,i);
				monsters.add(new_monster);
			}
			else
			{
				Level_3_Monster new_monster=new Level_3_Monster(random_level,i);
				monsters.add(new_monster);
			}
		}
		LionFang lionfang=new LionFang(4,7);
		monsters.add(lionfang);

		for (Monster monster: monsters)
		{
			monster.Display();
		}

		while (true)
		{
			boolean game_won=false;
			game_control.Display();
			int n=Integer.parseInt(in.next());						// Taking input the from the GameControl Menu
			if (n==3)
			{	
				System.exit(0);
			}
			else if (n==1)
			{
				System.out.println("Enter Username");
				String username=in.next();
				System.out.println("Choose a Hero");
				game_control.HeroListDisplay();
				int user_list_index=Integer.parseInt(in.next());
				String Hero_Type=game_control.return_Hero_Type(user_list_index);

				if (user_list_index==1)
				{
					Warrior new_hero=new Warrior("Warrior",username);
					heros.add(new_hero);
				}
				else if (user_list_index==2)
				{
					Thief new_hero=new Thief("Thief",username);
					heros.add(new_hero);
				}
				else if (user_list_index==3)
				{
					Mage new_hero=new Mage("Mage",username);
					heros.add(new_hero);
				}
				else
				{
					Healer new_hero=new Healer("Healer",username);
					heros.add(new_hero);
				}
				
				System.out.println("User Creation done. Username: "+username+". Hero type: "+Hero_Type+". Log in to play the game. Exiting");		// Hero Registered.
			}
			else 
			{
				System.out.println("Enter Username");
				String username=in.next();
				int found=0;
				Hero Play_Hero=heros.get(0);
				for (Hero hero: heros)
				{
					String hero_type=hero.getType();
					String hero_name=hero.getName();
					if (hero_type.equals("Warrior"))
						hero=new Warrior("Warrior",hero_name);
					else if (hero_type.equals("Thief"))
						hero=new Thief("Thief",hero_name);
					else if (hero_type.equals("Mage"))
						hero=new Mage("Mage",hero_name);
					else
						hero=new Healer("Healer",hero_name);
					if (hero.getName().equals(username))
					{
						System.out.println("User Found... logging in");
						

						System.out.println("Your details are: ");			
						hero.Display();
						Play_Hero=hero;
						found=1;
						break;
					}
				}
				if (found==0)
				{
					System.out.println("Sorry, user not found. Exiting");
					continue;
				}	
				int current_location=0;
				boolean just_start=true;
				int chosen_option=0;
				while (true)
				{	
					if (game_won==true)
						break;
					if (just_start==true)
					{
						game_control.DisplayStartPosition();
						chosen_option=Integer.parseInt(in.next());
						just_start=false;
					}
					else
					{
						if (chosen_option==0)
							game_control.DisplayStartPosition();
						else if (chosen_option==1)
							game_control.DisplayPosition_1();
						else if (chosen_option==2)
							game_control.DisplayPosition_2();
						else if (chosen_option==3)
							game_control.DisplayPosition_3();
						else if (chosen_option==4)
							game_control.DisplayPosition_4();
						else if (chosen_option==5)
							game_control.DisplayPosition_5();
						else if (chosen_option==6)
							game_control.DisplayPosition_6();
						else if (chosen_option==7) 
							game_control.DisplayPosition_7();
						else
							System.out.println("");
						chosen_option=Integer.parseInt(in.next());
					}
					if (chosen_option==-1)
						break;
					if (chosen_option==0)
					{
						continue;
					}
					Monster monster=monsters.get(chosen_option-1);
					System.out.println("Moving to location "+chosen_option+".");
					int Monster_Level=monster.getLevel();
					if (chosen_option==7)
					{
						System.out.println("You are at the location of LionFang");
					}
					System.out.println("Fight Started. You're fighting a level "+Monster_Level+" Monster");
					boolean special_move_on=false;
					int special_attack_times=0;

					while (true)
					{
						Hero.Choose_Move_Menu(Play_Hero);
						int chosen_move=Integer.parseInt(in.next());
						if (game_won==true)
							break;

						if (chosen_move==-1)
							break;
						if (chosen_move==1)
						{
							System.out.println("You choose to attack");
							System.out.println("You attacked and inflicted "+Play_Hero.getAttack()+" damage to the monster.");
							monster.setHP(monster.getHP()-Play_Hero.getAttack());
							if (monster.getHP()<0)
								monster.setHP(0);
							System.out.println("Your Hp: "+Play_Hero.getHP()+" Monsters Hp: "+monster.getHP());
							if (special_move_on==true)
							{
								special_attack_times+=1;
								if (Play_Hero.getType().equals("Mage"))
								{
									int monster_HP=monster.getHP();
									monster.setHP((int)(monster_HP*0.95));
									System.out.println("Monster's HP is reduced");
									System.out.println("Monster's HP now = "+monster.getHP());
								}
								if (Play_Hero.getType().equals("Healer"))
								{
									int Hero_HP=Play_Hero.getHP();
									Play_Hero.setHP((int)(Hero_HP*1.05));
									System.out.println("Healer's HP incremented");
									System.out.println("Healer's HP now = "+Play_Hero.getHP());
								}
							}
							if (special_attack_times==3)
							{
								special_move_on=false;
								special_attack_times=0;
								System.out.println("Special Attack wearing off.");
								if (Play_Hero.getType().equals("Warrior"))
								{
									Play_Hero.setAttack(Play_Hero.getAttack()-5);
									Play_Hero.setDefense(Play_Hero.getDefense()-5);
									System.out.println("Warrior's Attack now set to: "+Play_Hero.getAttack());
									System.out.println("Warrior's Defense now set to: "+Play_Hero.getDefense());
								}
							}
							Play_Hero.setMoves(Play_Hero.getMoves()+1);
						}
						else if (chosen_move==2)
						{
							System.out.println("You choose to defend");
							System.out.println("Monster attack reduced by "+Play_Hero.getDefense()+"!");
							if (special_move_on==true)
							{
								special_attack_times+=1;
								if (Play_Hero.getType().equals("Mage"))
								{
									int monster_HP=monster.getHP();
									monster.setHP((int)(monster_HP*0.95));
									System.out.println("Monster's HP is reduced");
									System.out.println("Monster's HP now = "+monster.getHP());
								}
								if (Play_Hero.getType().equals("Healer"))
								{
									int Hero_HP=Play_Hero.getHP();
									Play_Hero.setHP((int)(Hero_HP*1.05));
									System.out.println("Healer's HP incremented");
									System.out.println("Healer's HP now = "+Play_Hero.getHP());
								}
							}
							if (special_attack_times==3)
							{
								special_move_on=false;
								special_attack_times=0;
								System.out.println("Special Attack wearing off");
								if (Play_Hero.getType().equals("Warrior"))
								{
									Play_Hero.setAttack(Play_Hero.getAttack()-5);
									Play_Hero.setDefense(Play_Hero.getDefense()-5);
									System.out.println("Warrior's Attack now set to: "+Play_Hero.getAttack());
									System.out.println("Warrior's Defense now set to: "+Play_Hero.getDefense());
								}
							}
							Play_Hero.setMoves(Play_Hero.getMoves()+1);
						}
						else
						{
							System.out.println("Special power activated");
							System.out.println("Performing special attack");
							String Hero_Type=Play_Hero.getType();
							special_move_on=true;
							Play_Hero.setMoves(0);
							if (Hero_Type.equals("Warrior"))
							{
								Play_Hero.setAttack(Play_Hero.getAttack()+5);
								Play_Hero.setDefense(Play_Hero.getDefense()+5);
								System.out.println("Attack and Defense upgraded by 5 for Warrior");
								System.out.println("Warrior's attack = "+Play_Hero.getAttack());
								System.out.println("Warrior's Defense = "+Play_Hero.getDefense());
							}
							if (Play_Hero.getType().equals("Thief"))
							{
								int Monster_HP=monster.getHP();
								int HP_Hero_TB_Incremented=(int)(Monster_HP*0.3);
								monster.setHP(Monster_HP-HP_Hero_TB_Incremented);
								int Hero_HP=Play_Hero.getHP();
								int current_level=Play_Hero.getLevel();
								if (current_level==1)
								{
									if (Hero_HP+HP_Hero_TB_Incremented>100)
										Play_Hero.setHP(100);
									else
										Play_Hero.setHP(Play_Hero.getHP()+HP_Hero_TB_Incremented);
								}
								else if (current_level==2)
								{
									if (Hero_HP+HP_Hero_TB_Incremented>150)
										Play_Hero.setHP(150);
									else
										Play_Hero.setHP(Play_Hero.getHP()+HP_Hero_TB_Incremented);
								}
								else if (current_level==3)
								{
									if (Hero_HP+HP_Hero_TB_Incremented>200)
										Play_Hero.setHP(200);
									else
										Play_Hero.setHP(Play_Hero.getHP()+HP_Hero_TB_Incremented);	
								}
								else
								{
									if (Hero_HP+HP_Hero_TB_Incremented>250)
										Play_Hero.setHP(250);
									else
										Play_Hero.setHP(Play_Hero.getHP()+HP_Hero_TB_Incremented);	
								}
								System.out.println("The Thief stole Monster's HP");
								System.out.println("The Thief's HP now = "+Play_Hero.getHP());
								System.out.println("The Monster's HP now = "+monster.getHP());
							}
						}

						if (monster.getHP()<=0)
						{
							System.out.println("Your Hp: "+Play_Hero.getHP()+" Monsters Hp: "+monster.getHP());
							System.out.println("Monster killed!");
							int XP_Awarded=(monster.getLevel())*20;
							System.out.println(XP_Awarded+" XP awarded");
							Play_Hero.setXP(Play_Hero.getXP()+XP_Awarded);
							int current_level=Play_Hero.getLevel();
							boolean level_up_allowed=false;
							if (current_level==1)
							{
								if (Play_Hero.getXP()>=20)
									level_up_allowed=true;
							}
							if (current_level==2)
							{
								if (Play_Hero.getXP()>=40)
									level_up_allowed=true;
							}
							if (current_level==3)
							{
								if (Play_Hero.getXP()>=60)
									level_up_allowed=true;
							}
							if (level_up_allowed==true)
							{
								int present_level=Play_Hero.getLevel();
								System.out.println("Level Up: level: "+(present_level+1));
								Play_Hero.setLevel(present_level+1);
								Play_Hero.setAttack(Play_Hero.getAttack()+1);
								Play_Hero.setDefense(Play_Hero.getDefense()+1);
							}
							if (Play_Hero.getLevel()==1)
							{
								Play_Hero.setHP(100);
							}
							else if (Play_Hero.getLevel()==2)
							{
								Play_Hero.setHP(150);
							}
							else if (Play_Hero.getLevel()==3)
							{
								Play_Hero.setHP(200);
							}
							else
							{
								Play_Hero.setHP(250);
							}
							Play_Hero.setMoves(0);

							if (monster.getLevel()==4)
							{
								monster.setHP(250);
								System.out.println("You have won the game!!");
								game_won=true;
								break;
							}
							System.out.println("Fight Won proceed to the next location.");
							if (monster.getLevel()==3)
							{
								monster.setHP(200);
							}
							else if (monster.getLevel()==2 || monster.getLevel()==1)
							{
								monster.setHP(100);
							}
							else
							{
								monster.setHP(250);
							}

							if (Play_Hero.getType().equals("Warrior"))
							{
								if (special_attack_times>0)
								{
									Play_Hero.setAttack(10+Play_Hero.getLevel()-1);
									Play_Hero.setDefense(3+Play_Hero.getLevel()-1);
								}
							}
							special_move_on=false;
							special_attack_times=0;
							Play_Hero.Display();
							break;
						}

						System.out.println("Monster attack!");
						int current_health=Play_Hero.getHP();
						int max_monster_damage=(int)(current_health/4);
					
						double value=(rand.nextGaussian());
						double scaled_value=value+3;
						double factor=scaled_value/6;
						
						int monster_damage=(int)(factor*max_monster_damage);
						monster_damage=monster_damage-Play_Hero.getDefense();
						if (monster_damage<0)
							monster_damage=0;

						if (monster.getLevel()==4)
						{
							double d=Math.random();
							if (d<=0.1)
							{
								if (current_health%2==0)
									monster_damage=(int)(current_health/2);
								else
									monster_damage=(int)(current_health/2)+1;
							}
						}
						Play_Hero.setHP(current_health-monster_damage);
						System.out.println("The monster attacked and inflicted "+monster_damage+" damage to you.");
						System.out.println("Your Hp: "+Play_Hero.getHP()+" Monsters Hp: "+monster.getHP());
						if (Play_Hero.getHP()<=0)
						{
							System.out.println("Sorry, you died. Sending you back to the initial position. You can always quit the game.");
							String Hero_Type=Play_Hero.getType();
							String Hero_Name=Play_Hero.getName();
							if (Hero_Type.equals("Warrior"))
								Play_Hero=new Warrior("Warrior",Hero_Name);
							else if (Hero_Type=="Thief")
								Play_Hero=new Thief("Thief",Hero_Name);
							else if (Hero_Type=="Mage")
								Play_Hero=new Mage("Mage",Hero_Name);
							else 
								Play_Hero=new Healer("Healer",Hero_Name);
							just_start=true;
							break;
						}
					}
				}		
			}
		}
	}
}