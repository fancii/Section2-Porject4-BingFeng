/**
 *  @author   Darren Bailey                      	          *
 *  @version  1.0, 28 September 2014                          *
 *  This program is used to perform similar functions         *
 *  	which the formal ArrayList class is able to perform   *
 */
package project4;
import java.util.Scanner;

public class myIntArrayList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		int[] myList = new int[0]; 
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Size of myList: " + myList.length);
		
		System.out.println("How many numbers you want to enter? ");
		size = keyboard.nextInt();
		
	}
	public class myIntArrayList() {
		
		list = new myList[5];
		
	}
	
	public class myIntArrayList(int[] anArray) {
		
		list = new myList[i];
		for(int i=0; i < myList.length; i++){
			temp[i] = myList[i];
		}
		
		
	}
	
	public class myIntArrayList(myIntArrayList anExample) {
		
		for(int j=0; j < myList.length; j++){
			temp[i] = myList[j];
			return i;
		}
		
	}
	
	void add(int index, int value) {
		
	int[] temp = new int[anArray.length+1];
		
		for(int i=0; i < anArray.length; i++){
			temp[i] = anArray[i];
		}
		temp[anArray.length] = anInteger;
		
		anArray = new int[temp.length];
		
		for(int i=0; i < anArray.length; i++){
			anArray[i] = temp[i];
		}
		
	}
	
	int remove(int index) {
		
	}
	
	 myIntArrayList simpleSort() {
		 
		 int sort; 
		   int i;   
		   for ( int j = 1; j < this.a.length; j++ ){
		       sort = a[j];
		       i = j;

		       while ( i > 0 && a[i-1] > sort ){
		       a[i] = a[i-1];
		       i = i - 1;
		       }
		       a[i] = sort;
		    }
		}
		 
	 
	 
	 boolean equals(myIntArrayList anotherList) {
		 
		
	 }
		
	 boolean isCongruent(myIntArrayList anotherList) {
		 
	 }
	 
	 int get(int index) {
		 
	 }
	 
	 int indexOf(int value) {
		 
	 }
	 
	 int size() {
		 
			for(int i=0; i < size; i++) {
				System.out.print("Enter element " + i + ": ");
				add(myList, keyboard.nextInt());
				int[] temp = new int[myList.length + 1];
				for(int j=0; j < myList.length; j++){
					temp[j] = myList[j];
				}
				
				temp[temp.length - 1] = keyboard.nextInt();
				myList = new int[temp.length];
				myList = temp;
				
				for(int j=0; j < myList.length; j++){
					myList[j] = temp[j];
				}
			}
		 
	 }
	 
	 void clear() {
		 
		 myIntArrayList = null;
		 
	 }
	 
	 void print() {
		 
		 System.out.print("{");
			for(int i=0; i < myList.length; i++) {
				System.out.println(myList[i] + " ");
			}
			System.out.println("}");
	 	}
	 }
		
		 
	 
	 
	


