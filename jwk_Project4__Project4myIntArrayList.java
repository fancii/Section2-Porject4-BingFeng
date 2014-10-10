
/**
 * @author Joshua Kleppinger
 * @version 1.2, 25 September 2014
 *	A class designed to work as an Array of changeable size for Integers
 */
public class myIntArrayList {

	/**
	 * This is the actual Array List that will be adjusted
	 */
	private int[] myIntArray;
	
	/**
	 * The default constructor sets myIntArray to size 0 as it has no values yet
	 */
	public myIntArrayList(){
		myIntArray = new int[0];
	}
	/**
	 * Constructs a myIntArrayList from an array of integers
	 * @param anArray - The array that is copied to the IntArrayList
	 */
	public myIntArrayList(int[] anArray){
		//Assigns the length of the private integer array to be equal to the length of array parameter
		myIntArray = new int[anArray.length];
		//adds the values of anArray to myIntArray
		for (int i = 0;i < myIntArray.length; i++)
			myIntArray[i] = anArray[i];
	}
	/**
	 * Copies values from one myIntArrayList to a new myIntArrayList
	 * @param anExample - The myIntArrayList that is to be copied
	 */
	public myIntArrayList(myIntArrayList anExample){
		//sets the length of myIntArray to be that of the size of anExample
		myIntArray = new int[anExample.Size()];
		//Assigns the values from anExample to myIntArray
		for (int i =0; i < anExample.Size(); i++){
			myIntArray[i] = anExample.getMyIntArray()[i];
		}
	}
	/**
	 * Basically for use in a test class this would turn the myIntArrayList into an integer Array
	 * 		however, realistically it just returns the private variable
	 * @return myIntArray
	 */
	public int[] getMyIntArray(){
		return myIntArray;
	}
	/**
	 * Adds an Integer to a  myIntArrayList at a certain location within the myIntArrayList
	 * @param index - The location the Integer is to be added
	 * @param value - The value of the integer to be added
	 */
	public void add(int index, int value){
		//constructs a Temporary Array to copy values from myIntArray
		int[] Temp = new int[myIntArray.length];
		//copies the values from myIntArray to Temp
		for (int i = 0; i < myIntArray.length; i++){
			Temp[i] = myIntArray[i];
		}
		//myIntArray is reconstructed with a length of one greater than it previously was
		myIntArray = new int[Temp.length + 1];
		//If the index is set to stupid location out of range, the value is simply to be placed in the front 
		if (index >= myIntArray.length || index < 0){
			//all the initial values of myIntArray are displaced by +1
			for(int j = 1; j < myIntArray.length; j++){
				myIntArray[j] = Temp[j - 1];
			}
			//the value to be added is placed in the first spot of the list
			myIntArray[0] = value;
		}
		//Otherwise the value is placed at the specified index with everything after it being shifted forward
		else{
			//all the values before the index are placed back into the position they were originally at
			for(int k = 0; k < index; k++){
				myIntArray[k] = Temp[k];
			}
			//All the values that were originally at the specified index or greater are shifted +1
			for(int n = index + 1; n < myIntArray.length; n++){
				myIntArray[n] = Temp[n-1];
			}
			//the specified value is placed at the specified index
			myIntArray[index] = value;
		}
	}
	/**
	 * Removes an Integer from the myIntArrayList
	 * @param Index - the position in the list of the Integer that is to be removed
	 */
	public void remove(int Index){
		//Constructs a Temporary Int Array that is 1 unit shorter than myIntArray for copying purposes
		int[] Temp = new int[myIntArray.length - 1];
		//If the index is less than 0 the program assumes you meant 0
		if (Index < 0){
			//The values of Temp are all of the values of myIntArray except the first one, no order change
			for(int i = 0; i < Temp.length; i++){
				Temp[i] = myIntArray[i+1];
			}
		}
		//If the index is greater than the original length of myIntArray, the program assume you meant the last value
		if (Index > myIntArray.length){
			//copies the myIntArray to Temp with the exception of the last value of myIntArray
			for(int i = 0; i < Temp.length; i++){
				Temp[i] = myIntArray[i];
			}
		}
		//Removes the value of myIntArray at the specified index
		else{
			//The values before the index remain the same and a translated to Temp
			for (int j = 0; j < Index; j++){
				Temp[j] = myIntArray[j];
			}
			//the values after the index are shifted back one though Temp
			for (int k = Index; k < Temp.length; k++){
				Temp[k]= myIntArray[k+1];
			}
		}
		//Sets the new length of myIntArray which will be one less
		myIntArray = new int[Temp.length];
		//Copies the Temporary Array to myIntArray
		for (int n = 0; n < myIntArray.length; n++){
			myIntArray[n] = Temp[n];
		}
	}
	/**
	 * A simple insertion sort for myIntArrayList
	 * @return the sorted myIntArrayList
	 */
	public myIntArrayList simpleSort(){
		//for each position of myIntArray, the program continually shifts the value down the list until the next value is less than it
		for (int i = 0; i<myIntArray.length; i++){
			//Sets the value of myIntArray at the specific position to anInt
			int anInt = myIntArray[0];
			//Checks to see it is greater the next value down the list is greater than or less than anInt
			for (int j = 1; j < myIntArray.length; j++){
				//If anInt is less than then the compared value is shifted forward one
				if (anInt < myIntArray[j]){
					myIntArray[j-1] = myIntArray[j];
					myIntArray[j] = anInt;
				}
				//if anInt is greater than the compared value, then it will take it position at the spot ahead of the compared value
				else if (anInt >= myIntArray[j]){
					myIntArray[j-1] = anInt;
					break;
				}
			}
		}
		//constructs the newly sorted list from the new values of myIntArray
		myIntArrayList sortedList = new myIntArrayList(myIntArray);
		//then returns the new list
		return 	sortedList;	
	}
	/**
	 * Checks to see if two myIntArrayLists are completely identical
	 * @param anotherList - The myIntArrayList that is being compared
	 * @return whether the myIntArrayLists are congruent
	 */
	public boolean isCongruent(myIntArrayList anotherList){
		//assumes the two arrays to be equal 
		boolean equal = true;
		//If the sizes of myIntArrayLists are not equal then it is automatically false
		if (anotherList.getMyIntArray().length != myIntArray.length){
			equal = false;
		}
		//otherwise if the sizes are equal, then it will check for congruence
		else if(anotherList.getMyIntArray().length == myIntArray.length){
			//Checks if the value at position i in each array is equal
			for (int i = 0; i < myIntArray.length; i++){
				//if not equal, it is not congruent
				if (anotherList.getMyIntArray()[i] != myIntArray[i]){
					equal = false;
				}
			}
		}
		//returns whether or not the myIntArrayLists are congruent or not
		return equal;
	}
	/**
	 * Checks to see if the arrays have equal values (not necessarily in same order)
	 * @param anotherList - the myIntArrayList that is being compared
	 * @return whether or not the arrays are equal
	 */
	public boolean equals(myIntArrayList anotherList){
		//It is assumed that the myIntArrayLists are not equal
		boolean equal = false;
		//Creates a Temporary int array
		int[] Temp = new int[anotherList.getMyIntArray().length];
		//Copies the values from anotherList to the tempory array
		for (int p = 0; p < anotherList.Size(); p++){
			Temp[p] = anotherList.getMyIntArray()[p];
		}
		//If the lengths are different, then they are definitely not equal
		if (anotherList.getMyIntArray().length != myIntArray.length){
			equal = false;
		}

		//If the lengths are equal, the program will check for value equality
		else if(anotherList.getMyIntArray().length == myIntArray.length){
			//creates a list of booleans to check if all values are true or false
			boolean[] booleanList = new boolean[myIntArray.length];
			//All values in the boolean array are assumed to be false
			for (int k = 0; k<booleanList.length; k++){
				booleanList[k]=false;
			}
			//for each value in the first myIntArrayList
			for (int i = 0; i < myIntArray.length; i++){
				//j represents the position of the second myIntArrayList
				int j = 0;
				//a loop will run as long as or j is less than the length of the second myintArrayList
				do {
					//1 is immediately added to j 
					//if the value of the 2nd list in equal to a value in the first
					if (myIntArray[i] == anotherList.getMyIntArray()[j]){
						//the boolean in the list at the same index as the integer currently being compared in the first list is set to true
						booleanList[i] = true;
						//the equivalent value in the second list is removed from its list
						anotherList.remove(j);
						//the do loop is broken so the program to move on to the next index in the first list
						break;
					}
					j = j + 1;
				}while(j < anotherList.getMyIntArray().length);
			}
			//Restores the other list
			for (int d = 0; d < Temp.length; d++){
				anotherList.add(d, Temp[d]);
			}
			//Checks to make sure all the values in the boolean are list are true
			for (int h = 0; h < booleanList.length; h++){
				//If all are true then the myIntArrayLists are equal
				if(booleanList[0] && booleanList[h] == true){
					equal = true;
				}
				//If there is a single false, then they are not equal
				else{
					equal = false;
					break;
				}
			}
		}
		//returns whether the two myIntArrayLists are equal or not
		return equal;
	}
	/**
	 * Returns the Integer at a specific index of the myIntArrayList
	 * @param index - the position in the myIntArrayList
	 * @return
	 */
	public int get(int index){
		//the value is initialized to 0 for the hell of it
		int value = 0;
		//if the index is less than 0, the program assumes you meant 0
		if(index < 0){
			value = myIntArray[0];
		}
		//if the index is greater than the length of myIntArray, the program assumes you meant the last index
		else if(index > myIntArray.length){
			value = myIntArray[myIntArray.length - 1];
		}
		//otherwise value is equal to the value at the specified index
		else{
			value = myIntArray[index];
		}
		//returns value
		return value;
	}
	/**
	 * Returns the index of the first instance of the specified value in the myIntArrayList
	 * @param value - the specified value
	 * @return - the index, returns -1 if the value does not exist in the myIntArrayList
	 */
	public int indexOf(int value){
		//the index is defaulted to -1
		int index = -1;
		//checks to see if that value exists in the myIntArray
		for (int i = 0; i < myIntArray.length; i++){
			//if it does, the index is set to the index containing that value and then ends the loop 
			if (myIntArray[i] == value){
				index = i;
				break;
			}
		}
		//returns the index
		return index;
	}
	/**
	 * Gives the size of myIntArrayList
	 * @return the length of myIntArrayList
	 */
	public int Size(){
		//the length of myIntArray
		return myIntArray.length;
	}
	/**
	 * Resets the myIntArrayList to size 0
	 */
	public void clear(){
		myIntArray = new int[0];
	}
	/**
	 * Prints out the values of myIntArrayList
	 */
	public void print(){
		//Informs the user that it is printing
		System.out.println("Printing Array...");
		//{Prints out each value
		for(int i = 0; i < myIntArray.length; i++){
			System.out.println(myIntArray[i]);
		}
	}
	
}
