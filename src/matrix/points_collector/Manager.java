package matrix.points_collector;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

	private int rows = 5;
	private int columns = 4;
	
	private int[] input;
	private int inputTotal;
	Scanner sc;
	
	MovementMap map;
	Player player;
	
	public Manager() {
		sc = new Scanner(System.in);		
		System.out.println("Number of movements:");		
		inputTotal = getIntegerInput(sc);
		input = new int[inputTotal];
		
		for(int i=0; i<input.length; i++) {
			System.out.println("Enter next movement:");
			input[i] = getIntegerInput(sc);
		}
		//
		map = new MovementMap(rows, columns);
		//
		map.addCollectible(0, 0, 3);
		map.addCollectible(0, 1, 14);
		map.addCollectible(0, 2, 100);
		map.addCollectible(0, 3, 21);
		map.addCollectible(1, 0, 1);
		map.addCollectible(1, 1, 23);
		map.addCollectible(1, 2, 3);
		map.addCollectible(1, 3, 5);
		map.addCollectible(2, 0, 6);
		map.addCollectible(2, 1, 1);
		map.addCollectible(2, 2, 4);
		map.addCollectible(2, 3, 9);
		map.addCollectible(3, 0, 16);
		map.addCollectible(3, 1, 41);
		map.addCollectible(3, 2, 55);
		map.addCollectible(3, 3, 901);
		map.addCollectible(4, 0, 2);
		map.addCollectible(4, 1, 70);
		map.addCollectible(4, 2, 26);
		map.addCollectible(4, 3, 101);
		//
		player = new Player(map);
		//
		for(int i=0; i<input.length; i++) {
			player.move(input[i]);
			player.collect();
		}
		//
		player.printMostVisitedPoints();
		player.printTotalCollectedPoints();
		//
	}
	
	private int getIntegerInput(Scanner sc) {
		int output;
		while(true) {
			try {
				output = sc.nextInt();
				return output;
			}
			catch(InputMismatchException e) {
				System.out.println("Input must be a number! Try again:");
				sc.nextLine();
			}
		}
	}	
}