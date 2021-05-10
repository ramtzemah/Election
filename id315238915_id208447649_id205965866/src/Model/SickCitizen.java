package Model;

public class SickCitizen extends Citizen implements Sickable {
	private int numOfDaysSick;

	public SickCitizen(String name, int year, boolean IsInIsolation, int id, int kalpiId, int numOfDaysSick) {
		super(name, year, IsInIsolation, id, kalpiId); // call to constructor of Citizen
		this.numOfDaysSick = numOfDaysSick;
	}

	public static boolean setNumOfDaysSick(int numOfDaysSick) {
		if (numOfDaysSick < 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "The number of days he is in isolation: " + numOfDaysSick + "\n";
	}

	@Override
	public int getNumOfDaysSick() { // method from the interface Sickable
		return numOfDaysSick;
	}

}
