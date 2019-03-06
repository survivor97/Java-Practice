package exercises;

import java.util.Arrays;

//This class is a collection that stores elements of type int
//It is similar to the ArrayList<E> collection

public class MyIntArrayList {
	
	private int[] list;
	private int size;
	
	MyIntArrayList() {
		list = new int[10];
	}
	
	MyIntArrayList(int initialCapacity) {
		list = new int[initialCapacity];		
	}
	
	MyIntArrayList(MyIntArrayList c) {
		list = new int[c.size];
		size = c.size;
		for(int i=0; i<c.size; i++) {
			list[i] = c.get(i);
		}		
	}
	
	public boolean add(int element) {		
		if(size == list.length) {
			resize();
		}
		list[size] = element;
		size++; 
		return true;
	}
	
	void add(int index, int e) {
		for(int i = size; i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = e;
		size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public int get(int index) {
		return list[index];
	}
		
	public void print() {
		for(int i=0; i<size; i++) {
			System.out.print(list[i]+" ");
		}
	}
	
	public int indexOf(int e) {
		for(int i=0; i<size; i++) {
			if(list[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(int e) {
		for(int i=size-1; i>=0; i--) {
			if(list[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(int e) {
		for(int i=0; i<size; i++) {
			if(list[i] == e) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		size = 0;
	}
	
	public int set(int index, int e) {
		int oldValue = list[index];
		list[index] = e;
		return oldValue;
	}
	
	public boolean addAll(MyIntArrayList c) {
		int oldSize = size;
		int counter = 0;
		size += c.size();
		if(size >= list.length) {
			resize();
		}
		while(oldSize < size) {			
			list[oldSize] = c.get(counter);
			oldSize++;
			counter++;
		}
		return true;
	}
	
	public boolean addAll(int index, MyIntArrayList c) {
		
		//Verify
		if(index > size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		
		//Do the job
		int counter = 0;
		int oldSize = size;
		int cSize = c.size();
		
		size += c.size();		
		
		if(size >= list.length) {
			resize();
		}
		
		for(int i = index; i < index + cSize; i++) {
			
			if(i < oldSize) {
				list[i+cSize] = list[i];
			}
			
			list[i] = c.get(counter);
			counter++;
			
		}

		return true;
	}
	
	public boolean remove(int index) {
		for(int i=index; i<size-1; i++) {
			list[i] = list[i+1];
		}
		size--;
		return true;
	}
	
	public int[] toArray() {
		return Arrays.copyOf(list, size);
	}
	
	public void ensureCapacity(int minCapacity) {
		if(list.length < minCapacity) {
			resize();
		}
	}
	
	public void trimToSize() {
		int[] resizedArray = new int[size];
		for(int i=0; i<size; i++) {
			resizedArray[i] = get(i);
		}
		list = resizedArray;
	}
	
	private void resize() {
		list = Arrays.copyOf(list, size * 2);	
	}
		
}
