public class Fiver {
	int first, second, g, direction, f; //for direction: up=1, right=2, down=3, left=4
	//we use this class in the A star class, in order to keep track of the function and the g of each route
	public Fiver() {
	}
	
	public Fiver(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public Fiver(int first, int second, int g) {
		this.first = first;
		this.second = second;
		this.g = g;
	}

	public Fiver(int first, int second, int g, int f, int direction) {
		this.first = first;
		this.second = second;
		this.g = g;
		this.f = f;
		this.direction = direction;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fiver other = (Fiver) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		String s = "";
		s += "(" + first + ")(" + second +") ";
		return s;
	}
}