package dynamicArray;

public class DynamicArray {
	private int arr[], arr1[];
	private static int sizeOfArray;
	private int currentIndex = 0;
	private static int arrayWidth = 5;
	public DynamicArray() {
		arr = new int[5];
	}
	
	public void push(int element) {
		if(sizeOfArray < arrayWidth) {
			arr[currentIndex] = element;
			currentIndex ++;
			sizeOfArray ++;
		}
		else if(sizeOfArray == arrayWidth) {			
			arr1 = new int[sizeOfArray]; 
			for(int i = 0; i < arr1.length; i ++)
				arr1[i] = arr[i];
			arr = new int[2 * sizeOfArray];
			arrayWidth = 2 * sizeOfArray;
			for(int i = 0; i < arr1.length; i ++)
				arr[i] = arr1[i];
			
			arr[currentIndex] = element;
			currentIndex ++;
			sizeOfArray ++;
		}
		
	}
	
	public int size() {
		return sizeOfArray;
	}
	
	public void set(int val, int index) {
		if(index <= sizeOfArray)
			arr[index] = val;
		else {
			System.out.println("enter correct index !!");
			return;
		}
	}
	
	public int get(int index) {
		if(index <= sizeOfArray)
			return arr[index];
		else {
			System.out.println("enter correct index !!");
			return -1;
		}
	}
	
	public boolean isEmpty() {
		if(sizeOfArray > 0)
			return false;
		else
			return true;
	}
	
	public void removeLast() {
		arr[currentIndex - 1] = 0;
		currentIndex --;
	}
	
	public void print() {
		for(int i = 0; i < sizeOfArray; i ++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}



//push function which will push an element at the end
//size function return size of the array (as per elements)
//set function replace a value at i-th position
//get function return a value from i-th position
//isEmpty function returns whether array empty or not
//removeLast function remove the last element
//print function will print the array

