//import javax.xml.crypto.Data;


public class Set implements Cloneable
{
	private int [] sets;
	private int numOfItems;
	private int index;
	/*Effect: constructor to create a set which can store 5 ints
	 *@Precondition: NONE
	 *@Postcondition: an empty set exists */
	public Set()
	{
		final int INIT_CAPACITY =5;
		numOfItems = 0;
		sets = new int [INIT_CAPACITY];
		
		for(int initial = 0; initial < sets.length; initial++)
		{
			sets[initial] = 0;
		}
	}
	/*Effect: constructor to create a set which can store ecapacityf ints
	 *@Precondition: NONE
	 *@Postcondition: an empty set exists*/
	public Set(int capacity)
	{
		sets = new int [capacity];//??
		for(int initial = 0; initial < sets.length ; initial++)
		{
			sets[initial] = 0;
		}
		numOfItems = 0;
		
	}
	/*Effect: Determines if this set is empty
	 *Precondition: NONE
	 *Postcondition: this Set object is unchanged
	 *Returns: true if this Set is empty, false otherwise 
	 */
	public boolean isEmpty()
	{
		boolean empty = false;
		if(numOfItems == 0)
		{
			return empty = true;
		}
		
		return empty;
	}
	
	public boolean isFull()
	{
		boolean fullness = false;
		if(numOfItems == sets.length)
		{
			fullness = true;
		}
		return fullness;
	}
	public void insert(int newItem)
	{
		if(numOfItems != sets.length)
		{
			if(!contains(newItem))
			{			
				sets[numOfItems] = newItem;
				numOfItems++;
			}
			else
			{
				System.out.println("Sorry, your integer is duplicate");
			}
		}
		else
		{
			throw new SetException("No space to store");
		}
		
	}
	public boolean remove(int item)
	{
		boolean success;
		for(index = 0; (index < numOfItems)&&(item != sets[index]);index++);
		
		if(index == numOfItems)
		{//stored elements and item does not duplicate, so no change. 
			success = false;
		}
		else
		{//Item was found
			sets[index] = sets[numOfItems -1];
			numOfItems--;
			success = true;
		}
		return success;
		
	}
	//determine whether values is already contained or not.
	public boolean contains(int item)
	{//for-loop avoid duplicate
		boolean duplicate = false;
		for(index = 0; (index < numOfItems)&&(item != sets[index]);index++);
		//no work needs
		if(index == numOfItems)
		{//no duplicate
			duplicate = false;
		}
		else
		{//yes duplicate
			duplicate = true;
		}
		return duplicate;
		
	}
	public boolean subset(Set aSet)
	{
		boolean subset = false;
		for(int walker = 0; walker < aSet.numOfItems; walker++)
		{
			if(!this.contains(aSet.sets[walker]))//if contains return false, no duplicate and deny false to be true
			{
				return subset = false;
			}
		}
		subset = true;
		return subset;
	}
	public Set union(Set aSet)
	{
		//int newIndex = 0;
		int unionCapacity = this.numOfItems + aSet.numOfItems;
		Set unionSet = new Set(unionCapacity);
		
		for(int walker = 0; walker < this.numOfItems; walker++)
		{
			if(aSet.contains(this.sets[walker]))//if num is NOT duplicate
			{
				unionSet.insert(sets[walker]);
				
				//newIndex++;
			}
			if(aSet.contains(this.sets[walker]))
			{
				unionSet.insert(aSet.sets[walker]);
			}
		}
		//System.out.println("union set =" + unionSet.toString());
		return unionSet;
		
	}
	public Set intersection(Set aSet)
	{
		int newIndex = 0;
		int newCapacity = Math.min(this.getNumOfItems(),  aSet.getNumOfItems());
		Set intersectionSet = new Set(newCapacity);//create 3rd object of array which has added length of added two object just in case.
	
		for(int walker = 0; walker < this.numOfItems; walker++)//careful with domain
		{
			if(aSet.contains(this.sets[walker])) // if aSet does not contain
			{
				intersectionSet.insert(this.sets[walker]);
				newIndex++;
			}
			
		}
		
		System.out.println("intersection = " + intersectionSet.toString());
		return intersectionSet;
	
	}
	public boolean equals(Object aSet)
	{
		boolean equality = false;
		if(this.getClass() == aSet.getClass())
		{
			if(this.sets.length == ((Set) aSet).sets.length)
			{
				for(int walker =0; walker < sets.length ; walker++)
				{//if there is the same integer, then return true
					 if(contains(walker))
					 {
						 return equality = true;
					 }
				}
				
			}
		}
		return equality;
	}
	public Set clone()
	{//create a clone object of subset
		Set clonedSet;
		
		try
		{
			clonedSet = (Set)super.clone();
		}
		catch(CloneNotSupportedException ex)
		{//just in case to forget implement Cloneable class
			throw new RuntimeException("Not impliment Clonable");
		}
		clonedSet.sets = sets.clone();
		
		return clonedSet;
	}
	public String toString()
	{
		String listArray = "";
		for(int index = 0; index < numOfItems; index++)
		{
			listArray +=  String.valueOf(sets[index]) ;
			if(index < numOfItems -1)
			{
				listArray += ", ";
			}
		}
		
		return "{"+ listArray + "}"; 
		
	}
	public int getNumOfItems()
	{
		return numOfItems;
	}
	
}//class
