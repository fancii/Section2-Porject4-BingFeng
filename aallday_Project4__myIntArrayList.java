package myIntArrayList;

import java.util.Scanner;
public class myIntArrayList 
{
	private int size;
	private int index;
	private int value;
	private int[] input;
	private int[] list;
	private int[] temp;
	private int[] array1;
	private int[] array2;
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int[] Something = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		myIntArrayList myList1 = new myIntArrayList();
		myIntArrayList myList2 = new myIntArrayList(Something);
		myIntArrayList myList3 = new myIntArrayList(myList2);

		System.out.println("Size of myList1: " + myList1.size());
		myList1.print();

		System.out.println("\nSize of myList2: " + myList2.size()+"\n");
		myList2.print();

		System.out.println("\nSize of myList3: " + myList3.size());
		myList3.print();

		//myIntArrayList myList1 = new myIntArrayList();

		myList1.add(0, 1);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");
		myList1.print();

		myList1.add(0, 3);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");
		myList1.print();

		myList1.add(0, 5);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");
		myList1.print();

		myList1.add(0, 7);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");

		myList1.remove(7);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");
		myList1.print();

		myList1.remove(7);
		System.out.println("Size is: " + myList1.size());
		System.out.println("Elements:");
		myList1.print();
	}

	public myIntArrayList () 
	{
		System.out.println("Please enter the number of elements in your list:");
		this.size = kb.nextInt();
		input = new int[this.size];
		simpleSort(input);

		for(int i = 0; i < size; i++){
			System.out.println("Now enter number " + (i+1) + ": ");
			input [i] = kb.nextInt();
		}

	}


	public myIntArrayList (int[] anArray)
	{
		for(int i = 0; i < size; i++){
			System.out.println("Now enter number " + (i+1) + ": ");
			input [i] = kb.nextInt();
		}
		list = new int[this.size];
		for (int i = 0; i < this.size; i++)
		{
			list[i] = input[i];
		}
	}

	public myIntArrayList (myIntArrayList anExample)
	{
		temp = new int[this.size];
		for (int i = 0; i < this.size; i++)
		{
			temp[i] = list[i];
		}
	}

	public void add (int index, int value)
	{
		array1 = new int [index + 1];
		//array2 = new int [this.size - array1.length];

		for (int i = 0; i < index; i++)
		{
			array1[i] = list[i];
		}
		array1[index]=value;
		for (int i = index; i > index; i++)
		{
			array1[i+1] = list[i];
		}
		
		for (int i = 0; i < this.size; i++)
		{
			list[i] = input[i];
		}
		
		myIntArrayList myList = new myIntArrayList();
	}

	public int remove (int index)
	{
		if (index < 0) 
		{
			//throw new IndexOutOfBoundsException("" + index);
		}
		return 0;
	}

	public void simpleSort (int[] arr)
	//private static void myIntArrayList simpleSort(int[] arr)
	{
		for (int i = 1; i < arr.length; i++) 
		{
			int valueToSort = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > valueToSort) 
			{
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = valueToSort;
		}
	}



	public boolean equals (myIntArrayList anotherList)
	{

		if (anotherList.size==index) 

			return true;
		return true; //???????????????????????
	}

	public boolean isCongruent (myIntArrayList anotherList)
	{



	}

	public int get (int index)
	{
		return list[index];	
	}

	public int indexOf (int value)
	{
		int index = 0;
		for(int i = 0; i < this.size; i++)
		{
			if (list[i] == value)
			{
				index = i;
			}
		}
		return index;	
	}

	public int size ()
	{
		return this.size;
	}

	public void clear ()
	{
		System.out.println("Clearing the list...");
		for(int i = 0; i < this.size; i++){
			remove(i);
		}
	}

	public void print ()
	{
		System.out.println("Here are the Elements in your list:");
		for(int i = 0; i < this.size; i++){
			System.out.print(i+", ");
			//System.out.println("\n");
			//			System.out.println(myList2);
		}
	}
}
