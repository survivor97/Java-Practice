package matrix.points_collector;

public class MovementMap {
	private final int xBound, yBound;
	private int[][] collectibleMatrix;
	
	public MovementMap(int yBound, int xBound) {
		this.yBound = yBound;
		this.xBound = xBound;
		collectibleMatrix = new int[yBound][xBound];
	}
	
	public void addCollectible(int yPos, int xPos, int value) {
		collectibleMatrix[yPos][xPos] = value;
	}	
	
	public int getCollectible(int yPos, int xPos) {
		return collectibleMatrix[yPos][xPos];
	}
	
	public void removeCollectible(int yPos, int xPos) {
		collectibleMatrix[yPos][xPos] = 0;
	}
	
	public int xBound() {
		return xBound;
	}
	
	public int yBound() {
		return yBound;
	}
	
}
