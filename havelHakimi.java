 
import java.util.ArrayList;


public class havelHakimi {

	public ArrayList<Integer> numOfPeopleMet = new ArrayList<Integer>();
	public ArrayList<Integer> newArray = new ArrayList<Integer>();
	
	
	public void addTheNumbers()
	{
		numOfPeopleMet.add(5);
		numOfPeopleMet.add(3);
		numOfPeopleMet.add(5);
		numOfPeopleMet.add(0);
		numOfPeopleMet.add(2);
		numOfPeopleMet.add(6);
		numOfPeopleMet.add(2);
		numOfPeopleMet.add(0);
		numOfPeopleMet.add(7);
		numOfPeopleMet.add(2);
		numOfPeopleMet.add(5);
		
		System.out.println("The numbers currently are:" + numOfPeopleMet);
	}
	
	public void removeZeros() 
	{
		for(int i=0; i<numOfPeopleMet.size(); i++)
		{
			if(numOfPeopleMet.get(i) == 0)
			{
				numOfPeopleMet.remove(i);
			}
		}
		
		System.out.println("After removing the zeros (0) the numbers are: " + numOfPeopleMet);
	}
	
	public void sortDescOrder()
	{
		int largest = 0;
		int lastDeletedNum = 0;
		int startingArraySize = numOfPeopleMet.size();
		
		newArray.clear();
		for(int counter=0; counter<startingArraySize; counter++)
		{
			System.out.println("Counter is right now at " + counter);
			for(int i=0; i<numOfPeopleMet.size(); i++)
			{
				if(numOfPeopleMet.get(i) > largest)
				{
					largest = numOfPeopleMet.get(i);
					lastDeletedNum = i;
				}
			}
			newArray.add(largest);
			numOfPeopleMet.remove(lastDeletedNum);
			lastDeletedNum = 0;
			largest = 0;

			System.out.println("Old arrangement is now: " + numOfPeopleMet);
			System.out.println("New arrangement is now: " + newArray);
		}
		numOfPeopleMet = new ArrayList<Integer>(newArray);
			System.out.println("Final arrangement is: " + numOfPeopleMet);
	}
	
	public boolean lengthCheck(int n)
	{
		if(n > numOfPeopleMet.size())
		{
			System.out.println("n --> "+ n + " is greater than size --> " + numOfPeopleMet.size());
			System.out.println("Someone is lying.");
			return true;
		}
		
		System.out.println("n --> "+ n + " is NOT greater than size --> " + numOfPeopleMet.size());
		return false;
	}
	
	public boolean frontElimination(int n)
	{
		if((n<0)||(n>numOfPeopleMet.size()))
		{
			System.out.println("Value n must be between 0 and " + numOfPeopleMet.size());
			return false;
		}
		System.out.println("Old arraylist is now: " + numOfPeopleMet);
		for(int i=0;i<n;i++)
		{
			numOfPeopleMet.set(i, numOfPeopleMet.get(i)-1); 
		}
		System.out.println("Arraylist is now: " + numOfPeopleMet);
		return true;
	}
	

	
	//a must be greater than the size of the array
	//b must be between 0 and the size of the array
	public void infiniteLoop() 
	{
		boolean done = false;
		boolean correct = false;
		
		addTheNumbers(); //start

		while(done == false)
		{	

			removeZeros(); //step 1
			//System.out.println("Size on step 1:" + numOfPeopleMet.size());

			for(int i=0; i<numOfPeopleMet.size(); i++) //step 2
			{
				if(numOfPeopleMet.get(i) != 0)
				{
					System.out.println("Found number otherthan 0. Breaking loop.");
					break;
				}	
				if(i == (numOfPeopleMet.size()-1) && (numOfPeopleMet.get(i) == 0))
				{
					done = true;
					correct = true;
				}
			}
			//System.out.println("Size on step 2:" + numOfPeopleMet.size());

			sortDescOrder(); //step 3
			//System.out.println("Size on step 3:" + numOfPeopleMet.size());

			int lastLargest = numOfPeopleMet.get(0); //step 4
			numOfPeopleMet.remove(0); //step 4 finish
			//System.out.println("Size on step 4:" + numOfPeopleMet.size());

			lengthCheck(lastLargest); //step 5
			//System.out.println("Size on step 5:" + numOfPeopleMet.size());

			if(lastLargest > numOfPeopleMet.size())
			{
				done = true;
				correct = false;
			}
			frontElimination(lastLargest); //step 6
			//System.out.println("\\n\\n Size on step 6:" + numOfPeopleMet.size());

		}
	}	
}



