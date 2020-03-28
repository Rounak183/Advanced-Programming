import java.util.*;
import java.io.*;
import java.lang.*;

public class Assignment
{	

	// Defining the interface for Display

	public interface in1
	{
		void display();
	}
	
	// Defining Class Item for adding items by merchants 

	public static class Item
	{
		public int index;
		public String Name;
		public double price;
		public int quantity;
		public double discount;
		public String category;

		Item(int index,String Name,double price,int quantity,double discount,String category)
		{
			this.index=index;
			this.Name=Name;
			this.price=price;
			this.quantity=quantity;
			this.discount=discount;
			this.category=category;
		}

		// Display function of the Item Class

		public void display()
		{
			
			//* Forming the String to Display the Discount

			String String_Item_Discount="";
			if (this.discount==0)
			{
				String_Item_Discount="None ";
			}
			else if (this.discount==-1)
			{
				String_Item_Discount="Buy one get one ";
			}
			else
			{
				String_Item_Discount=Double.toString(this.discount)+" % off ";
			}

			// Displaying Item details

			System.out.println(index+" "+Name+" "+price+" "+quantity+" "+String_Item_Discount+category);
		}
	}

	// Main Menu or the initial Menu implementing the interface, used for display

	public static class Initial_Menu implements in1
	{
		public void display()
		{
			System.out.println("Welcome to Mercury");
			System.out.println("1) Enter as Merchant");
			System.out.println("2) Enter as Customer");
			System.out.println("3) See user details");
			System.out.println("4) Company account balance");
			System.out.println("5) Exit");
		}
	}

	// Merchant class Defined 

	public static class Merchant
	{
		public String Name;
		public String Address;
		public double Merchant_Earnings;												// Merchant Earnings
		public double Total_Contributions_Made;											// Contributions made by the merchant to the Company
		public ArrayList<Item> items_of_merchant=new ArrayList<Item>();					// ArrayList containing the items provided by the merchant
		public Merchant_Menu merchant_menu=new Merchant_Menu();							// Merchant Menu initialized
		public int Slots;																// Item slots for the merchant

		public Merchant(String Name,String Address,double Total_Contributions_Made)
		{
			this.Name=Name;
			this.Address=Address;
			this.Total_Contributions_Made=Total_Contributions_Made;
			this.Slots=10;																// Initializing Slots
		}	

		public void display()
		{
			System.out.println("Welcome "+this.Name);
			
			// Merchant Menu display using interface

			merchant_menu.display();
		}

		// Displaying Merchant Details

		public void Display_Merchant_Details(Merchant merchant)
		{
			System.out.println("Merchant's Name: "+merchant.Name);
			System.out.println("Merchant's Address: "+merchant.Address);
			System.out.println("Merchant's Total Earnings: "+merchant.Merchant_Earnings);
			System.out.println("Merchant's Contributions to Company: "+merchant.Total_Contributions_Made);
			System.out.println("The allowed number of Slots of the Merchant: "+merchant.Slots);
			System.out.println("Item of the Merchant: ");

			// Displaying the items

			for (Item i:items_of_merchant)
			{
				i.display();
			}
		}
	}

	// Declaring another class for bought items and cart items

	public static class TakenItem
	{
		public String Name;
		public int quantity;					// Quantity of Item
		public double amount;					// Total amount of item = Quantity*price (both offers considered)
		public String Merchant_Name;			// Merchant Name
		public int bonus;						// Bonus means the buy one get one offer free items

		public TakenItem(String Name,int quantity,double amount,String Merchant_Name,int bonus)
		{
			this.Name=Name;
			this.quantity=quantity;
			this.amount=amount;
			this.Merchant_Name=Merchant_Name;
			this.bonus=bonus;
		}

		public void display(int type)
		{

			// Displaying depending on if the item is bought or still in cart.

			if (type==1)
			{
				System.out.println("Bought item "+this.Name+" quantity: "+this.quantity+" for Rs "+this.amount+" from Merchant "+this.Merchant_Name+" with bonus "+bonus+" items.");
			}
			else
			{
				System.out.println("Cart item "+this.Name+" quantity: "+this.quantity+" for Rs "+this.amount+" from Merchant "+this.Merchant_Name+" with bonus "+bonus+" items.");
			}
		}
	}

	// Defining Customer Class

