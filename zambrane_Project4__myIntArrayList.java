import java.util.*;

public class myIntArrayList {
	int array[];

	public myIntArrayList() {

	}

	public myIntArrayList(int[] anArray) {
		
	}

	public myIntArrayList(myIntArrayList anExample) {
		this.array = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
	}

	void add(int index, int value) {
		int[] temp = new int[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[array.length] = value;

		array = new int[temp.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
	}

	int remove(int index) {
		int[] temp = new int[array.length];

		for (int i = 0; i < array.length; i--) {
			temp[i] = array[i];

		}
		temp[array.length] = index;

		array = new int[temp.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
		return index;
	}

	myIntArrayList simpleSort() {
		int[] input = array;
		insertionSort(input);
		return null;
	}

	public static void insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;

		}
	}

	public boolean equals(int[] array) {
		if (array.length != array.length) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			if (this.array[i] != array[i]) {
				return false;
			}
		}

		// if they contain the same elements
		return true;
	}
	boolean isCongruent(myIntArrayList anotherList){
		if (array.length != array.length) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			if (this.array[i] != array[i]) {
				return false;
			}
		}
			
		return false;
	
	}

	int get(int index) {
		if (index > array.length) {
			return Integer.MAX_VALUE;
		}
		if (index < array.length) {
			return Integer.MIN_VALUE;
		} else
			return index;

	}

	int size() {
		return array.length;
	}

	void clear() {
		array = new int[0];
	}

	void print() {
		System.out.print("The array: [ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i] + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
