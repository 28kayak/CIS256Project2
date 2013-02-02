
public class IntArrayBagTeat
{
	public static void main (String [] args)
	{
		  IntArrayBag bag = new IntArrayBag();
		  bag.add(10);
		  bag.addMany(1,2,3,4,10,100);
		  System.out.printf("getCapacity() = %d\n",bag.getCapacity());
		  System.out.printf("bag.size() = %d\n",bag.size());
		  System.out.println(bag.toString());
		  bag.remove(1);
		  System.out.println(bag.toString());
		  System.out.printf("after removing bag.size() = %d", bag.size());
		
	}//main
}//class
