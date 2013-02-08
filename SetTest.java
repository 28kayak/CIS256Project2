//Kaya Ota
//CIS256 
//2.07.2013
//project2

import java.util.Scanner;
public class SetTest 
{
	public static void main(String [] args)
	{
		
	
		Scanner scan = new Scanner(System.in);
		int numOfelement;
		int action;
		int set =0;
		int element = 0;
		System.out.println("How many elemenets are you going to store into the setA?");
		numOfelement = scan.nextInt();
		Set set1 = new Set(numOfelement);
		
		System.out.println("How many elemenets are you going to store into the setB?");
		numOfelement = scan.nextInt();
		Set set2 = new Set(numOfelement);
		
		
		do
		{
			System.out.println("\nwhat action do you want to take?");
			System.out.println("1:Add an element to a Set");
			System.out.println("2:Remove an element from a Set");
			System.out.println("3:Look for a supecific element \n4:Check if your set is empty");
			System.out.println("5:Check if your set is full\n6:Indicate if Set1 is subset of Set2");
			System.out.println("7:Output union of SetA and SetB\n 8:Output intersection of Set1 and Set2"); 
			System.out.println("9:Set Set2 to be a copy of Set1\n 10: determine two sets are equal or not" +
					"\n**Type -1 to Exit this program**");
		
			action = scan.nextInt();
			
			switch(action)
			{
				case 1:
					System.out.println("which Set do you want to insert an int? Enter 1 for Set1, 2 for Set2");
					set = scan.nextInt();
					if(set == 1)
					{
						System.out.println("Enter integer you want to add into Set1");
						element = scan.nextInt();
						set1.insert(element);
					}
					else if (set == 2)
					{
						System.out.println("Enter integer you want to add into Set2");
						element = scan.nextInt();
						set2.insert(element);
					}
					else 
					{
						System.out.println("invalid set number");
					}
					break;
					
				case 2: 
					System.out.println("which Set do you want to remove an int? 1 for Set1, 2 for Set2");
					set = scan.nextInt();
					if(set == 1)
					{
						System.out.println("Enter integer you want to remove into Set1");
						element = scan.nextInt();
						if(set1.remove(element))
						{
							System.out.printf("%d in Set1 is now deleted\n", element);
						}
						else
						{
							System.out.println("Sorry, there does not exsist the int you typed");
						}
						
					}
					else if(set == 2)
					{
						System.out.println("Enter integer you want to remove into Set2");
						element = scan.nextInt();
						if(set2.remove(element))
						{
							System.out.printf("%d in Set2 is now deleted\n", element);
						}
						else
						{
							System.out.printf("Sorry, %d does not exsist the int you typed",element);
						}
					}
					else
					{
						System.out.println("invarid set number");
					}
					break;
				case 3:
					System.out.println("From which set looking for? 1 for Set1, 2 for Set2");
					set = scan.nextInt();
					if(set == 1)
					{
						System.out.println("Enter integer you want to find from Set1");
						element = scan.nextInt();
						if(set1.contains(element))
						{
							System.out.printf("yes, %d is in Set1\n", element);
						}		
					}
					else if(set == 2)
					{
						System.out.println("Enter integer you want to find from Set2");
						element = scan.nextInt();
						if(set2.contains(element))
						{
							System.out.printf("No, %d is not in Set2\n", element);
						}		
					}
					else
					{
						System.out.println("invarid set number");
					}
					break;
				case 4: 
					System.out.println("which Set do you want to check if it is empty?  Enter 1 for Set1, 2 for Set2");
					set = scan.nextInt();
					if(set == 1)
					{
						if(set1.isEmpty())
						{
							System.out.println("this set is É”");
						}
						else
						{
							System.out.println("this not empty set");
						}
					}
					else if(set == 2)
					{
						if(set2.isEmpty())
						{
							System.out.println("this set is É”");
						}
						else
						{
							System.out.println("this not empty set");
						}
					}
					else
					{
						System.out.println("invalid set number");
					}
					break;
				case 5:
					System.out.println("which Set do you want to check if it is full? Enter 1 for Set1, 2 for Set2");
					set = scan.nextInt();
					if(set == 1)
					{
						if(set1.isFull())
						{
							System.out.println("this set is no space");
						}
						else
						{
							System.out.println("this set still have space");
						}
					}
					else if(set == 2)
					{
						if(set2.isFull())
						{
							System.out.println("this set is no space");
						}
						else
						{
							System.out.println("this set still have space");
						}
					}
					else
					{
						System.out.println("invalid set number");
					}
					break;
				case 6:
					if(set2.subset(set1))
					{
						System.out.println("set2 is subset of set1");
					}
					else
					{
						System.out.println("set2 is not subset of set1");
					}
					break;
				case 7: 
					System.out.println(set1.union(set2));
					break;
				case 8:
					System.out.println(set1.intersection(set2));
					break;
				case 9:
					set2 = set1.clone();
					System.out.println(set2.toString());
					break;
				case 10:
					if(set2.equals(set1))
					{
						System.out.println("both set are equal");
					}
					else
					{
						System.out.println("both are different");
					}
					
				
			}
		}while (action != -1);
		
		
		
		
		/*
		System.out.println("");
		
		
		
		
		set1.insert(1);
		set1.insert(2);
		set1.insert(3);
		set1.insert(4);
		set1.insert(5);
		
		set2.insert(1);
		set2.insert(2);
		set2.insert(3);
		
		
		set2.insert(6);
		set2.insert(4);
		set2.insert(8);
		set2.insert(9);
		set2.insert(3);
		
		
		System.out.println("set2 :" + set2.toString());
		System.out.println("set1 :" + set1.toString());
		//set1.remove(3);
		System.out.println("intersection");
		System.out.println(set1.intersection(set2));
		
		//System.out.println("clone" + set1.clone());
		
		System.out.println("union :"+set1.union(set2));
		
		//set1.remove(3);
		//System.out.println("after removing" + set1.getNumOfItems());
		//System.out.println(set1.toString());
		
		 
		System.out.println("subset :" + set1.subset(set2));
		
		
		
		if(set1.isEmpty())
		{
			System.out.println("this set is empty");
		}
		else 
		{
			System.out.println("this set is not empty");
		}
		
		*/
		 
		 
		 
		 
		 
		System.out.println("programed by kaya ota");
		scan.close();
	}//main

}//class
