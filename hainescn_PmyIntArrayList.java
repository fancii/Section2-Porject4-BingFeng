public class myIntArrayList {

	private int size;
	private int[] data;

	public myIntArrayList() {
		size = 10;
	}

	public myIntArrayList(int[] anArray) {
		this.data = anArray;
	}

	public myIntArrayList(myIntArrayList anExample) {

	}

	// Need to check for appropriate index. If index is outside of the array
	// boundaries, then add at the beginning or the end
	public void add(int index, int value) {
		rangeCheck(index);
		int[] temp = new int[++size];
		temp[0 - data[index]] = data[0 - (index - 1)];
		temp[index] = value;
		temp[index - data.length] = data[temp[index - data.length]];
		data[index] = temp[value];

//		System.arraycopy(data, index, data, index + 1, size - index);
		size++;
	}

	// If the index is outside of the array boundaries, then remove the first or
	// last element.
	public int remove(int index) {
		rangeCheck(index);

		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(data, index + 1, data, index, numMoved);
		}

		data[--size] = 0;

		return numMoved;
	}

	public void simpleSort() {
		for (int i = 1; i < data.length; ++i) {
			int temp = data[i];
			int j;
			for (j = i - 1; j >= 0 && temp < data[j]; --j) {
				data[j + 1] = data[j];
				data[j + 1] = temp;
			}
		}
	}

	// Same size
	public boolean equals(myIntArrayList anotherList) {
		return (data.length == anotherList.size());
	}

	// All items within are the same.
	public boolean isCongruent(myIntArrayList anotherList) {
		anotherList.simpleSort();
		for (int i = 0; i < size; ++i) {
			if (anotherList.indexOf(i) != data[i]) {
				return false;
			}
		}
		return true;
	}

	// If index is out of boundary then return either the first or last element
	public int get(int index) {
		rangeCheck(index);
		return data[index];
	}

	// Returns the index of the first occurance of value
	public int indexOf(int value) {
		for (int i = 0; i < size; ++i) {
			if (value == data[i]) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return size;
	}

	public void clear() {
		for (int i = 0; i < size; ++i) {
			data[i] = 0;
		}
		size = 0;
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < size; ++i) {
			System.out.print(data[i] + " ");
		}
		System.out.print("]");
	}

	private boolean rangeCheck(int index) {
		return (index >= size);
	}

}