/**
 * @author Tien Thuy Ho
 * @version 1.2, 28 September 2014
 * This program creates a myIntArrayList class 
 * that is functionally similar to the formal Java ArrayList class.
 */

public class myIntArrayList {
	private int capacity;
	private int[] array;
	
	/**
	 * Default constructor.
	 */
	public myIntArrayList () {
		capacity = 10;
		array = new int[capacity];
	}
	
	/**
	 * Precondition: anArray is an array of integers.
	 * Sets the capacity and the content of an initial 
	 * myIntArrayList instance equivalent to those of anArray.
	 */
	public myIntArrayList(int[] anArray) {
		capacity = anArray.length;
		array = new int[capacity];
		this.array = anArray;
	}
	
	/**
	 * Precondition: anExample is a myIntArrayList object.
	 * Creates a myIntArrayList instance identical to anExample.
	 */
	public myIntArrayList (myIntArrayList anExample) {
		this.capacity = anExample.capacity;
		this.array = anExample.array;
	}
	
	/**
	 * Preconditions: index is a nonzero integer and value is an integer.
	 * Inserts the specified value at the specified index of the myIntArrayList.
	 * If index is outside of the array boundaries, it is added at the end or beginning of the list.
	 */
	public void add (int index, int value) {
		int[] temp = new int[capacity + 1]; 
		
		if (index >= this.capacity) {
			int j = (int)Math.random()*2 + 1;
			//inserts the value at the end
			if (j == 1) {
				for (int i = 0; i < this.capacity; i++) {
					temp[i] = this.array[i];
				}
				temp[capacity] = value;
			}
			
			//inserts the value at the beginning
			else if (j == 2){
				temp[0] = value;
				for (int i = 1; i <= this.capacity; i++) {
					temp[i] = this.array[i-1];
				}
			}
		}
		
		else {
			for (int i = 0; i < index; i++) {
				temp[i] = this.array[i];
			}

			temp[index] = value;

			for (int i = index + 1; i <= this.capacity; i++) {
				temp[i] = this.array[i-1];
			}
		}
		
		this.capacity += 1;
		this.array = new int[capacity];
		this.array = temp;
	}
	
	/**
	 * Precondition: index is a nonzero integer.
	 * Removes the element at the specified index from the myIntArrayList.
	 * Removes the first or last element if index is out of bound.
	 */
	public void remove (int index) {
		int[] temp = new int[capacity - 1];
		
		if (index >= this.capacity) {
			int j = (int)Math.random()*2 + 1;
			//removes the last element
			if (j == 1) {
				for (int i = 0; i < (this.capacity - 1); i++) {
					temp[i] = this.array[i];
				}
			}
			
			//removes the first element
			else if (j == 2) {
				for (int i = 0; i < this.capacity; i++) {
					temp[i] = this.array[i+1];
				}
			}
		}
		
		else {
			for (int i = 0; i < index; i++) {
				temp[i] = this.array[i];
			}

			for (int i = index; i < (this.capacity - 1); i++) {
				temp[i] = this.array[i + 1];
			}
		}
		this.capacity -= 1;
		this.array = new int[capacity];
		this.array = temp;
		
	}
	
	/**
	 * Returns another myIntArrayList object with its contents sorted 
	 * in ascending order using an insertion sort.
	 */
	public myIntArrayList simpleSort() {
		for (int i = 1; i < this.capacity; i++) {
			for (int j = i; j > 0; j--) {
				if (this.array[j] < this.array[j-1]) {
					int comeAfter = this.array[j-1];
					int comeBefore = this.array[j];
					this.array[j] = comeAfter;
					this.array[j-1] = comeBefore;
				}
			}
		}
		
		myIntArrayList orderedList = new myIntArrayList (this.array);
		return orderedList;
	}
	
