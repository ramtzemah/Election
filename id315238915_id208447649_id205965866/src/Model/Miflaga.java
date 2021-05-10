package Model;

import java.util.ArrayList;

public class Miflaga {
	private String name;
	private int ideology;
	private int day;
	private int month;
	private int year;
	private int partyCounter;
	private static int partyID;
	public ArrayList<Candidate> listOfCandidates = new ArrayList<Candidate>();

	private int numOfCandidates = 0;
	private int vote;

	public int getNumOfCandidates() {
		return listOfCandidates.size();
	}

	public int getVote() {
		return vote;
	}

	public Miflaga(String name, int ideology, int day, int month, int year) { // Full constructor
		this.name = name;
		this.ideology = ideology;
		this.day = month;
		this.month = month;
		this.year = year;
		partyCounter = partyID++;

	}

	public void addCandidate(Candidate candidate) { // Add candidate to party
		listOfCandidates.add(candidate);
		numOfCandidates++;
	}

	public void makeCitizenCandidate(Citizen citizen) throws Exception { // make Citizen to Candidate
		Candidate c = new Candidate(citizen.getName(), citizen.getYearOfBirth(), citizen.getIsIsInIsolation(),
				citizen.getId(), citizen.getKalpiId(), 3);
		listOfCandidates.add(c);
		numOfCandidates++;
	}

	public void sortByRating() {
		for (int i = numOfCandidates - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (listOfCandidates.get(j).getRating() > listOfCandidates.get(j + 1).getRating())
					swap(listOfCandidates, j, j + 1);
			}
		}
	}

	public void swap(ArrayList<Candidate> listOfCandidates, int i, int j) {
		Candidate temp = listOfCandidates.get(i);
		listOfCandidates.set(i, listOfCandidates.get(j));
		listOfCandidates.set(j, temp);
	}

	public void voteTo() {
		this.vote++;
	}

	public String showRating() {
		String t = "";
		for (int i = 0; i < listOfCandidates.size(); i++) {
			t += "\n" + (i + 1) + "." + listOfCandidates.get(i).getName();
		}

		return t;
	}
	
	


	public int getPartyCounter() {
		return partyCounter;
	}

	public static boolean setMiflagaIdeology(int choise) {
		if (choise < 1 || choise > 3) {
			return false;
		}
		return true;
	}

	public static boolean setDay(int day) {
		if (day < 1 || day > 31) {
			return false;
		}
		return true;
	}

	public static boolean setMonth(int month) {
		if (month < 1 || month > 12) {
			return false;
		}
		return true;
	}

	public static boolean setYear(int year) {
		if (year < 1 || year > 2020) {
			return false;
		}
		return true;
	}

	public static boolean setMiflagaName(String miflagaName) {
		char[] arr = new char[miflagaName.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = miflagaName.charAt(i);
		}
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				return false;
			}
		}

		return true;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miflaga other = (Miflaga) obj;
		if (day != other.day)
			return false;
		if (ideology != other.ideology)
			return false;
		if (listOfCandidates == null) {
			if (other.listOfCandidates != null)
				return false;
		} else if (!listOfCandidates.equals(other.listOfCandidates))
			return false;
		if (month != other.month)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfCandidates != other.numOfCandidates)
			return false;
		if (vote != other.vote)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < listOfCandidates.size(); i++) {
			s += i + 1 + "." + this.listOfCandidates.get(i).getName() + "\n";
		}
		String i = "";
		if (ideology == 1) {
			i += "yamin";
		}
		if (ideology == 2) {
			i += "merkaz";
		}
		if (ideology == 3) {
			i += "semol";

		}
		return "Name: " + name + "\nThe ideology is: " + i + "\nThe num of the people in the party is:  "
				+ numOfCandidates + "\nThe date the party created is: " + day + "/" + month + "/" + year
				+ "\nthe people who runs for this party by primariz number are\n" + s;

	}

}
