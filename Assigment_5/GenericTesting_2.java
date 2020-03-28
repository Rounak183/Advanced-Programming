class Pair<T1,T2>
{
	private T1 key;
	private T2 value;
	public Pair(T1 _k,T2 _v)
	{
		key=_k;
		value=_v;
	}
	public T1 getKey()
	{
		return key;
	}
	public T2 getValue()
	{
		return value;
	}
}

public class GenericTesting_2
{
	public static void main(String[] args)
	{
		MyGenericList<Pair<String,Integer>> db=new MyGenericList<Pair<String,Integer>>();

		db.add(new Pair<String,Integer>("John",2343));
		db.add(new Pair<String,Integer>("Susane",8908));

		Pair<String,Integer> pair=db.get(0);

		//System.out.println("str = "+str);
		//System.out.println("i = "+i);
	}
}