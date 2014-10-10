/**Michael Alcena
* @Version 1.2
* 09/28/2014
* This program creates a simple sorting array class
*/

public class myIntArrayList {
	private int[] Array;
	private int size;

	// Default Constructor
	// Creates an initial myIntArrayList with a set size of 0.
	public myIntArrayList() {
		setSize(0);
	}

	// Alternate Constructor 1
	// Creates a myIntArrayList that copies the size and contents of an array
	// parameter.
	public myIntArrayList(int[] anArray) {
		setSize(anArray.length);
		Array = new int[size()];
		for (int i = 0; i < size(); i++) {
			setArray(i, anArray[i]);
		}
	}

	// Alternate Constructor 2
	// Creates a myIntArrayList that copies the size and contents of an
	// myIntArrayList parameter.
	public myIntArrayList(myIntArrayList anExample) {
		setSize(anExample.size());
		Array = new int[size()];
		for (int i = 0; i < size(); i++) {
			setArray(i, anExample.get(i));
		}
	}

	// This method inserts a value in to the myIntArrayList at the given index
	// parameter. If the index is
	// out of bounds of the myIntArrayList the number is added to the beginning
	// of the list.
	public void add(int index, int value) {
		int a = value;
		int b = 0;
		int[] temp = new int[size() + 1];
		for (int i = 0; i < size(); i++) {
			temp[i] = get(i);
		}

		setSize(size() + 1);
		Array = new int[size()];
		if (index < size()) {
			for (int position = 0; position < size(); position++) {
				if (position < index) {
					setArray(position, temp[position]);
				} else {
					if (a == value) {
						a = temp[position];
						setArray(position, value);
					} else {
						b = a;
						a = temp[position];
						setArray(position, b);
					}
				}
			}
		} else {
			System.out
					.println("Index out of bounds, adding to the beginning of the list. ");
			for (int position = 0; position < size(); position++) {
				if (a == value) {
					a = temp[position];
					setArray(position, value);
				} else {
					b = a;
					a = temp[position];
					setArray(position, b);
				}
			}
		}
	}

	// This method removes the value at a given index and shifts the remaining
	// values up in the list.
	// If the index given is out of bounds then the first value in the list will
	// be removed.
	public int remove(int index) {
		int[] temp = new int[size()];
		for (int i = 0; i < size(); i++) {
			temp[i] = get(i);
		}

		setSize(size() - 1);
		Array = new int[size()];
		if (index < size() + 1) {
			for (int j = 0; j < size(); j++) {
				if (j <= index) {
					setArray(j, temp[j]);
				} else {
					setArray(j, temp[j + 1]);
				}
			}
			return temp[index];
		} else {
			for (int i = 0; i < size(); i++) {
				setArray(i, temp[i + 1]);
			}
			return temp[0];
		}
	}

	// This method checks to see if the myIntArrayList is equal otherwise return
	// 0
	public boolean equals(myIntArrayList anotherList) {
		boolean check = true;
		for (int i = 0; i < size(); i++) {
			if (get(i) != 0) {
				check = false;
			}
		}
		return check;
	}

	// This method returns the value found at a given index parameter within the
	// myIntArrayList.
	public int get(int index) {
		if (index < size()) {
			return Array[index];
		} else {
			return Array[0];
		}
	}

	// This method returns the index of a given value within the myIntArrayList.
	// If the index is out of bounds
	// the method returns 0.
	public int indexOf(int value) {
		int index = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i) == value) {
				index = i;
			}
		}
		return index;
	}

	// returns the value of the size integer variable.
	public int size() {
		return size;
	}

	// Sets the size variable to the integer specified.
	public void setSize(int Size) {
		size = Size;
	}

	// Sets the value at position index equal to the specified value parameter.
	public void setArray(int index, int value) {
		Array[index] = value;
	}

	// Clears the array of data by overwriting the old array with a new one of
	// the same size.
	public void clear() {
		Array = new int[size()];
	}

	// Prints out the contents of the array.
	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.print(get(i));
			if (i == size() - 1) {
			} else {
				System.out.print(", ");
			}
		}
		System.out.print(".\n");
	}

}
 