package dynamicArray;

public class DynamicArrayMain {
	
	public static void main(String[] args) {
		DynamicArray d = new DynamicArray();
		
		for(int i = 0; i < 11; i ++)
			d.push(i + 1);
		d.print();
		System.out.println(d.size());
		d.print();
	}
}
