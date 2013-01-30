
public class Set 
{
	private int [] sets;
	private int numOfItems;
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
	/*Effect: constructor to create a set which can store ecapacityf ints
	 *@Precondition: NONE
	 *@Postcondition: an empty set exists*/
	public boolean isEmpty()
	{
		
	}
	/*Effect: Determines if this set is empty
	 *Precondition: NONE
	 *Postcondition: this Set object is unchanged
	 *Returns: true if this Set is empty, false otherwise 
	 */
	public boolean isFull()
	{
		
	}
	public void insert()
	{
		
	}
	public boolean remove()
	{
		
	}
	public boolean contains(int item)
	{
		
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
		
	}
	public Set clone()
	{
		
	}
	public String toString()
	{
		
	}
}//class
