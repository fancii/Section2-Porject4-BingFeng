/**
 *  @author  Christopher Weaver                *
 *  @version  1.0, 28 September 2014           *
 *  This class recreates the ArrayList class   *
 *  using only arrays and scalar variables and *
 *  allows the adding, removal, sorting, and   *
 *  other functions associated with ArrayLists.*
 */
package project4;

public class myIntArrayList {
	// instance variables
	  private int size;
	  private static int initialsize = 10;
	  private int[] anArray = new int[initialsize];
	
	public myIntArrayList(){
		
	}
	// Constructor with a parameter that is an array.
	public myIntArrayList(int[] anArray){
		this.anArray = anArray;
	}
	// Constructor with a parameter than is another myIntArrayList
	public myIntArrayList(myIntArrayList anExample){
		print();
		anExample.print();
	}
	
	// Adds a value to the array at the specified index 
	public void add(int index, int value){
		
		size = size++;
		int[] temp = new int[size+1];
		for(int i=0; i<index; i++){
			temp[i] = anArray[i];
		}
		temp[index] = value;
		for(int i=(index+1); i<temp.length; i++){
			temp[i]=anArray[i];
		}
		anArray = temp;
		print();
	}
	// Removes a value at the specified index
	public void remove(int index){
		int[] temp = new int[size-1];
		if((index < temp.length) && (index >= 0)){
			size = size--;
			for(int i=0; i<index; i++){
				temp[i] = anArray[i];
				}
			if(index != (temp.length - 1)){
				for(int i=(index+1); i<temp.length; i++){
					temp[i] = anArray[i];
					}
				}
			anArray = temp;
			}
		
		else{
			System.out.println("Invalid index number entered.");
		}
		print();
		
	}
	// Organizes the values in the array to be least to greatest
	public myIntArrayList simplesort(){
		myIntArrayList anotherList = new myIntArrayList();
		anotherList.size = size;
		for(int i=0; i<anArray.length; i++){
			
		}
		return anotherList;
	}
	public boolean equals(myIntArrayList anotherList){
		boolean equal = true;
		if(anArray.length == anotherList.anArray.length){
			for(int i=0; i < anArray.length; i++){
				if(anArray[i] != anotherList.anArray[i]){
					equal = false;
				}
			}
		}
		else{equal = false;}
		
		return equal;
	}
	public boolean isCongruent(myIntArrayList anotherList){
		simplesort();
		anotherList.simplesort();
		if(equals(anotherList)){
			return true;
		}
		else return false;
	}
	public int get(int index){
		if(index > anArray.length ||index < 0){
			return -1;
		}
		else return anArray[index];
	}
	// Returns the index value of the specified number, if none exists, returns -1
	public int indexOf(int value){
		int index = -1;
		for(int i=0; i<anArray.length; i++){
			if(anArray[i] == value){
				index = i;
			}
		}
		return index;
	}
	// Returns the size of the array
	public int size(){
		return size;
	}
	// Resets the array to its inital conditions
	public void clear(){
		size = initialsize;
		int[] newArray = new int[size];
		anArray = newArray;
	}
	
	// Prints the array to console
	public void print(){
		System.out.println("{");
		for(int i = 0; i<anArray.length;i++){
			System.out.print(anArray[i] + " ");
		}
		System.out.print("}");
		System.out.println("");
	}

}
