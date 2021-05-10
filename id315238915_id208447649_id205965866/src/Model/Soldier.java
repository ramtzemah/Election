package Model;

public class Soldier extends Citizen {
	protected boolean carryWeapon;

	public Soldier(String name, int year, boolean IsInIsolation, int id, int kalpiId, boolean carryWeapon) {
		super(name, year, IsInIsolation, id, kalpiId); // call to constructor of Citizen
		this.carryWeapon = carryWeapon;
	}

	public Soldier() {
		this("", 0, false, 0, 0, false); // Default constructor
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
		String i = "";
		if (!carryWeapon) {
			i = "Is not carry weapon";
		} else {
			i = "Is carry weapon";
		}
		return super.toString() + i + "\n";
	}
}
