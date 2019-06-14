package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeFactory {

	public static List<Snake> createListOfSnakesWithThatAreRandomlyVenomous() {
		List<Snake> snakes = new ArrayList<Snake>();
		int size = new Random().nextInt(1000) + 1;
		for (int i = 0; i < size; i++) {
			snakes.add(new Snake());
		}
		return snakes;
	}
}
