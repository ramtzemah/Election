package Model;

import java.util.ArrayList;

public class NotePad {
	public ArrayList<Citizen> listOfCitizens = new ArrayList<Citizen>();
	private static int numOfCitizens = 0;

	public NotePad() { // Default constructor
	}

	public void addCitizens(Citizen citizen) { // Add Citizen to the Note Pad
		listOfCitizens.add(citizen);
		numOfCitizens++;
	}

	public int getNumOfCitizens() {
		return numOfCitizens;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotePad other = (NotePad) obj;
		if (listOfCitizens == null) {
			if (other.listOfCitizens != null)
				return false;
		} else if (!listOfCitizens.equals(other.listOfCitizens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < listOfCitizens.size(); i++) {
			s = s + listOfCitizens.get(i).getName();
		}
		return "The num of citizens is: " + numOfCitizens + "\nThe citizens are: " + s;
	}

}
