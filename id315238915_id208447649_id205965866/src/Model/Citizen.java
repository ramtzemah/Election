package Model;

public class Citizen {
	private static final int YEAR = 2020;
	private static final int LEGAL_AGE = 18;

	protected String name;

	protected int id;
	protected int yearOfBirth;
	protected int kalpiId;

	protected boolean IsInIsolation;

	public Citizen() { // Default constructor
		this("", 0, false, 0, 0);
	}

	public Citizen(String n, int year, boolean is, int id, int kalpiId) { // full constructor
		this.name = n;
		this.yearOfBirth = year;
		this.IsInIsolation = is;
		this.id = id;
		this.kalpiId = kalpiId;

	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		int age = (YEAR - yearOfBirth);
		return age;

	}

	public int getKalpiId() {
		return kalpiId;

	}

	public boolean getIsIsInIsolation() {
		return IsInIsolation;
	}

	public int getId() {
		return id;
	}

	public static boolean setName(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (Character.isDigit(name.charAt(i)) == true) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	public static boolean setYearOfBirth(int yearOfBirth) {
		if ((YEAR - yearOfBirth) < LEGAL_AGE) {
			return false;
		} else if (yearOfBirth < 0 || yearOfBirth > 2020) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean setId(int id) {
		if (id < 99999999 || id > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (IsInIsolation != other.IsInIsolation)
			return false;
		if (id != other.id)
			return false;
		if (kalpiId != other.kalpiId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearOfBirth != other.yearOfBirth)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String i;
		if (!IsInIsolation) {
			i = "Is not in isolation";
		} else {
			i = "is in isolation";
		}
		return "Citizen data is:\nName : " + name + "\n" + "Id : " + id + "\n" + "Year of birth : " + yearOfBirth + "\n"
				+ "Is in isolation? " + i + "\n";
	}

}
