package Model;

public class Candidate extends Citizen {
	private int rating;

	public Candidate(String n, int year, boolean is, int id, int rate) {
		super(n, year, is, id, rate); // call to constructor of Citizen
		setRating(rate);

	}

	public Candidate() throws Exception { // Default constructor
		this("", 0, false, 0, 0);
	}

	public Candidate(String name, int yearOfBirth, boolean b, int id, int kalpiId, int rate) {
		super(name, yearOfBirth, b, id, kalpiId); // call to constructor of Citizen
		setRating(rate);
	}

	public boolean setRating(int r) { // setting position inside each party
		if (r > 10 || r < 1) {
			return false;
		} else
			rating = r;
		return true;

	}

	public int getRating() { // getting position inside each party
		return ((int) ((Math.random() * 10 + 1)));

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "Rate: " + rating + "\n";

	}

}
