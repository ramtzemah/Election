package Model;

public class SickSoldier extends Soldier implements Sickable {
	private int numOfDaysSick;

	public SickSoldier(String name, int year, boolean IsInIsolation, int id, int kalpiId, boolean carryWeapon,
			int numOfDaysSick) {
		super(name, year, IsInIsolation, id, kalpiId, carryWeapon); // call to constructor of Soldier
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

		if (!super.equals(obj)) {
			return false;
		} else {
			return true;
		}
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