	public static class Customer
	{
		public String Name;
		public String Address;
		public int No_of_orders;													// No of orders placed by the customer
		public Customer_Menu customer_menu=new Customer_Menu();						// Customer Menu initialized.					
		public double Main_Money;													// Main Account of the Customer
		public double Reward_Money=0;												// Reward Account of the Customer
		public ArrayList<TakenItem> bought_items=new ArrayList<TakenItem>();		// ArrayList for the Bought items
		public ArrayList<TakenItem> cart_items=new ArrayList<TakenItem>();			// ArrayList for the Cart items
		public int count_of_5=0;													// Count maintained for every 5th purchase
		public int Reward_Count=0;													// Keeping count of the number of times reward is earned.

		public Customer(String Name,String Address,int No_of_orders)
		{
			this.Name=Name;
			this.Address=Address;
			this.No_of_orders=No_of_orders;
			this.Main_Money=100;													// Initializing Main Account
		}

		public void display()
		{
			System.out.println("Welcome "+this.Name);
			customer_menu.display();												// Customer Menu displayed using interface
		}

		// Function to display Customer Details

		public void Display_Customer_Details(Customer customer)
		{
			System.out.println("Customer Name: "+this.Name);
			System.out.println("Customer Address: "+this.Address);
			System.out.println("Customer's No. of Orders: "+this.No_of_orders);
			System.out.println("Customer's Main Money: "+this.Main_Money);
			System.out.println("Customer's Reward Money: "+this.Reward_Money);

			// Bought Items by the customer

			System.out.println("Customer's bought items are: ");
			for (TakenItem i: bought_items)
			{
				i.display(1);									// Displayed on the basis of type
			}

			// Cart Items of the customer

			System.out.println("Customer's cart items are: ");
			for (TakenItem i: cart_items)
			{
				i.display(2);									// Displayed on the basis of type
			}
		}
	}

	// Choose Merchant Menu

	public static class Choose_Merchant_Menu implements in1
	{	

		// Method Overriding or Polymorphism implemented

		@Override
		public void display()
		{
			System.out.println("choose merchant");
			System.out.println("1 jack");
			System.out.println("2 john");
			System.out.println("3 james");
			System.out.println("4 jeff");
			System.out.println("5 joseph");
		}
	}

	// Choose Customer Menu

	public static class Choose_Customer_menu implements in1
	{

		// Method Overriding or Polymorphism implemented

		@Override
		public void display()
		{
			System.out.println("choose customer");
			System.out.println("1 ali");
			System.out.println("2 nobby");
			System.out.println("3 bruno");
			System.out.println("4 borat");
			System.out.println("5 aladeen");
		}
	}

	// Merchant Menu Class implementing interface in1

	public static class Merchant_Menu implements in1
	{

		// Method Overriding

		@Override
		public void display()
		{
			System.out.println("Merchant Menu");
			System.out.println("1) Add item");
			System.out.println("2) Edit item");
			System.out.println("3) Search by category");
			System.out.println("4) Add offer");
			System.out.println("5) Rewards won");
			System.out.println("6) Exit");
		}
	}

	// Customer Menu class implementing interface in2

	public static class Customer_Menu implements in1
	{

		// Method Overriding

		@Override
		public void display()
		{
			System.out.println("Customer Menu");
			System.out.println("1) Search item");
			System.out.println("2) checkout cart");
			System.out.println("3) Reward won");
			System.out.println("4) print latest orders");
			System.out.println("5) Exit");
		}
	}

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		
		int item_count=0; 													// Keeping item count to assign unique ids

		double Company_Money=0;

		Initial_Menu inm=new Initial_Menu();								// Initializing main menu 
		Choose_Merchant_Menu merchant_menu=new Choose_Merchant_Menu();		// Initializing Choose_Merchant_Menu
		Choose_Customer_menu customer_menu=new Choose_Customer_menu();		// Initializing Choose_Customer_Menu	

		// Initializing Merchants

		Merchant[] merchants=new Merchant[5];
		merchants[0]=new Merchant("jack","Delhi",0);
		merchants[1]=new Merchant("john","Gurgaon",0);
		merchants[2]=new Merchant("james","Mumbai",0);
		merchants[3]=new Merchant("jeff","Noida",0);
		merchants[4]=new Merchant("joseph","Kolkata",0);

		// Initializing Customers

