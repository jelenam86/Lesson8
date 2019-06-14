package exercises;

import java.util.List;

public class Plane {

	private List<Snake> snakes;

	public void addSnakes(List<Snake> list) {
		this.snakes = list;
	}

	public int getNumberOfVenomousSnakes() {
		int count = 0;
		for (Snake snake : this.snakes) {
			if (snake.getVenomous())
				count++;
		}
		return count;
	}
}