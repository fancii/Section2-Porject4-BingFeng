/**
 * @author Jonathan Michael Lee
 * @version 1.0, September 28, 2014
 * This program creates an Array List that is structurally similar to Java's Array List but still different.
 */

public class myIntArrayList {
	int[] myArray;
	
	public myIntArrayList() {
		myArray = new int[1];
	}
	 
	public myIntArrayList(int[] anArray) {
		myArray = new int[anArray.length];
		for(int i = 0; i < anArray.length; i++) {
			myArray[i] = anArray[i] ;
		}
	}

	public myIntArrayList(myIntArrayList anExample) {
		myArray = new int [anExample.size()];
		for(int i = 0; i < anExample.size(); i++)
		{
			myArray[i]=anExample.get(i);
		}
	}

	void print() {
		for(int i = 0; i < myArray.length; i++)
		{
			System.out.print(myArray[i] + " ");
		}
		System.out.println();
	}

	void clear() {
		myArray = new int[0];
	}

	void add(int index, int value) {
		int[] temp = new int[myArray.length + 1];
		int i;
		if(index <= 0)
		{
			index = 0;
			temp[0] = value;
			for(i = 0; i < myArray.length - 1; i++)
			{
				temp[i] = myArray[i + 1];	

			}
		}

		if(index >= myArray.length)
		{
			index = myArray.length;
			temp[myArray.length] = value;
			for(i = 0; i < myArray.length - 1; i++)
			{
				temp[i] = myArray[i];
			}
		}

		for(i = 0; i < index; i++)
		{
			temp[i] = myArray[i];
		}

		temp[index] = value;

		for(i = index + 1; i < myArray.length + 1; i++)
		{
			temp[i] = myArray[i - 1];
		}

		myArray = new int[myArray.length + 1];

		for(i = 0; i < temp.length; i++)
		{
			myArray[i] = temp[i];
		}
	}

	int remove(int index)
	{

		int[] temp = new int[myArray.length - 1];
			
		if(index <= 0)
		{
			index = 0;			
			for(int i = 0; i < myArray.length - 1; i++)
			{
				temp[i] = myArray[i];	

			}
		}

		if(index >= myArray.length)
		{
			index = myArray.length - 1;			
			for(int i = 0; i < myArray.length - 1; i++)
			{
				temp[i] = myArray[i];
			}
		}

		for(int i = 0; i < index; i++)
		{
			temp[i] = myArray[i];
		}
		for(int i = index + 1; i < myArray.length; i++)
		{
			temp[i-1] = myArray[i];
		}
		
		int value = myArray[index];
		myArray = new int[temp.length];

			for(int i=0; i<temp.length; i++)
			{
				myArray[i] = temp[i];
				temp[index] = myArray[i];
			}
		myArray = temp;

		return value;
	}

	int get(int index)
	{
		return myArray[index];
	}

	int indexOf(int value)
	{
		for(int i=0; i<myArray.length; i++)
		{
			if(myArray[i] == value) 
			{
				value = i;
			}
		}
		return value;
	}

	int size()
	{
		return myArray.length;		
	}

	boolean equal(myIntArrayList array){
		boolean test1, test2 = false;
		boolean test3 = false;

		if(myArray.length==array.size())
		{
			test1=true;
		}else{
			test1=false;
		}
	
			int count=0;
			
			for(int i = 0; i < myArray.length; i++)
			{			
				if(myArray[i]==array.get(i))
				{
					count++;
				}
				if(count==myArray.length)
				{
					test2 = true;
				}else{
					System.out.println(count + "elements were the same");
					test2 = false;
				}
			}
			simpleSort();
			
			for(int i=0; i<myArray.length; i++)
			{
				if(myArray[i]==array.get(i))
				{
					count++;
				}
				if(count==myArray.length)
				{
					test3=true;
				}else{
					test3=false;
				}
			}
		
		if(test1 && test2 && test3)
		{
			return true;
		}
		return false;

	}
	 
	boolean congruent(myIntArrayList array){
		int count=0;
		boolean test1, test2 = false;
		if(myArray.length==array.size())
		{
			test1=true;
		}else{
		test1=false;
		}
		simpleSort();
		for(int i=0; i<myArray.length; i++)
		{
			if(myArray[i]==array.get(i))
			{
				count++;
			}
			if(count==myArray.length)
			{
				test2=true;
			}else{
				test2=false;
			}
		}
		if(test1&&test2)
		{
			return true;
		}
		return false;
	} 
	
	void simpleSort(){
		int count=0;
		int temp;
		
		while(count!=0)
		{
			
			for(int i=0; i<myArray.length; i++)
			{
				for(int j=0; j<myArray.length; j++)
				{
					if(myArray[i]<myArray[j])
					{
						temp = myArray[i];
						myArray[i] = myArray[j];
						myArray[j] = myArray[i];
						count++;
					}
				}
			}
		}
	}
 
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		myIntArrayList list = new myIntArrayList(array);
		System.out.println(list.size());
		list.print();
		list.add(4, 68);
		list.print();
		list.remove(4);
		list.print();
		list.remove(3);

		list.print();
	}
}
