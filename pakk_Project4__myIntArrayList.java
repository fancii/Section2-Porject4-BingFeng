
public class myIntArrayList {

	private int[] array;


	public myIntArrayList()
	{
		array = new int[0];
	}

	public myIntArrayList(int[] anArray){
		array = new int[anArray.length];
		for (int i = 0 ; i < anArray.length; i++){
			array[i] = anArray[i];
		}
	}

	public myIntArrayList(myIntArrayList anExample){
		array = new int[anExample.size()];
		for (int i = 0 ; i < anExample.size(); i++){
			array[i] = anExample.get(i);
		}
	}

	public myIntArrayList(int array_size){
		array = new int[array_size];
	}

	public void add(int index, int value){
		if (index > array.length || index < 0){
			System.out.print("index out of range,  " +
					"value added to the end of array..");
			int[] temp = {value};
			this.append(temp);
		}
		else{
			int[] temp = {value};
			this.append(temp);
			//value added to the end.
			for(int i=index; i<this.size(); i++){
			this.swapNumbers(i, (this.size()-1));
			}
		}
		
	}

	public void remove(int index){
		if(array.length == 0){
			int[] temp = new int[0];
			array = temp;
		}
		
		else if (index > array.length || index < 0){
			
			int[] temp = new int[array.length - 1];
			for(int i = 0; i < temp.length ; i++){
				temp[i] = array[i];
			}
			array = temp;
			
			System.out.print("index out of range,  " +
					"value at the end of array removed..");
		}
		
		else{
			int[] temp = new int[array.length - 1];
			for(int i = 0; i < index ; i++){
				temp[i] = array[i];
			}
			for(int i = (index+1); i < array.length; i++){
				temp[i-1] = array[i];
			}
			array = temp;
		}
	}

	public void append(int anArray[]){

		int[] newArray = new int[anArray.length + array.length];
		for (int i = 0 ; i < array.length; i++){
			newArray[i] = array[i];
		}
		for(int i = 0; i < anArray.length; i++){
			newArray [i + array.length] = anArray[i];
		}

		array = newArray;

	}

	public myIntArrayList simpleSort() {
		myIntArrayList tempArrayList = new myIntArrayList(this);
		
		tempArrayList.BubbleSort();
		
		return tempArrayList;
		
	}

	public void BubbleSort()
	{
		int n =  array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i]  > array[k])
				{
					swapNumbers(i, k );
				}
			}
		}
	}

	public boolean equals(myIntArrayList anotherList){
		if (anotherList.size() != array.length){
			return false;}
		else{
			for (int i = 0; i < array.length ; i++){
				if (array[i] != anotherList.get(i))
					return false;
			}

			return true;
		}

	}

	public boolean isCongruent(myIntArrayList anotherList){

		if (anotherList.size() != array.length){
			return false;}
		else{
			for (int i = 0; i < array.length ; i++){
				if (array[i] != anotherList.get(i))
					return false;
			}

			return true;
		}

	}

	public int get(int index)
	{
		if (index > array.length || index < 0){
			System.out.print("Index out of range, " +
					"returning the value of the last element.");
			return array[array.length -1];
		}
		else{
		return array[index];}
	}

	public int indexOf(int value){
		int i;
		for (i = 0; i < array.length ; i++){
			if (array[i] == value){
				break;
			}
		}
		return i;
	}

	public int size(){
		return array.length;
	}


	public void clear() {
		int[] temp = new int[0];
		array = temp;
	}


	private void swapNumbers(int i, int j) {
		int temp;
		temp =  array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void print()
	{
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");

	}


}