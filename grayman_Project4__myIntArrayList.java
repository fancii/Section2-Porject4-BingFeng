package project4;

public class myIntArrayList {
	private int[] srcArray; // Contains the actual values of myIntArrayList
	private int length;

	public myIntArrayList(){ srcArray = new int[1]; length = 1; }
	public myIntArrayList(int[] anArray){ srcArray = copyOf(anArray, anArray.length); length = anArray.length; }
	public myIntArrayList(myIntArrayList myArrayList){ srcArray = copyOf(myArrayList.get(), myArrayList.size()); length = myArrayList.size(); }

	public void add(int value){ add(value, length); }
	public void add(int value, int index){
		index = (index<0) ? 0 : (index>length) ? length : index;
		int[] tmp = new int[length+1];
		int x = 0;
		for(int y = 0; y<tmp.length; y++){
			if(y==index){
				tmp[y] = value;
				continue;
			}
			tmp[y] = srcArray[x];
			x++;
		}
		srcArray = copyOf(tmp);
		length+=1;
	}

	public void remove(){ remove(length); }
	public void remove(int index){
		index = (index<0) ? 0 : (index>=length) ? length-1 : index;
		int[] tmp = new int[length-1];
		
		int x=0;
		for(int y=0; y<length; y++){
			if(y!=index){ tmp[x] = srcArray[y]; x++; }
		}
		srcArray = copyOf(tmp);
		length-=1;
	}

	public myIntArrayList simpleSort(){ // Don't actually sort; just return sorted version; maybe add one to actually sort
		int[] tmp = copyOf(srcArray);
		
		// Iterating over the array from left to right,
		for(int y=0; y<length; y++){
			int x = y;
			
			// Store original element's value for comparison (as well as a temp backup if it has to be moved)
			int bak = srcArray[y];
			// Find each successive element's rightful position to the left
			int moveTo = -1;
			while(x>0){ if(bak<tmp[x-1]){ moveTo = --x; }else{ break; }}
			
			// Shift everything from it's rightful place to it's current place to the left
			if(moveTo!=-1){
				for(x = y; x>moveTo; x--){
					tmp[x] = tmp[x-1];
				}
				// And insert it where it belongs 
				tmp[x] = bak;
			}
		}
		return new myIntArrayList(tmp);
	}

	private int[] copyOf(int[] arr){ return copyOf(arr, arr.length); }
	private int[] copyOf(int[] arr, int newLength){
		int[] tmp = new int[newLength];
		for(int x=0; x<arr.length; x++){ tmp[x] = arr[x]; }
		return tmp;
	}
	private int[] copyOf(int[] arr, int startBound, int endBound){
		if(endBound<startBound){ int tmp=endBound; endBound=startBound; startBound=tmp; }
			if(startBound<=0){ startBound = 0; }
			if(endBound>length){ endBound = length; }
			
		int newLength = (endBound-startBound)+1;
		int[] tmp = new int[newLength];
		for(int x=0; x<newLength; x++){
			tmp[x] = arr[startBound++];
		}
		
		return tmp;
	}

	public boolean equals(myIntArrayList anotherList){
		if(anotherList.size() != length){ return false; }
		for(int x = 0; x<length; x++){
			if(srcArray[x] != anotherList.get(x)){ return false; }
		} return true;
	}
	public boolean isCongruent(myIntArrayList anotherList){
		if(anotherList.size() != length){ return false; }
		myIntArrayList list1 = simpleSort();
		myIntArrayList list2 = anotherList.simpleSort();
		
		for(int x = 0; x<length; x++){
			if(list1.get(x) != list2.get(x)){ return false; }
		} return true;
	}

	public int[] get(){ return srcArray; } // Get entire srcArray
	public int get(int index){
		index = (index<0) ? 0 : (index>=length) ? length-1 : index;
		return srcArray[index];
	}

	public void set(int index, int value){
		if(index<0){ index = 0; }
		// Extend the array if index is out of bounds
		if(index>=length){ srcArray = copyOf(srcArray, index+1); length = index+1; }
		srcArray[index] = value;
	}
	public void set(int[] newArray){ srcArray = copyOf(newArray); length = newArray.length; }
	
	public int indexOf(int value){
		for(int x = 0; x<length; x++){ if(srcArray[x] == value){ return x; }}
		return -1;
	}
	public int lastIndexOf(int value){
		for(int x = length-1; x>=0; x--){ if(srcArray[x] == value){ return x; }}
		return -1;
	}
	public int[] indicesOf(int value){
		int[] tmp = new int[length]; // Max possible length; will trim later
			  tmp[0] = -1; // This means no match found; will overwrite if one is
		int count = 0;

		for(int x=0; x<length; x++){ if(srcArray[x] == value){ tmp[count++] = x; }}
		tmp = copyOf(tmp, 0, count-1);
		return tmp;
	}

	public int size(){ return length; }
	public void clear(){ srcArray = new int[1]; length=1; }
	public void print(){
		String printArr = "";
		for(int x : srcArray){ printArr += x + ", "; }
		System.out.println("[" + printArr.substring(0, printArr.length()-2) + "]");
	}
}
