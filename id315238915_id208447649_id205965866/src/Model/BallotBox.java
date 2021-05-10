package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.Controller;

//Generic class

public class BallotBox<T extends Citizen> {
	private List<T> allVoters;
	private int ballotBoxId;
	private static int idZaz = 0;
	private String name;
	private List<Integer> votes = new ArrayList<Integer>();
	protected int numOfVotes = 0;
	private static int totalVotes;
	private int[] results; // ?
	private int numberOfVoters;
	private int[] votesGui;

	public BallotBox(String name) { // Full constructor
		allVoters = new ArrayList<T>();
		this.name = name;
		this.ballotBoxId = idZaz++;
		votesGui = new int[20];
	}

	public String getAdress() {
		return name;
	}

	public int getNumOfVotes() {
		return numOfVotes;
	}

	public static int getTotalVotes() {
		return totalVotes;
	}

	public void addVoter(T newVoter) {
		allVoters.add(newVoter);
	}

	public void updateVotesList() {
		for (int i = 0; i < Elections.miflagotcounter; i++) {
			votes.add(0);
		}
	}

	public void updateVotesListWhenMiflagaCreated() {
		votes.add(0);
	}

	public void voteto(int choise) {
		this.numOfVotes++;
		votes.set(choise - 1, votes.get(choise - 1) + 1);
		totalVotes++;
	}

	@Override
	public String toString() {
		if (allVoters.size() > 0)
			return allVoters.get(0).getClass().getSimpleName();
		else
			return "Unknow T";
	}

	public String kalpiDetails() {
		return name + " and his ID is: " + ballotBoxId;
	}

	public int showVotes(int j) {
		return votes.get(j);
	}

	public int getKalpiId() {
		return ballotBoxId;
	}

	public void resetVoting(int numberOfParties) {
		results = new int[numberOfParties];

	}

	public String getCitizenName(int placeInCitizenArray) {

		return allVoters.get(placeInCitizenArray).getName();
	}

	public boolean getIfCitizenInsolated(int citizenPlace) {
		return allVoters.get(citizenPlace).getIsIsInIsolation();
	}

	public void addCitizen(T newCitizen) {
		allVoters.add(newCitizen);
		numberOfVoters++;

	}

	public void updateVote(String partyName) {
		votesGui[(Controller.getElectionModel().partyNumByName(partyName))]++;

	}
	
	public int getVote(int index) {
		return votesGui[index];
	}

	public void checker() {
		for (int i = 0; i < votesGui.length; i++) {
			System.out.println(votesGui[i]);
		}

	}

}
