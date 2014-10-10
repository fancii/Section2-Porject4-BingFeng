/**
 * @author Joe Regalbuto
 * @version 1.0, 26, September 2014
 * This program creates a class similar to Java's arrayList class. It creates and implements methods for array objects
 */
public class myIntArrayList {
	static int [] myIntArrayList;
	public myIntArrayList(){
		myIntArrayList= new int [5];
		myIntArrayList[0] = 10;
		myIntArrayList[1] = 8;
		myIntArrayList[2] = 6;
		myIntArrayList[3] = 4;
		myIntArrayList[4] = 2;
	}//first constructor that creates an array of length 5

	public myIntArrayList(int [] array){

		for(int i = 0; i>myIntArrayList.length; i++){
			myIntArrayList[i] = array[i];
		}
	}//second constructor that takes an array parameter and creates another array with the same values
	public myIntArrayList(myIntArrayList anotherArray){
		myIntArrayList arrayList = new myIntArrayList();
	}//copy constructor that creates another myIntArrayList object that is a copy of the passed myIntArrayList object

	public void add(int[] myIntArrayList2, int value){

		int [] temp = new int[myIntArrayList.length+1];//temp array that is 1 element larger than the parameter array
		for(int i = 0; i < myIntArrayList.length; i++){
			temp[i] = myIntArrayList[i];
		}//fills each element of temp with the same value as other array
		temp[myIntArrayList.length]= value;//puts the value that we want to add into temp
		myIntArrayList = new int [temp.length];//makes our array 1 element longer to make room for the added value
		for(int i =0 ; i< myIntArrayList.length;i++){
			myIntArrayList[i] = temp[i];
		}//our array now matches with temp including the added value

	}//method adds the second parameter value onto the end of the first parameter array as the array's next element
	@SuppressWarnings("null")
	public int[] remove (int index){
		int x = myIntArrayList.length;
		if((x-index)>0){
			int value = myIntArrayList[index];//assigns new variable to the value that matches the index
			myIntArrayList[index]=(Integer) null;//sets the new value to null
			int temp = index;
			while(temp<x){
				myIntArrayList[temp]=myIntArrayList[temp+1];
				myIntArrayList[temp+1]=(Integer) null;
				temp++;
			}//while the index is less than the length of the array each element gets moved up to fill where the removed value was

		}//if statement makes sure index is within the array's boundaries
		x--;//as each element is removed the length of the array becomes one less
		return myIntArrayList;//returns the array with the removed value gone

	}
	public int[] simpleSort(){
		int temp;
		boolean z = false;
		while(z==false){
			z=true;
			for(int i = 0;i<myIntArrayList.length-1;i++)

				if(myIntArrayList[i]>myIntArrayList[i+1]){
					temp = myIntArrayList[i+1];
					myIntArrayList[i+1]=myIntArrayList[i];
					myIntArrayList[i]=temp;
					z=false;
				}
		}
		return myIntArrayList;//returns the newly sorted array
	}

	public boolean equals(int[] array){
		if(myIntArrayList.length!=array.length){
			System.out.println("The arrays are unequal because they are of different sizes." + "\n 0");
			return false;//first checks to see if the arrays are of equal length if they aren't they can't be equal
		}
		for(int i=0;i<myIntArrayList.length;i++){
			if(myIntArrayList[i]!=array[i]){
				System.out.println("0");//returns a 0 because one of the elements did not match so the arrays can't be equal
				System.exit(0);
				return false;	
			}
		}
		System.out.println("1");//each element matches so the arrays are equal
		return true;
	}
	public boolean isCongruent(int[] array){
		if(myIntArrayList.length!=array.length){
			System.out.println("The arrays are not congruent because they are of different sizes." + "\n 0");
			return false;//if the arrays are of different sizes they cannot be congruent
		}
		for(int i = 0; i<myIntArrayList.length;i++){
			int value = array[i];
			for(int j =0; j<array.length;j++){
				if(array[j]==myIntArrayList[i]){
					value=array[i+1];
					if(value==myIntArrayList[myIntArrayList.length-1]){
						return true;//each element is found in both arrays and they are the same length so they are congruent
					}
					else return false;//at least one element was in one array but not the other so they are not congruent
				}
			}

		}
		return true;//each element and their indices matched and they are congruent
	}	
	public int get(int index){
		return myIntArrayList[index];
	}//returns the element that is held at the index passed into the method
	public int indexOf(int value){
		int count=0;
		int x=0;
		for(int i = 0;i<myIntArrayList.length;i++){
			if(myIntArrayList[i]==value){
				x=count;
			}//if statement tests to see if any element of the array is equal to the value, if it is x is given the index of the value to hold
		}
		count++;
		return x;//the index of the value is returned
	}
	public int size(){
		System.out.println("This array is " + myIntArrayList.length + " elements long.");
		return myIntArrayList.length;
	}//returns the number of elements in an array
	public void clear(){
		myIntArrayList=null;
		System.out.println("This array has been cleared");
	}//clears all the elements of an array

	public void print(){
		for(int i = 0; i< myIntArrayList.length;i++){
			System.out.print(myIntArrayList[i] + " ");
		}
		System.out.println("\n");
	}//displays each element of the array
	public static void main(String[] args) {
		myIntArrayList myList1 = new myIntArrayList();//creation of first arrayList
		myIntArrayList myList2 = new myIntArrayList(myIntArrayList);
		myIntArrayList myList3 = new myIntArrayList(myList2);//copy of list 2
		myIntArrayList myList4 = new myIntArrayList(myList3);//extra copy to demonstrate clear method
		myList1.size();//demonstrates size method
		myList1.print();
		myList2.add(myIntArrayList,15);//add method called
		myList2.simpleSort();//demonstrates that the sort method works
		myList2.size();
		myList2.print();//sorted array is displayed with the added element
		myList3.size();
		myList3.print();//exact copy of the second object is made
		myList4.clear();
	}

}