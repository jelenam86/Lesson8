package optional;

public class Zombie extends Patient {

	String timeOfDeath;

	public Zombie(String timeOfDeath) {
		this.timeOfDeath = timeOfDeath;
	}

	public String getTimeOfDeath() {
		return timeOfDeath;
	}
}