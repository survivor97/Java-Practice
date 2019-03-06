package infix_to_postfix_radix_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class RadixSort {

	public static int[] sortAscending(int[] numbers) {
		int[] sortArray = new int[numbers.length];
		int biggestValue = 1;
		int currentUnit = 1;
		
		//ArrayDeque
		ArrayList<ArrayDeque<Integer>> queueList = new ArrayList<ArrayDeque<Integer>>();
		
		for(int i = 0; i < 10; i++) {
			queueList.add(new ArrayDeque<Integer>());
		}		
		
		//Assign values + get the biggest value
		for(int i=0; i<numbers.length; i++) {
			sortArray[i] = numbers[i];
			while(biggestValue < numbers[i]) {
				biggestValue *= 10;
			}
		}
		
		//Sort
		while(currentUnit < biggestValue) {
			for(int i=sortArray.length-1; i>=0; i--) {
				for(int j=0; j<=9; j++) {
					if(sortArray[i] / currentUnit % 10 == j) {
						queueList.get(j).addLast(sortArray[i]);
					}
				}				
			}			
			sortArray = new int[numbers.length];		
			int counter = 0;
			for(int i=0; i<queueList.size(); i++) {
				while(!queueList.get(i).isEmpty()) {
					sortArray[counter] = queueList.get(i).removeLast();
					counter++;
				}
			}			
			currentUnit *= 10;
		}
		return sortArray;
	}
	
	public static int[] sortDescending(int[] numbers) {
		int[] sortArray = new int[numbers.length];
		int biggestValue = 1;
		int currentUnit = 1;		
		//ArrayDeque
		ArrayList<ArrayDeque<Integer>> queueList = new ArrayList<ArrayDeque<Integer>>();
		
		for(int i = 0; i < 10; i++) {
			queueList.add(new ArrayDeque<Integer>());
		}	
		
		//Assign values + get the biggest value
		for(int i=0; i<numbers.length; i++) {
			sortArray[i] = numbers[i];
			while(biggestValue < numbers[i]) {
				biggestValue *= 10;
			}
		}		
		//Sort
		while(currentUnit < biggestValue) {
			for(int i=sortArray.length-1; i>=0; i--) {
				for(int j=0; j<=9; j++) {
					if(sortArray[i] / currentUnit % 10 == j) {
						//Descending [9 - j]
						queueList.get(9-j).addLast(sortArray[i]);
					}
				}				
			}			
			sortArray = new int[numbers.length];		
			int counter = 0;
			for(int i=0; i<queueList.size(); i++) {
				while(!queueList.get(i).isEmpty()) {
					sortArray[counter] = queueList.get(i).removeLast();
					counter++;
				}
			}			
			currentUnit *= 10;
		}
		return sortArray;
	}		
}
