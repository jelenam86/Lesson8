package optional;

public class Patient {

	private int pulse;
	private boolean isAlive;

	public Patient() {
		this.isAlive = true;
	}

	public boolean feelsCaredFor() {
		if (this.pulse > 0)
			return true;
		return false;
	}

	public int checkPulse() {
		pulse++;
		if (!isAlive)
			pulse = 0;
		return pulse;
	}

	public void kill() {
		this.isAlive = false;
		this.pulse = 0;
	}

	public boolean isAlive() {
		return this.isAlive;
	}
}