
public class SetTest 
{
	public static void main(String [] args)
	{
		Set set1 = new Set();
		Set set2 = new Set();
		
		set1.insert(1);
		set1.insert(2);
		set1.insert(3);
		set1.insert(4);
		set1.insert(5);
		
		set2.insert(6);
		set2.insert(4);
		set2.insert(8);
		set2.insert(9);
		set2.insert(3);
		
		System.out.println("set2 inseted :" + set2.toString());
		
		System.out.println(set2.contains(4));
		
		System.out.println("after insertion" + set1.getNumOfItems());
		set1.clone();
		System.out.println(set1.toString());
		set1.remove(3);
		System.out.println("after removing" + set1.getNumOfItems());
		System.out.println(set1.toString());
		
		 System.out.println(set1.chekingElememnt(set2).toString());
		
		
		
		if(set1.isEmpty())
		{
			System.out.println("this set is empty");
		}
		else 
		{
			System.out.println("this set is not empty");
		}
		if(set1.isFull())
		{
			System.out.println("this set is Full");
		}
		else 
		{
			System.out.println("this set is not Full");
		}
		
		 
		 
		 
		 
		 

		 
	}//main

}//class
