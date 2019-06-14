package exercises;

import java.util.Random;

public class Snake {

	private boolean venomous;

	public Snake() {
		this.venomous = new Random().nextBoolean();
	}

	public boolean getVenomous() {
		return venomous;
	}
}