		Customer[] customers=new Customer[5];
		customers[0]=new Customer("ali","Boston",0);
		customers[1]=new Customer("nobby","New Jersey",0);
		customers[2]=new Customer("bruno","New York",0);
		customers[3]=new Customer("borat","San Fransisco",0);
		customers[4]=new Customer("aladeen","Palo Alto",0);
		
		while (true)														// Works till exit option is opted
		{
			inm.display();
			int n=Integer.parseInt(in.next());								// Taking in the main menu option input
			if (n==1)														// First option merchant 
			{	
				merchant_menu.display();									// Merchant Menu displayed
				int merchant_index=Integer.parseInt(in.next())-1;			// Chosen Merchant				

				while (true)												// Until broken off
				{
					merchants[merchant_index].display();					// Merchant options display

					int merchant_menu_index=Integer.parseInt(in.next())-1;	
					
					if (merchant_menu_index==5)								// Exit option
					{
						break;
					}

					if (merchant_menu_index==0)													// Adding items
					{
						Merchant merchant=merchants[merchant_index];
						if (merchant.items_of_merchant.size()>=merchant.Slots)					// Checking Slot condition
						{
							System.out.println("Sorry, the item slots are full.");
						}
						else
						{

							// Taking item details

							String String_Item_Discount="";
							System.out.println("Enter item details");
							System.out.println("item name:");
							String Item_Name=in.next();
							System.out.println("item price:");
							double Item_Price=Float.parseFloat(in.next());
							System.out.println("item quantity:");
							int Item_Quantity=Integer.parseInt(in.next());
							double Item_Discount=0;
							System.out.println("item category:");
							String Item_Category=in.next();
							int item_index=item_count+1;

							// Creating item object with details

							Item item=new Item(item_index,Item_Name,Item_Price,Item_Quantity,Item_Discount,Item_Category);

							// Adding to merchant's items

							merchants[merchant_index].items_of_merchant.add(item);
							item_count=item_count+1;								// Incrementing item count

							item.display();											// Displaying item after insertion
						}
					}

					if (merchant_menu_index==1)										// Edit item option
					{
						System.out.println("choose item by code");
						int cnt=0;
						String String_Item_Discount="";
						
						// Displaying the items that can be edited

						for (Item i:merchants[merchant_index].items_of_merchant)
						{
							i.display();
						}

						int index_item_tb_edited=Integer.parseInt(in.next());

						System.out.println("Item price: ");
						double edit_Price=Float.parseFloat(in.next());
						System.out.println("Item quantity: ");
						int edit_quantity=Integer.parseInt(in.next());

						Item item_tb_edited=new Item(-1,"",0,0,0,"");

						// Finding item based on the given input

						for (int i=0;i<5;i++)
						{
							Merchant merchant=merchants[i];
							for (Item j: merchant.items_of_merchant)
							{
								if (j.index==index_item_tb_edited)
								{
									item_tb_edited=j;
									break;
								}
							}
						}
						item_tb_edited.price=edit_Price;						// Price edited
						item_tb_edited.quantity=edit_quantity;					// Quantity edited
						
						item_tb_edited.display();								// Edited item displayed
					}

					if (merchant_menu_index==2)									// Printing items of category chosen
					{
						System.out.println("Choose a category");
						String[] categories_done=new String[100];
						for (int i=0;i<100;i++)
						{
							categories_done[i]="";
						}

						// Printing only unique categories

						int count=0;
						for (int i=0;i<merchants[merchant_index].items_of_merchant.size();i++)
						{
							int done=0;
							Item item=merchants[merchant_index].items_of_merchant.get(i);
							for (int j=0;j<categories_done.length;j++)
							{
								if (categories_done[j].equals(item.category))
								{
									done=1;
									break;
								}
							}

							if (done==1)
							{
								continue;
							}
							else
							{
								categories_done[count]=item.category;
								System.out.println(count+1+") "+item.category);	
								count++;
							}
						}

						// Comaparing with the category and printing the items of the chosen category.

						int category_index=Integer.parseInt(in.next())-1;
						String category_tb_compared=categories_done[category_index];
						for (int i=0;i<5;i++)
						{
							Merchant merchant=merchants[i];
							for (int j=0;j<merchant.items_of_merchant.size();j++)
							{
								Item item=merchant.items_of_merchant.get(j);
								if (item.category.equals(category_tb_compared))
								{
									item.display();
								}
							}
						}
					}

					// Adding offers to items

					if (merchant_menu_index==3)
					{
						Item item_tb_edited=merchants[merchant_index].items_of_merchant.get(0);
						System.out.println("choose item by code");
						for (Item i:merchants[merchant_index].items_of_merchant)
						{
							i.display();
						}

						int item_code=Integer.parseInt(in.next());

						System.out.println("choose offer");
						System.out.println("1) buy one get one");
						System.out.println("2) 25% off");

						int chosen_offer=Integer.parseInt(in.next());

						// Getting the item to be edited

						for (int i=0;i<5;i++)
						{
							Merchant merchant=merchants[i];
							for (Item j: merchant.items_of_merchant)
							{
								if (j.index==item_code)
								{
									item_tb_edited=j;
								}
							}
						}

						// Applying the offer

						if (chosen_offer==2)
						{
							item_tb_edited.discount=25;
						}
						else
						{
							item_tb_edited.discount=-1;
						}

						item_tb_edited.display();		// Displaying the item
					}

					if (merchant_menu_index==4)
					{
						Merchant merchant=merchants[merchant_index];
						int additional_slots=(int)(merchant.Total_Contributions_Made/100);
						System.out.println("The addtional slots earned are: "+additional_slots);
					}
				}
			}

			// Exit

			if (n==5)
			{
				System.exit(0);
			}

			if (n==2)
			{
				customer_menu.display();
				int customer_index=Integer.parseInt(in.next())-1;

				while (true)
				{
					customers[customer_index].display();

					int customer_menu_index=Integer.parseInt(in.next())-1;
					
					if (customer_menu_index==0)
					{
						System.out.println("Choose a category");
						String[] categories_done=new String[100];
						for (int i=0;i<100;i++)
						{
							categories_done[i]="";
						}
						int count=0;
						for (int i=0;i<5;i++)
						{
							int done=0;
							Merchant merchant=merchants[i];
							for (Item j:merchant.items_of_merchant)
							{
								for (int k=0;k<100;k++)
								{
									if (j.category.equals(categories_done[k]))
									{
										done=1;
										break;
									}
								}

								if (done==1)
								{
									continue;
								}
								else
								{
									categories_done[count]=j.category;
									System.out.println(count+1+") "+j.category);
									count++;
								}
							}
						}
						int category_index=Integer.parseInt(in.next())-1;
						String category_tb_compared=categories_done[category_index];

						System.out.println("choose item by code");

						for (int i=0;i<5;i++)
						{
							Merchant merchant=merchants[i];
							for (Item j:merchant.items_of_merchant)
							{
								if (j.category.equals(category_tb_compared))
								{
									j.display();
								}	
							}
						}

						System.out.println("Enter item code");
						int item_code=Integer.parseInt(in.next());

						Item item=new Item(-1,"",-1,-1,-1,"");

						Merchant items_merchant=merchants[0];
						for (int i=0;i<5;i++)
						{
							Merchant merchant=merchants[i];
							for (Item j:merchant.items_of_merchant)
							{
								if (j.index==item_code)
								{
									item=j;
									items_merchant=merchant;
								}
							}
						}

						//item.display();

						System.out.println("Enter item quantity");
						int item_quantity=Integer.parseInt(in.next());

						double total_cost=0;
						double discount=0;
						int bonus=0;
						if (item_quantity>item.quantity)
						{
							System.out.println("Stock not available.");
							break;
						}
						else
						{
							if (item.discount==-1)
							{
								if (item_quantity%2==0)
								{
									total_cost=(item_quantity/2)*item.price;
								}
								else
								{
									total_cost=((int)(item_quantity/2)+1)*item.price;
								}
								bonus=item_quantity/2;
							}
							else
							{
								total_cost=item_quantity*item.price;
								discount=total_cost*((item.discount)/100);
								total_cost=total_cost-discount;
							}	
						}

						System.out.println("Choose method of transaction");
						System.out.println("1) Buy item");
						System.out.println("2) Add item to cart");
						System.out.println("3) Exit");

						int method_of_transaction=Integer.parseInt(in.next());

						if (method_of_transaction==1)
						{
							Customer customer=customers[customer_index];
							if (customer.Main_Money+customer.Reward_Money<total_cost)
							{
								System.out.println("Sorry, you have insufficient funds.");
							}
							else
							{
								if (total_cost>customer.Main_Money)
								{
									double left_after_deduction_from_Main_Money=total_cost-customer.Main_Money;
									customer.Reward_Money=customer.Reward_Money-left_after_deduction_from_Main_Money;
									customer.Main_Money=0;
								}
								else
								{
									customer.Main_Money=customer.Main_Money-total_cost;
								}

								item.quantity=item.quantity-(item_quantity);
								TakenItem bought_item=new TakenItem(item.Name,item_quantity,total_cost,items_merchant.Name,bonus);
								customer.bought_items.add(bought_item);
								customer.No_of_orders+=1;
								items_merchant.Merchant_Earnings=items_merchant.Merchant_Earnings+total_cost;
								items_merchant.Total_Contributions_Made=items_merchant.Total_Contributions_Made+total_cost*(0.5/100);
								if (items_merchant.Total_Contributions_Made>=100)
								{
									int additional_slots=(int)(items_merchant.Total_Contributions_Made/100);
									items_merchant.Slots+=additional_slots;
								}
								Company_Money+=(0.01)*total_cost;
								System.out.println("Item Successfully bought");
							}
							customer.count_of_5=customer.count_of_5+1;
							if (customer.count_of_5==5)
							{
								customer.Reward_Money+=10;
								customer.Reward_Count+=1;
								customer.count_of_5=0;
							}
						}

						else if (method_of_transaction==2)
						{
							Customer customer=customers[customer_index];
							item.quantity=item.quantity-(item_quantity);
							TakenItem cart_item=new TakenItem(item.Name,item_quantity,total_cost,items_merchant.Name,bonus);
							customer.cart_items.add(cart_item);
							System.out.println("Item Successfully added to cart");
						}

						else
						{
							break;
						}
					}
					
					if (customer_menu_index==1)
					{
						Customer customer=customers[customer_index];
						for (int rev_index=customer.cart_items.size()-1;rev_index>=0;rev_index--)
						{
							TakenItem cart_item=customer.cart_items.get(rev_index);
							double total_cost=cart_item.amount;
							if (customer.Main_Money+customer.Reward_Money<total_cost)
							{
								System.out.println("Sorry you have insufficient funds.");
							}
							else
							{
								if (total_cost>customer.Main_Money)
								{
									double left_after_deduction_from_Main_Money=total_cost-customer.Main_Money;
									customer.Reward_Money=customer.Reward_Money-left_after_deduction_from_Main_Money;
									customer.Main_Money=0;
								}
								else
								{
									customer.Main_Money=customer.Main_Money-total_cost;
								}
								customer.bought_items.add(cart_item);
								customer.No_of_orders+=1;
								String cart_item_Merchant_Name=cart_item.Merchant_Name;

								Merchant cart_item_Merchant=merchants[0];
								
								for (int i=0;i<5;i++)
								{
									if (merchants[i].Name.equals(cart_item_Merchant_Name))
									{
										cart_item_Merchant=merchants[i];
										break;
									}
								}

								cart_item_Merchant.Merchant_Earnings+=total_cost;
								cart_item_Merchant.Total_Contributions_Made+=total_cost*(0.5/100);
								if (cart_item_Merchant.Total_Contributions_Made>=100)
								{
									int additional_slots=(int)(cart_item_Merchant.Total_Contributions_Made/100);
									cart_item_Merchant.Slots+=additional_slots;
								}
								Company_Money+=(0.01)*total_cost;
								System.out.println("Item "+cart_item.Name+" has been bought from the cart");
							}
						}
					}

					if (customer_menu_index==4)
					{
						break;
					}

					if (customer_menu_index==3)
					{
						Customer customer=customers[customer_index];
						for (int i=customer.bought_items.size()-10;i<customer.bought_items.size();i++)
						{
							if (i>=0)
							{
								TakenItem item=customer.bought_items.get(i);
								item.display(1);
							}
						}
					}

					if (customer_menu_index==2)
					{
						Customer customer=customers[customer_index];
						double Total_Reward=(customer.Reward_Count)*10;
						double Reward_Left=(customer.Reward_Money);
						System.out.println("The Total Reward earned: "+Total_Reward);
						System.out.println("The Total Reward left: "+Reward_Left);
					}
				}
			}

			if (n==3)
			{
				String type=in.next();
				int index=Integer.parseInt(in.next())-1;
				if (type.equals("M"))
				{
					merchants[index].Display_Merchant_Details(merchants[index]);
				}
				else
				{
					customers[index].Display_Customer_Details(customers[index]);
				}
			}

			if (n==4)
			{
				System.out.println("The Company's account balance is: "+Company_Money);
			}
		}	
	}
}