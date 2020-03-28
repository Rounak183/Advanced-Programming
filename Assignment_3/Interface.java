public class Interface
{
	public interface Transporter
	{
		public void move();
		//public void Display();						// Not allowed
	}

	public static class Car implements Transporter
	{
		public Car()
		{}

		public void move()
		{
			System.out.println("Car is moving");
		}
		/*public void Display()
		{
			System.out.println("Car Display");
		}*/
	}

	public static class Bike implements Transporter
	{
		public Bike()
		{}

		public void move()
		{
			System.out.println("Bike is moving");
		}
	}

	public static void main(String[] args)
	{
		Car car=new Car();
		car.move();

		Bike bike=new Bike();
		bike.move();
	}
}