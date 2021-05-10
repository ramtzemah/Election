package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Elections {
	public static int miflagotcounter = 0;
	public NotePad nd = new NotePad();
	private List<Miflaga> listOfMiflagot = new ArrayList<Miflaga>();

	public Scanner scan = new Scanner(System.in);
	private List<BallotBox<Citizen>> allnormalbalotbox = new ArrayList<BallotBox<Citizen>>();
	private List<BallotBox<Soldier>> allSoldierbalotbox = new ArrayList<BallotBox<Soldier>>();
	private List<BallotBox<SickSoldier>> allSickSoldierbalotbox = new ArrayList<BallotBox<SickSoldier>>();
	private List<BallotBox<SickCitizen>> allSickCitizenbalotbox = new ArrayList<BallotBox<SickCitizen>>();
	private List<BallotBox> totalkalpiot = new ArrayList<BallotBox>();
	public static int ballotBoxCounter = 0;
	private String[] namesOfCitizens;
	public Set allCitizen = new Set();

	private String[] voterList; // ??
	private boolean votingHappened = false; // ??

	public void createHardCoded() throws Exception {
		BallotBox<Citizen> normalBallotBox = new BallotBox<Citizen>("netanya");
		BallotBox<Soldier> soldierBallotBox = new BallotBox<Soldier>("haifa");
		BallotBox<SickSoldier> sickSoldierBallotBox = new BallotBox<SickSoldier>("tel aviv");
		BallotBox<SickCitizen> sickCitizenBallotBox = new BallotBox<SickCitizen>("dimona");
		totalkalpiot.add(normalBallotBox);
		totalkalpiot.add(soldierBallotBox);
		totalkalpiot.add(sickSoldierBallotBox);
		totalkalpiot.add(sickCitizenBallotBox);
		ballotBoxCounter = 4;

		allnormalbalotbox.add(normalBallotBox);
		allSoldierbalotbox.add(soldierBallotBox);
		allSickSoldierbalotbox.add(sickSoldierBallotBox);
		allSickCitizenbalotbox.add(sickCitizenBallotBox);

		Soldier solider1 = new Soldier("liron", 1999, false, 315238915, 0, true);
		SickSoldier sickSoldier1 = new SickSoldier("ella", 2000, true, 963852741, 0, false, 5);
		SickCitizen sickCitizen1 = new SickCitizen("omer", 1996, true, 208447649, 0, 20);
		SickCitizen sickCitizen2 = new SickCitizen("ram", 1995, true, 208447648, 0, 30);
		SickCitizen sickCitizen3 = new SickCitizen("eti", 1998, true, 123789456, 0, 14);
		Citizen citizen1 = new Citizen("lian", 1985, false, 123456789, 0);
		Citizen citizen2 = new Citizen("avi", 1980, false, 987654321, 0);
		Citizen citizen3 = new Citizen("lili", 1940, false, 741852963, 0);
		// Check that all objects are citizen type and added to the list of citizens
		allCitizen.AddObject(citizen1);
		allCitizen.AddObject(citizen2);
		allCitizen.AddObject(citizen3);
		allCitizen.AddObject(solider1);
		allCitizen.AddObject(sickSoldier1);
		allCitizen.AddObject(sickCitizen1);
		allCitizen.AddObject(sickCitizen2);
		allCitizen.AddObject(sickCitizen3);

		soldierBallotBox.addVoter(solider1);
		sickSoldierBallotBox.addVoter(sickSoldier1);
		sickCitizenBallotBox.addVoter(sickCitizen1);

		sickCitizenBallotBox.addVoter(sickCitizen2);
		sickCitizenBallotBox.addVoter(sickCitizen3);
		normalBallotBox.addVoter(citizen1);
		normalBallotBox.addVoter(citizen2);
		normalBallotBox.addVoter(citizen3);

		nd.addCitizens(citizen1);
		nd.addCitizens(citizen2);
		nd.addCitizens(citizen3);
		nd.addCitizens(sickCitizen1);
		nd.addCitizens(sickCitizen2);
		nd.addCitizens(sickCitizen3);
		nd.addCitizens(solider1);
		nd.addCitizens(sickSoldier1);

		Miflaga miflaga1 = new Miflaga("cows", 1, 10, 11, 1995);
		listOfMiflagot.add(miflaga1);

		Miflaga miflaga2 = new Miflaga("dogs", 2, 17, 5, 1990);
		listOfMiflagot.add(miflaga2);
		Miflaga miflaga3 = new Miflaga("koalas", 3, 5, 1, 1978);
		listOfMiflagot.add(miflaga3);
		miflagotcounter = 3;
		for (int i = 0; i < getTotalKalpiotSize(); i++) {
			this.gettotalkalpiot().get(i).updateVotesList();
		}

		Candidate candidate1 = new Candidate("may", 1999, true, 100000000, 1);
		Candidate candidate2 = new Candidate("ohad", 1995, false, 100000001, 2);
		Candidate candidate3 = new Candidate("michal", 1980, false, 100000002, 3);
		Candidate candidate4 = new Candidate("lia", 1940, true, 100000003, 4);
		Candidate candidate5 = new Candidate("ofek", 1980, false, 100000004, 5);
		Candidate candidate6 = new Candidate("mimi", 1998, false, 100000005, 6);

		normalBallotBox.addVoter(candidate1);
		normalBallotBox.addVoter(candidate2);
		normalBallotBox.addVoter(candidate3);
		normalBallotBox.addVoter(candidate4);
		normalBallotBox.addVoter(candidate5);
		normalBallotBox.addVoter(candidate6);
		nd.addCitizens(candidate1);
		nd.addCitizens(candidate2);
		nd.addCitizens(candidate3);
		nd.addCitizens(candidate4);
		nd.addCitizens(candidate5);
		nd.addCitizens(candidate6);

		allCitizen.AddObject(candidate1); // adding citizens to set list
		allCitizen.AddObject(candidate2);
		allCitizen.AddObject(candidate3);
		allCitizen.AddObject(candidate4);
		allCitizen.AddObject(candidate5);
		allCitizen.AddObject(candidate6);

		miflaga1.addCandidate(candidate1);
		miflaga1.addCandidate(candidate2);
		miflaga2.addCandidate(candidate3);
		miflaga2.addCandidate(candidate4);
		miflaga3.addCandidate(candidate5);
		miflaga3.addCandidate(candidate6); // adding candidate to parties

	}

	public void startVoterListArray() {

		for (int i = 0; i < allCitizen.getList().size(); i++) {
			namesOfCitizens[i] = allCitizen.get(i).getName();
		}
	}

	public String Reader() {
		return scan.nextLine();
	}

	public void newNormalBallot(String city) {
		BallotBox<Citizen> newBallot = new BallotBox<Citizen>(city);
		allnormalbalotbox.add(newBallot);
		totalkalpiot.add(newBallot);
	}

	public void newSickCitizenBallot(String city) {
		BallotBox<SickCitizen> newBallot = new BallotBox<SickCitizen>(city);
		allSickCitizenbalotbox.add(newBallot);
		totalkalpiot.add(newBallot);
	}

	public void newSickSoldierBallot(String city) {
		BallotBox<SickSoldier> newBallot = new BallotBox<SickSoldier>(city);
		allSickSoldierbalotbox.add(newBallot);
		totalkalpiot.add(newBallot);
	}

	public void newSoldierBallot(String city) {
		BallotBox<Soldier> newBallot = new BallotBox<Soldier>(city);
		allSoldierbalotbox.add(newBallot);
		totalkalpiot.add(newBallot);
	}

	public void newParty(String name, int ideo, int day, int month, int year) {
		Miflaga newParty = new Miflaga(name, ideo, day, month, year);
		listOfMiflagot.add(newParty);
	}

	public void newCitizne(String n, int year, boolean is, int id, int kalpiId) {
		Citizen newCitizen = new Citizen(n, year, is, id, kalpiId);
		nd.listOfCitizens.add(newCitizen);
		allCitizen.AddObject(newCitizen);
		totalkalpiot.get(0).addVoter(newCitizen);
	}

	public void newSickCitizne(String name, int year, boolean IsInIsolation, int id, int kalpiId, int numOfDaysSick) {
		SickCitizen newSickCitizen = new SickCitizen(name, year, IsInIsolation, id, kalpiId, numOfDaysSick);
		nd.listOfCitizens.add(newSickCitizen);
		allCitizen.AddObject(newSickCitizen);
		totalkalpiot.get(0).addVoter(newSickCitizen);
	}

	public void newSoldier(String name, int year, boolean IsInIsolation, int id, int kalpiId, boolean carryWeapon) {
		Soldier newSoldier = new Soldier(name, year, IsInIsolation, id, kalpiId, carryWeapon);
		nd.listOfCitizens.add(newSoldier);
		allCitizen.AddObject(newSoldier);
		totalkalpiot.get(0).addVoter(newSoldier);

	}

	public void newSickSoldier(String name, int year, boolean IsInIsolation, int id, int kalpiId, boolean carryWeapon,
			int numOfDaysSick) {
		SickSoldier newSickSoldier = new SickSoldier(name, year, IsInIsolation, id, kalpiId, carryWeapon,
				numOfDaysSick);
		nd.listOfCitizens.add(newSickSoldier);
		allCitizen.AddObject(newSickSoldier);
		totalkalpiot.get(0).addVoter(newSickSoldier);
	}

	public void newCandidate(String name, int yearOfBirth, boolean b, int id, int kalpiId, int rate, String partyName)
			throws Exception {
		Candidate newCandidate = new Candidate(name, yearOfBirth, b, id, kalpiId, rate);
		makeCitizenCandidate(partyName, newCandidate);
	}

	public int ReadInt() { // method for reading int that throws an exception
		int number = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				System.out.println("please enter the number");
				number = scan.nextInt();
				isValidInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Your answer is not from the correct variable");
				scan.nextLine(); // cleans buffer
			} catch (Exception e) {
				System.out.println(e.getMessage());
				scan.nextLine(); // cleans buffer
			}
		}
		return number;
	}

	public boolean isNumber(String str) {
		int x = 0;

		try {
			x = (Integer.parseInt(str));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean setId(int id) {
		if (id < 99999999 || id > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAlpha(String str) {
		boolean isalpha = true;
		char[] cha = str.toCharArray();
		for (char i : cha) {
			if (!Character.isLetter(i)) {
				isalpha = false;
			}
		}
		return isalpha;

	}

	public String ReadString() {// method for reading String that throws an exception
		boolean isalpha = false;
		String str = "";
		while (!isalpha) {
			try {
				System.out.println("please enter the name");
				str = scan.next();

			} catch (InputMismatchException e) {
				System.out.println("Your answer is not from the correct variable");
				scan.nextLine(); // cleans buffer
			} catch (Exception e) {
				System.out.println(e.getMessage());
				scan.nextLine(); // cleans buffer
			}
			isalpha = isAlpha(str);
		}
		return str;
	}

	public String showMiflagotName() { // Show all parties's name
		String miflagotName = "The miflagot are:\n";
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			miflagotName += (i + 1) + ") " + listOfMiflagot.get(i).getName() + "\n";
		}
		return miflagotName;

	}

	public boolean equals(Citizen c) {
		for (int i = 0; i < nd.getNumOfCitizens(); i++) {
			if (c.getId() == nd.listOfCitizens.get(i).getId())
				return false;
		}
		return true;
	}

	public boolean makeCitizenCandidate(String miflagaName, Citizen citizen) throws Exception { // Making a citizen a

		for (int i = 0; i < listOfMiflagot.size(); i++) {
			if (listOfMiflagot.get(i).getName().equals(miflagaName)) {
				listOfMiflagot.get(i).makeCitizenCandidate(citizen);
				return true;
			}

		}
		return false;

	}

	public boolean findCitizenById(int id) { // Looking for citizen with this id
		for (int i = 0; i < nd.listOfCitizens.size(); i++) {
			if (nd.listOfCitizens.get(i).getId() == id)
				return true;
		}
		return false;
	}

	public boolean findCandidateById(int id) { // Looking for candidate with this id

		for (int i = 0; i < listOfMiflagot.size(); i++) {
			for (int j = 0; j < listOfMiflagot.get(i).getNumOfCandidates(); j++) {
				if (id == listOfMiflagot.get(i).listOfCandidates.get(j).getId()) {
					return true;
				}

			}

		}
		return false;

	}

	public void CreateMiflagaHelper(String name, int ideology, int day, int month, int year) { // Add the party
																								// to the party
																								// list
		listOfMiflagot.add(new Miflaga(name, ideology, day, month, year));
		miflagotcounter++;
	}

	public String showAllNormalKalpi() { // show all ballot box for citizen
		String s = "The Normal kalpi are:\n";
		for (int i = 0; i < allnormalbalotbox.size(); i++) {
			s += allnormalbalotbox.get(i).kalpiDetails();
			s += "\n";
		}

		return s;
	}

	public String showAllSickCitizenKalpi() { // show all ballot box for sick citizens
		String s = "The Sick kalpi are:\n";
		for (int i = 0; i < allSickCitizenbalotbox.size(); i++) {
			s += allSickCitizenbalotbox.get(i).kalpiDetails();
			s += "\n";
		}
		return s;
	}

	public String showAllSickSoldierKalpi() { // show all ballot box for sick soldiers
		String s = "The votes of sick soldiers are:\n";
		for (int i = 0; i < allSickSoldierbalotbox.size(); i++) {
			s += allSickSoldierbalotbox.get(i).kalpiDetails();
			s += "\n";
		}
		return s;
	}

	public String showAllSoldierKalpi() { // show all ballot box for soldiers
		String s = "The soldier kalpi are:\n";
		for (int i = 0; i < allSoldierbalotbox.size(); i++) {
			s += allSoldierbalotbox.get(i).kalpiDetails();
			s += "\n";
		}
		return s;
	}

	public String showAllKalpiot() { // show all kalpiot
		return showAllNormalKalpi() + "\n" + showAllSickCitizenKalpi() + "\n" + showAllSickSoldierKalpi() + "\n"
				+ showAllSoldierKalpi();
	}

	public String showAllCitizens() { // case 6
		String s = "The Citizens are:\n";
		for (int i = 0; i < nd.listOfCitizens.size(); i++) {
			s += nd.listOfCitizens.get(i).toString();
			s += "\n";

		}
		return s;

	}

	public String showAllMiflagot() { // case 7
		String s = "The miflagot are:\n";
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			s += listOfMiflagot.get(i).toString();
			s += "\n";

		}

		return s;

	}

	public String showAllVotes() {
		String s = "The votes are:\n";
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			s += "To " + listOfMiflagot.get(i).getName() + " has " + listOfMiflagot.get(i).getVote() + " votes\n";

		}
		return s;
	}

	public Citizen findCitizenByIdAndSend(int id) {
		for (int i = 0; i < nd.listOfCitizens.size(); i++) {
			if (nd.listOfCitizens.get(i).getId() == id)
				return nd.listOfCitizens.get(i);

		}
		return null;

	}

	public boolean ElectionResultsCheck() { // Checking for votes in voting
		int checker = 0;
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			if (listOfMiflagot.get(i).getVote() == 0) {
				checker++;
			}
		}
		if (checker == listOfMiflagot.size()) {
			return true;

		}
		return false;
	}

	public List<BallotBox<Citizen>> getAllnormalbalotbox() {
		return allnormalbalotbox;
	}

	public List<BallotBox<SickCitizen>> getAllSickCitizenbalotbox() {
		return allSickCitizenbalotbox;
	}

	public List<BallotBox<Soldier>> getSoldierBallotBox() {
		return allSoldierbalotbox;
	}

	public List<BallotBox<SickSoldier>> getsickSoldierBallotBox() {
		return allSickSoldierbalotbox;
	}

	public List<BallotBox> gettotalkalpiot() {

		return totalkalpiot;
	}

	public int getTotalKalpiotSize() {
		return ballotBoxCounter;

	}

	public List<Miflaga> getListOfMiflagot() {
		return listOfMiflagot;
	}

	public NotePad getNd() {
		return nd;
	}

	public String showElectionResults() {
		String s = "";
		for (int i = 0; i < gettotalkalpiot().size(); i++) {
			s += ("in " + gettotalkalpiot().get(i).getAdress() + " have "
					+ ((100 * gettotalkalpiot().get(i).getNumOfVotes()) / gettotalkalpiot().get(i).getTotalVotes()
							+ "% voting from all voters\n" + "in kalpi " + gettotalkalpiot().get(i).getAdress()));
			for (int j = 0; j < getListOfMiflagot().size(); j++) {
				s += gettotalkalpiot().get(i).showVotes(j) + " vote to " + getListOfMiflagot().get(j).getName() + "\n";
			}
		}
		return s;
	}

	public String getPartyNameByNumInArr(int i) {

		return listOfMiflagot.get(i).getName();
	}

	public String[] getVoterList() {
		return voterList;

	}

	public void resetVoting() {

		namesOfCitizens = new String[allCitizen.getList().size()];

		startVoterListArray();

	}

	public String[] getVoterArray() {

		return namesOfCitizens;

	}

	public boolean getIfInsolatedByName(String voter) {

		for (int i = 0; i < allCitizen.getList().size(); i++) {
			if (voter.equals(allCitizen.get(i).getName())) {
				return allCitizen.get(i).getIsIsInIsolation();

			}
		}
		return true;

	}

	public void updateVoterList(String string) {
		int x = 0;
		String[] temp = new String[namesOfCitizens.length - 1];
		for (int i = 0; i < namesOfCitizens.length; i++) {
			if (!string.equals(namesOfCitizens[i])) {
				temp[x++] = namesOfCitizens[i];

			}
		}
		namesOfCitizens = temp;
	}

	public int getvoteByPartyName(String chosenParty) {
		int res = 0;
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			res++;
			if (listOfMiflagot.get(i).getName().equals(chosenParty)) {
				return res;
			}

		}
		return res;
	}

	public int HowManyVotesToPartyByName(String partyName) {
		int counter = 0;

		for (int i = 0; i < listOfMiflagot.size(); i++) {
			if (partyName.equals(listOfMiflagot.get(i).getName())) {
				return listOfMiflagot.get(i).getVote();
			}
		}
		return counter;

	}

	public int getBnumByCitizenName(String voter) {

		return 1;
	}

	public void votingStarted() {
		this.votingHappened = true;
	}

	public String[] getAllPartiesList() {
		String[] res = new String[listOfMiflagot.size()];
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			res[i] = listOfMiflagot.get(i).getName();
		}
		return res;
	}

	public int partyNumByName(String partyName) {
		for (int i = 0; i < listOfMiflagot.size(); i++) {
			if (partyName.equals(listOfMiflagot.get(i).getName())) {
				return i;
			}
		}
		return 0;

	}

}