	/**
	 * Precondition: anotherList is a myIntArrayList object.
	 * Returns 1 if the two myIntArrayLists are equal, otherwise returns 0.
	 * Two myIntArrayLists are equal when they have the same capacity and contents in the same order.
	 */
	public boolean equals (myIntArrayList anotherList) {
		boolean sameSize = (this.capacity == anotherList.capacity);
		int numberOfMatchedElements = 0;
		
		if (sameSize) {
			for (int i = 0; i < this.capacity; i++) {
				if (this.array[i] == anotherList.array[i]) {
					numberOfMatchedElements ++;
				}
			}	
		}
		
		boolean sameOrderedContent = (numberOfMatchedElements == this.capacity);
		boolean equal = sameSize && sameOrderedContent;
		if (equal) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
		return (equal);
	}
	
	/**
	 * Precondition: anotherList is a myIntArrayList object.
	 * Returns 1 if the two myIntArrayLists are congruent, otherwise returns 0.
	 * Two myIntArrayLists are congruent when they have the same capacity and contents,
	 * regardless of their order.
	 */
	public boolean isCongruent (myIntArrayList anotherList) {
		boolean sameSize = (this.capacity == anotherList.capacity);
		int numberOfMatchedElements = 0;
		if (sameSize) {
			for (int i = 0; i < this.capacity; i++) {
				for (int j = 0; j < anotherList.capacity; j++) {
					if (this.array[i] == anotherList.array[j]) {
						numberOfMatchedElements ++;
						break;
					}
				}
			}
		}
		
		boolean sameContent = (numberOfMatchedElements == this.capacity);
		boolean congruent = sameSize && sameContent;
		
		if (congruent) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
		
		return (congruent);
	}
	
	/**
	 * Precondition: index is an integer.
	 * Returns the element at the specified index.
	 * Returns either the first or last element if index is out of boundary.
	 */
	public int get (int index) {
		if (index >= this.capacity) {
			int i = (int)Math.random()*2+1;
			//returns the first element
			if (i == 1) {
				return this.array[0];
			}
			//returns the last element
			else if (i == 2) {
				return this.array[capacity-1];
			}
		}
		return this.array[index];
	}
	
	/**
	 * Precondition: value is an integer.
	 * Returns the index of the first occurrence of the specified value.
	 */
	public int indexOf (int value) {
		int index = 0;
		for (int i = 0; i < this.capacity; i++) {
			if (this.array[i] == value) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Returns the capacity of the myIntArrayList.
	 */
	public int size () {
		return this.capacity;
	}
	
	/**
	 * Empties the myIntArrayList.
	 */
	public void clear () {
		this.array = new int[0];
	}
	
	/**
	 * Prints all elements of the myIntArrayList in one row delimited by one space.
	 */
	public void print () {
		for (int i = 0; i < this.capacity; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	}	
	
	/**
	 * Tests the program.
	 */
	public static void main (String[] args) {
		int[] array1 = {12,5,65,99,32,45,105,1};
		myIntArrayList list1 = new myIntArrayList (array1);
		System.out.println("Size of list 1: " + list1.size());
		list1.print();
		System.out.println();
		myIntArrayList list2 = new myIntArrayList (list1);
		System.out.println("Size of list 2: " + list2.size());
		list2.print();
		System.out.println();
		System.out.print("Equality between list 1 and list 2: ");
		list1.equals(list2);
		list1.remove(3);
		list1.add(5, 99);
		System.out.println();
		System.out.print("New list 1 after removing the element at index 3 and inserting 99 to the index 5: ");
		list1.print();
		System.out.println();
		System.out.print("Congruence between list 1 and list 2: ");
		list1.isCongruent(list2);
		System.out.println();
		System.out.print("Equality between list 1 and list 2: ");
		list1.equals(list2);
		System.out.println();
		System.out.println("Index of 105 in list 1: " + list1.indexOf(105));
		System.out.println();
		System.out.println("Element at index 5: " + list1.get(5));
		System.out.println();
		System.out.println("Element at index 8: " + list1.get(8)); //index out of bound
		System.out.println();
		list1.add(8,9);//index out of bound
		System.out.println("List 1 after inserting 9 to the index 8: ");
		list1.print();
		System.out.println();
		list1.remove(10);//index out of bound
		System.out.println("List 1 after removing the element at index 10: ");
		list1.print();
		list1.simpleSort();
		System.out.println();
		System.out.print("List 1 after being sorted: ");
		list1.print();
	}
}

