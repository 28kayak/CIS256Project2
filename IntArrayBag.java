public class IntArrayBag implements Cloneable
{
	private int [] data;
	private int manyItems;
	
	public IntArrayBag()
	{
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new int [INITIAL_CAPACITY];
	}
	public IntArrayBag(int initialCapacity)
	{
		if(initialCapacity < 0)
		{
			throw new IllegalArgumentException
				("The initial vapacity is negative: " + initialCapacity);
		}
		data = new int [initialCapacity];
		manyItems = 0;
	}
	public void add(int element)
	{
		if(manyItems == data.length)
		{
			ensureCapacity((manyItems + 1)*2);	
		}
		data[manyItems] = element;
		manyItems++;
	}
	public void addMany(int ...elements)//parameter can be more.
	{
		if(manyItems + elements.length > data.length)
		{
			ensureCapacity((manyItems + elements.length)*2);
		}
		System.arraycopy(elements, 0, data, manyItems, elements.length);
		manyItems += elements.length;
	}
	public void addAll(IntArrayBag addend)
	{
		ensureCapacity(manyItems + addend.manyItems);
		System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
		manyItems += addend.manyItems;
	}
	public IntArrayBag clone()
	{//create a clone of an IntArrayBag object
		IntArrayBag answer; // another object named answer???
		
		try
		{
			answer = (IntArrayBag) super.clone();
		}
		catch(CloneNotSupportedException ex)
		{//it would not occur, but if it does, programming error,check not to forget "implements Cloneable"
			throw new RuntimeException ("this class does not implement Cloneable");
		}
		answer.data = data.clone();
		return answer;
	}
	public int countOccurrences(int target)
	{
		int answer;
		int index;
		
		answer = 0;
		for(index = 0; index < manyItems ; index++)
		{
			if(target == data[index])
			{
				answer++;
			}
		}
		return answer;
		
	}
	public void ensureCapacity(int minimumCapacity)
	{
		int [] biggerArray;
		if(data.length < minimumCapacity)
		{
			biggerArray = new int [minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}
	public int getCapacity()//Accessor method
	{
		return data.length;
	}
	public boolean remove(int target)
	{
		int index;// the location of target in the data array;
		boolean success = false;//added by me;
		for(index = 0; (index < manyItems)&&(target != data[index]); index++);
		//No work is needed in the body of this for-loop
		System.out.print("manyItems = ");
		System.out.print(manyItems);
		System.out.print("  index =");
		System.out.print(index);
		System.out.print("  value of data[index]=");
		System.out.print(data[index]);
		System.out.print("  value of data[manyItems-1]=");
		System.out.println(data[manyItems-1]);
		if(index == manyItems)
		{
			success = false; //return false, finished looking all index of for-loop;
			//means there is not target.
		}
		else
		{
			manyItems--;// 
			data[index] = data[manyItems];
			success = true;
			
		}
		return success;
	}
	public int size()//Accessor method
	{
		return manyItems;
	}
	public void trimToSize()
	{
		int [] trimmedArray;
		if(data.length != manyItems)
		{
			trimmedArray = new int [manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}
	public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2)
	{
			IntArrayBag answer = new IntArrayBag(b1.getCapacity() + b2.getCapacity());
			
			System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
			System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
			answer.manyItems = b1.manyItems + b2.manyItems;
			
			return answer;
	}
	public String toString()
	{
		String listArray = "";
		for(int index = 0; index < manyItems; index++)
		{
			listArray += String.valueOf(data[index])+ ",";
		}	
		/* WONG VERSION
		for(int index = 0; index <  data.length; index++)
		{
			listArray +=  String.valueOf(data[index]) + "\n"; 
		}
		*/
		return  "{"+ listArray + "}"; 
		
		
	}
}//class