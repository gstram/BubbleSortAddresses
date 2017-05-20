// Giuseppe Stramandinoli 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class BubbleSortTester 
{

	public static void main(String[] args) 
	{
		// Initialize array
    	Listing[] dataBase = new Listing[15];
    	
		// Insert listings from file "AddressBook"
		try
		{
			Scanner inputStream = new Scanner(new File("AddressBook.txt"));
			int counter = 0;
			
			while (inputStream.hasNext())
			{
				Listing tempListing = new Listing(inputStream.next(), inputStream.next(), inputStream.next());
				dataBase[counter] = tempListing;
				counter++;
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
		
		// Bubble Sort and print array
		//insertionSort(dataBase);
		bubble(dataBase, 15);
		
		// Print sorted array
		System.out.println("Sorted Array: ");
		for(int counter = 0; counter < (dataBase.length); counter++)
		{
			System.out.println(dataBase[counter].toString());
		}

	}

	public static void bubble(Listing[] array, int itemsToBeSorted) 
	{
		Listing temp;
		int swaps = 0;
	
		for(int counter1 = 0; counter1 < itemsToBeSorted; counter1++) 
		{
			for(int counter2 = (itemsToBeSorted-1); counter2 > counter1 ; counter2--) 
			{ 
				if (array[counter2].getKey().compareTo(array[counter2-1].getKey()) < 0) 
				{
					swaps++;
					temp = array[counter2]; 
					array[counter2] = array[counter2-1]; 
					array[counter2-1] = temp;
				}
			}  
		}
		System.out.println("Number of Swaps: " + swaps);
	}
	
	public static void insertionSort(Listing[] array)
	{
		Listing current;
		int counter2;
		
		for(int counter = 0; counter < (array.length); counter++)
		{
			current = array[counter];
			counter2 = counter-1;
			while(counter2 >= 0 && array[counter2].getKey().compareTo(current.getKey()) > 0)
			{
				array[counter2 + 1] = array[counter2];
				counter2 = counter2 - 1;
			}
			array[counter2 +1] = current;			
		}
	}
}
