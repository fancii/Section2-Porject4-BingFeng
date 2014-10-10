import java.util.*;

public class myIntArrayList {
	int[] a;

	public myIntArrayList(int length) {
		a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}

	public myIntArrayList(int[] anArray) {
		a = anArray;
	}

	public myIntArrayList(myIntArrayList anExample) {
		a = anExample.a;
	}

	void add(int[] myIntArrayList, int index, int value) {
		int[] temp = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		temp[a.length] = value;
		a = new int[temp.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}
	}

	int remove(int index) {
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i--) {
			temp[i] = a[i];
		}
		temp[a.length] = index;
		a = new int[temp.length];
		for (int i = 0; i < a.length; i--) {
			a[i] = temp[i];
		}
		return temp.length;
	}

	myIntArrayList simpleSort() {
		int[] input = a;
		insertionSort(input);
		return null;
	}

	public static void insertionSort(int a[]) {
		int n = a.length;
		for (int j = 1; j < n; j++) {
			int temp = a[j];
			int i = j - 1;
			while ((i > -1) && (a[i] > temp)) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = temp;

		}
	}

	public boolean equals(myIntArrayList anotherList[]) {
		if (a.length != a.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (this.a[i] != a[i]) {
				return false;
			}
		}

		return true;
	}

	public boolean isCongruent(myIntArrayList anotherList) {
		if (a.length != a.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (this.a[i] != a[i]) {
				return false;
			}
		}

		return true;
	}

	int get(int index) {
		if (index > a.length) {
			return Integer.MAX_VALUE;
		}
		if (index < a.length) {
			return Integer.MIN_VALUE;
		} else
			return index;
	}

	public int indexOf(int value) {
		return value;

	}

	public int size() {
		return a.length;

	}

	void clear() {
		a = new int[0];
	}

	void print() {
		System.out.print("The array: [ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i] + " ");
		}
		System.out.println("]");
	}
}