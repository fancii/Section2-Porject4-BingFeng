import java.util.ArrayList;
import java.util.Scanner;

/**
* @author Kyler Chern *
* @version 1.2, 27 September 2014 *
* This program creates an arrayList out of an array by making add/remove
* and other arrayList methods for array's
*/
public class myIntArrayList {
private int [] myList;
private int size;
public boolean flag;
public boolean flag2;


/**Default constructor*/
	myIntArrayList(){
		myList = new int [0];
		size = 0;
	}
	/**Alternative constructor that takes an initial array and passes it
	 * through the constructor*/
	myIntArrayList(int [] anArray){
		myList = new int[anArray.length];
		for(int i = 0;i<anArray.length;i++){
			myList[i] = anArray[i];
		}
		size = anArray.length;
	}
	/**Copy constructor*/
	myIntArrayList(myIntArrayList aList){
		myList = new int [aList.size()];
		for(int i = 0;i<aList.size();i++){
			myList[i] = aList.get(i);
		}
		
	}
	/**Method to get size of the object, size is updated with each
	 * add/remove method*/
	public int size(){
		return size;
	}
	/**A method to sort an array using an insertion sort,but
	 * return a new one so as not to change the origional*/
	public myIntArrayList simpleSort(){
		int[] temp = new int[size];
	for(int i = 0;i<size;i++){
		temp[i] = myList[i];
	}
	for(int i = 0;i<size();i++){
		int j =i;
		while(j>0 && myList[i] < temp[j-1]){
			temp[j] = temp[j-1];
			j--;
		}
		temp[j] = myList[i];
	}
		return new myIntArrayList(temp);
		
	}
	
	/**Method to get a certain value from the array, if the index is 
	 * out of bounds it will either return the first or last value*/
	public int get(int index){
		int val;
		if(index <= 0){
			val = myList[0];	
		}
		else if(index>=(myList.length - 1)){
			val = myList[myList.length -1];
		}
		else{
			val = myList[index];
		}
		return val;
	}
	/**Index of method to return the index of an input value in the array*/
	public int indexOf(int value){
		int index = -1;
		for(int i = 0; i<size;i++){
			if(myList[i] == value){
				index = i;
			}	
		}
		return index;
	}
	/**Boolean method to determine if two myIntArrayList's are equal*/
	public boolean equals(myIntArrayList aList){
	
		if(size == aList.size()){
			for(int i = 0;i<size;i++){
				if(this.get(i) == aList.get(i)){
					flag = true;
				}
				else{
					flag = false;
					break;
				}
			}
		}
		else{
			flag = false;
			}
		return flag;
	}
	/**Congruency method to test if to myIntArrayList's 
	 * are of the same size and have the same values*/
	public boolean isCongruent(myIntArrayList aList){
		
		myIntArrayList test2 = aList.simpleSort();
		myIntArrayList test1 = this.simpleSort();
		
		if(test1.size() == test2.size()){
			for(int i = 0;i<size;i++){
				if(test1.get(i) == test2.get(i)){
					flag2 = true;
				}
				else{
					flag2 = false;
					break;
				}
			}
		}
		else{
			flag2 = false;
			}
		return flag2;
	}
	
	/**Add method to append a number to anywhere in the list, it  takes an
	 * index and value, if the index is below 0 it appends to the beginning 
	 * if it is greater than the size of the list it appends to the end
	 */
	public void add(int index, int value){
		size++;
		int[] temp = new int[size]; 
	if(index <=0){
		temp[0] = value;
		for(int i = 1;i<size;i++){
			temp[i] = myList[i-1]; 
		}
		myList = temp;
	}
	else if(index >= size -1){
		temp[size - 1] = value;
		for(int i = 0;i<size -1;i++){
			temp[i]=myList[i];
		}
		myList = temp;
	}
	else{
		
		for(int i =0;i<index;i++){
			temp[i] = myList[i];
		}
		temp[index] = value;
		for(int i = index +1;i<size;i++){
			temp[i] = myList[i-1];
		}
		myList = temp;
	}	
	}
	/**Remove method to remove a value at the given index, if the index
	 * is out of bounds it will remove the first or last*/
	public int remove(int index){
		size--;
		int[] temp = new int[size];
		if(index <=0){
			index = 0;
		}
		else if(index>=0){
			index = (size-1);
		}
		if(index <= 0){
			temp[0] = myList[1];
			for(int i =1;i<size;i++){
				temp[i] = myList[i+1];
			}
			myList = temp;
		}
		else if(index >= size -1){
			for(int i =0;i<size;i++){
				temp[i] = myList[i];
			}
			myList = temp;
		}
		else{
			for(int i =0; i<index;i++){
				temp[i] = myList[i];
			}
			for(int i =index;i<size;i++){
				temp[i] = myList[i];
			}
		myList = temp;
		}
		return myList[index];
	}
		
	/**Print method to print the values of the object array*/
	public void print(){
		System.out.print("{");
		for(int i = 0;i<myList.length;i++){
			System.out.print(myList[i] + " ");
		}
		System.out.print("}");
	}
	/**Clear method to wipe out an array*/
	public void clear(){
		size = 0;
		
		int[] temp = new int[0];
		
		myList = temp;

	}
	/**Getter for the boolean of the equals method*/
	public boolean getFlag(){
		return flag;
	}
	/**Getter for the boolean of the congruent method */
	public boolean getFlag2(){
		return flag2;
	}
}
