
public class Cell {
	
	// we will use this class in order to create a object which will have the all the needed properties for the states, like heuristic and the direction the cell arrived from 
	private int x;
	private int y;
	private int heuristic;
	private int direction;
	
	public Cell(int x, int y, int direction, int heuristic) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction; //for direction: up=1, right=2, down=3, left=4
		this.heuristic = heuristic;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + ", heuristic=" + heuristic + ", direction=" + direction + "]";
	}

}
