package matrix.points_collector;

import java.util.HashMap;
import java.util.Map;

public class Player {	
	
	private int xPosition, yPosition;
	private int points;
	
	private MovementMap map;
	
	private HashMap<String, Integer> visitedMapPoints = new HashMap<String, Integer>();	
	
	private int mostVisitedValue;	
	
	private static String[] direction = {"N",  "NE", "E", "SE", "S", "SV", "V", "NV"};
	
	public Player(MovementMap map) {
		this.points = 0;
		this.xPosition = 0;
		this.yPosition = 0;
		this.map = map;
		this.mostVisitedValue = 0;
		System.out.println("First location:");
		collect();
	}
	
	public void printMostVisitedPoints() {
		System.out.println("Most Visited Points: ");
		for(Map.Entry<String, Integer> entry : visitedMapPoints.entrySet()) {
			if(entry.getValue() == mostVisitedValue) {
				System.out.print(entry.getKey()+" ");
			}
		}
		System.out.println("\n");
	}
	
	public void printTotalCollectedPoints() {
		System.out.print("Total Collected points: "+getPoints());
	}
	
	public void collect() {
		points += map.getCollectible(yPosition, xPosition);
		//
		System.out.println("Collected Points: "+map.getCollectible(yPosition, xPosition));
		//
		map.removeCollectible(yPosition, xPosition);
		//
		addVisitedPoint();
		//
		System.out.println("("+this.yPosition+"; "+this.xPosition+")\n");
	}
	
	public void addVisitedPoint() {	
		visitedMapPoints.put("("+String.valueOf(this.yPosition)+"; "+String.valueOf(this.xPosition)+")", checkVisitedPoint()+1);
		if(checkVisitedPoint() > mostVisitedValue) {
		    mostVisitedValue = checkVisitedPoint();
		}

	}
	
	private int checkVisitedPoint() {
		Integer timesVisited = visitedMapPoints.get("("+String.valueOf(this.yPosition)+"; "+String.valueOf(this.xPosition)+")");
		if(timesVisited == null) {
			return 0;
		}
		else {
			return timesVisited;
		}
	}
	
	public void move(int dir) {
		
		if(dir > 0 && dir < 9) {
		
		System.out.print("Moving to: ");
		
		switch(Player.direction[dir-1]) {
		
		case "N":
			System.out.println("N");
			if(this.xPosition - 1 >= 0) {
				this.yPosition -= 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "NE":
			System.out.println("NE");
			if(this.yPosition - 1 >= 0 && this.xPosition + 1 < map.xBound()) {
				this.yPosition -= 1;
				this.xPosition += 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "E":
			System.out.println("E");
			if(this.xPosition + 1 < map.xBound()) {
				this.xPosition += 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "SE":
			System.out.println("SE");
			if(this.xPosition + 1 < map.xBound() && this.yPosition < map.yBound()) {
				this.yPosition += 1;
				this.xPosition += 1;				
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "S":
			System.out.println("S");
			if(this.yPosition + 1 < map.yBound()) {
				this.yPosition += 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "SV":
			System.out.println("SV");
			if(this.yPosition + 1 < map.yBound() && this.xPosition - 1 >= 0) {
				this.yPosition += 1;
				this.xPosition -= 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "V":
			System.out.println("V");
			if(this.xPosition - 1 >= 0) {
				this.xPosition -= 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;
			
		case "NV":
			System.out.println("NV");
			if(this.yPosition -1 < map.yBound() && this.xPosition - 1 < map.xBound()) {
				this.yPosition -= 1;
				this.xPosition -= 1;
			}
			else {
				System.out.println("Out of bounds!");
			}
			
			break;				
		}	
		}
		else {
			System.out.println("Unknown direction! The player remains on the same place.");
		}
	
	}
	
	public int getPoints() {
		return this.points;
	}
	
}
