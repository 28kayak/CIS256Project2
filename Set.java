
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
	/*
	 *Effect: Determines if this set is full
	  Precondition: NONE
	  Postcondition: this Set object is unchanged
      Returns: true if this set is full, false otherwise*/
	public boolean isFull()
	{
		boolean fullness = false;
		if(numOfItems == sets.length)
		{
			fullness = true;
		}
		return fullness;
	}
	/*Effect: inserts newItem into the set
	Precondition: this Set does not already contain newItem
	Postcondition: if this Set is full, a SetException is to be thrown*/
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
	/*Effect: if item is in the Set, it is removed
	Precondition: NONE
	Postcondition: a value may have been removed from this Set
	Returns: true is returned if an item was removed, otherwise false is removed.*/
	public boolean remove(int item)
	{
		boolean success;
		for(index = 0; (index < numOfItems)&&(item != sets[index]);index++);
		//Figurer out which index item is, that is why index is to be a class variable 
		if(index == numOfItems)
		{//stored elements and item does not duplicate, so no change. 
			success = false;
		}
		else
		{//Item was found
			sets[index] = sets[numOfItems -1];//insert the last element into space where the target was
			numOfItems--;//decrement to hide the last element
			success = true;
		}
		return success;
		
	}
	/*Effect: determines if a value is contained in the set
	Precondition: NONE
	Postcondition: this Set object is unchanged
	Returns: returns true if this Set contains eitemf, otherwise false is returned*/
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
	/*Effect: determines if one set is a subset of another
	Precondition: NONE
	Postcondition: this Set object is unchanged
	Returns: returns true if this all elements of aSet are contained in this Set (also, an empty set IS
	a subset of any set)*/
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
	/*Effect: creates a Set that is a union of this Set and another
	Precondition: aSet is the reference to a Set object
	Postcondition: this Set object is unchanged
	Returns: a Set object which contains elements which are either in this set or aSet*/
	public Set union(Set aSet)
	{
		int unionCapacity = this.numOfItems + aSet.numOfItems;
		Set unionSet = new Set(unionCapacity);
		for(int count = 0 ; count < this.getNumOfItems(); count++)
		{
			unionSet.insert(aSet.sets[count]);//insert everything in aSet to compare 
		}
		
		for(int walker = 0;( walker < this.numOfItems); walker++)
		{
			if(!aSet.contains(this.sets[walker]))//if num is NOT duplicate
			{
				unionSet.insert(sets[walker]);
			}
		}
		return unionSet;
	}
	/*Effect: creates a set that is the intersection of this Set and another
	Precondition: aSet is the reference to a Set object
	Postcondition: this Set object is unchanged
	Returns: returns a Set object which contains elements which are contained in BOTH this set and
	aSet*/
	public Set intersection(Set aSet)
	{
		int newCapacity = Math.min(this.getNumOfItems(),  aSet.getNumOfItems());
		Set intersectionSet = new Set(newCapacity);//create 3rd object of array which has added length of added two object just in case.
	
		for(int walker = 0; walker < this.numOfItems; walker++)//careful with domain
		{
			if(aSet.contains(this.sets[walker])) // if aSet does not contain
			{
				intersectionSet.insert(this.sets[walker]);
			}
			
		}
		
		System.out.println("intersection = " + intersectionSet.toString());
		return intersectionSet;
	}
	/*Effect: determines if two sets are equal
	Precondition: NONE
	Postcondition: this Set object is unchanged
	Returns: returns true if this Set contains the same elements as in aSet (storage order is not important)*/
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
	/*Effect: creates a distinct copy of this Set
	Precondition: NONE
	Postcondition: this Set object is unchanged
	Returns: a Set which is identical, but distinct from this Set*/
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
	/*Effect: returns a String containing all elements of this Set
	Precondition: NONE
	Postcondition: this Set object is unchanged
	Returns: a String containing Set items in format { int, int, int, etc }*/
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
	//numOfItems is private, but I want to use numOfItems to see and current full index.
	//I created.
	public int getNumOfItems()
	{
		return numOfItems;
	}
	
}//class
