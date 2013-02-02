import javax.xml.crypto.Data;


public class Set 
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
		for(int index = 0; index < sets.length; index++)
		{
			sets[index] = 0;
		}
	}
	/*Effect: constructor to create a set which can store ecapacityf ints
	 *@Precondition: NONE
	 *@Postcondition: an empty set exists*/
	public Set(int capacity)
	{
		sets = new int [capacity];
		for(int index = 0; index < sets.length ; index++)
		{
			sets[index] = 0;
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
		for(int index = 0; index < sets.length; index++)
		{
			if(sets[index] == 0)
			{
				return empty = true;
			}
		}
		return empty;
	}
	
	public boolean isFull()
	{
		boolean fullness = false;
		for(int index = 0; index < sets.length ; index++ )
		{
			if(sets[index] == 0)
			{
				return fullness;
			}
		}
		fullness = true;
		return fullness;
	}
	public void insert(int newItem)
	{
		if(!contains(newItem))
		{
			if(numOfItems == sets.length)
			{
				sets[numOfItems] = newItem;
				numOfItems++;
			}
			
		}
		else
		{
			//throw new Exception("");
		}
		//throw new Exception("sorry, length is not enough");
		
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
	public boolean contains(int item)
	{//for-loop avoid duplicate
		boolean duplicate = false;
		for(index = 0; (index < numOfItems)&&(item != sets[index]);index++);
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
		
	}
	public Set union(Set aSet)
	{
		
	}
	public Set intersection(Set aSet)
	{
	
	}
	public boolean equals(Object aSet)
	{
		boolean equality = false;
		if(this.getClass() == aSet.getClass())
		{
			if(this.sets.length == ((Set) aSet).sets.length)
			{
				for(int walker =0; walker < sets.length ; walker++)
				{//“¯‚¶‚Ì‚ª‚ ‚Á‚½‚çA‚”
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
		{//just in case to forget implement Clonable class
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
			listArray +=  String.valueOf(sets[index]) + ", "; 
		}
		
		return "{"+ listArray + "}"; 
		
	}
}//class
