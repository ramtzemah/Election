package Model;

import java.util.Scanner;

public class InputAndOutput implements Electable {
	static Elections useBehirot = new Elections();
	static Scanner scan = new Scanner(System.in);

	public static void menuMessage() {
		System.out.println("Welcome to elections 2020 menu\nFor creating a voting spot please press 1\n"
				+ "For creating a citizen please press 2\nFor creating a section please press 3"
				+ "\nFor adding a candidate under a section please press 4\n"
				+ "For showing all of the existing voting spots please press 5\n"
				+ "For showing all of the citizens please press 6\n"
				+ "For showing all of the sections please press 7\n"
				+ "If you want to make the elections please press 8\n" + "For showing the results please press 9\n"
				+ "If you want to exit please press 10");
	}

// case 1
	public static void addKalpi(Elections useBehirot) {
		String address = "";
		int kalpiKind = 0;
		do {
			System.out.println("Which kind of Kalpi would you like to create ?\n" + "Regular- 1\n" + "Corona - 2\n"
					+ "Army - 3\n" + "sick soldier - 4\n" + "Back to menu - -1");
			kalpiKind = useBehirot.ReadInt();
		} while (kalpiKind != 1 && kalpiKind != 2 && kalpiKind != 3 && kalpiKind != 4 && kalpiKind != -1);

		do {
			switch (kalpiKind) {
			case -1:
				System.out.println("Thank you");
				break;
			case 1:
				boolean check = false;
				if (kalpiKind == 1) {
					System.out.println("What is the address of the voting spot?");
					address = useBehirot.ReadString();
				}
				for (int i = 0; i < useBehirot.getAllnormalbalotbox().size(); i++) {
					if (useBehirot.getAllnormalbalotbox().get(i).getAdress().equals(address)) {
						System.out.println("This kalpi already exists");
						check = true;

					}
				}
				if (!check) {
					BallotBox<Citizen> normalBallotBox = new BallotBox<Citizen>(address);
					useBehirot.getAllnormalbalotbox().add(normalBallotBox);
					useBehirot.gettotalkalpiot().add(normalBallotBox);
					kalpiKind = -1;
					useBehirot.ballotBoxCounter++;
				}
				break;
			case 2:
				check = false;
				if (kalpiKind == 2) {
					System.out.println("What is the address of the voting spot?");
					address = useBehirot.ReadString();
				}
				for (int i = 0; i < useBehirot.getAllSickCitizenbalotbox().size(); i++) {
					if (useBehirot.getAllSickCitizenbalotbox().get(i).getAdress().equals(address)) {
						System.out.println("This kalpi already exists");
						check = true;
					}

				}
				if (!check) {
					BallotBox<SickCitizen> sickCitizenBallotBox = new BallotBox<SickCitizen>(address);
					useBehirot.getAllSickCitizenbalotbox().add(sickCitizenBallotBox);
					useBehirot.gettotalkalpiot().add(sickCitizenBallotBox);
					kalpiKind = -1;
					useBehirot.ballotBoxCounter++;
				}
				break;
			case 3:
				check = false;
				if (kalpiKind == 3) {
					System.out.println("What is the address of the voting spot?");
					address = useBehirot.ReadString();
				}
				for (int i = 0; i < useBehirot.getSoldierBallotBox().size(); i++) {
					if (useBehirot.getSoldierBallotBox().get(i).getAdress().equals(address)) {
						System.out.println("This kalpi already exists");
						check = true;

					}

				}
				if (!check) {
					BallotBox<Soldier> soldierBallotBox = new BallotBox<Soldier>(address);
					useBehirot.getSoldierBallotBox().add(soldierBallotBox);
					useBehirot.gettotalkalpiot().add(soldierBallotBox);
					kalpiKind = -1;
					useBehirot.ballotBoxCounter++;
				}
				break;
			case 4:
				check = false;
				if (kalpiKind == 4) {
					System.out.println("What is the address of the voting spot?");
					address = useBehirot.ReadString();
				}
				for (int i = 0; i < useBehirot.getsickSoldierBallotBox().size(); i++) {
					if (useBehirot.getsickSoldierBallotBox().get(i).getAdress().equals(address)) {
						System.out.println("This kalpi already exists");
						check = true;

					}

				}
				if (!check) {
					BallotBox<SickSoldier> sickSoldierBallotBox = new BallotBox<SickSoldier>(address);
					useBehirot.getsickSoldierBallotBox().add(sickSoldierBallotBox);
					useBehirot.gettotalkalpiot().add(sickSoldierBallotBox);
					kalpiKind = -1;
					useBehirot.ballotBoxCounter++;
				}
				break;
			}
		} while (kalpiKind != -1 && kalpiKind != 0 && address != "");
	}

// case 2
	public static void CreateCitizen(Elections usebhirot) {
		String name = "";
		int kalpiId = 0;
		int x = 0;
		int yearOfBirth = 0, id = 0, numOfDaysSick = 0;
		boolean IDchecker = false, isInIsolation = false, carryWeapon = false;
		do {
			System.out.println("What is the citizen name?");
			name = usebhirot.ReadString();
			if (!Citizen.setName(name)) {
				System.out.println("the data is not true");
			}
		} while (!Citizen.setName(name));

		do {
			System.out.println("What is year of birth?");
			yearOfBirth = usebhirot.ReadInt();
			if (!Citizen.setYearOfBirth(yearOfBirth)) {
				System.out.println("the data is not true");
			}
		} while (!Citizen.setYearOfBirth(yearOfBirth));

		do {
			System.out.println("what the ID number?");
			id = usebhirot.ReadInt();
			if (!Citizen.setId(id)) {
				System.out.println("the data is not true");
			}
		} while (!Citizen.setId(id));
		do {
			System.out.println("Is the citizen in isolation?\n1-yes\n2-no");
			x = usebhirot.ReadInt();
			if (x == 1) {
				isInIsolation = true;
			} else if (x == 2) {
				isInIsolation = false;
			}
		} while (x != 1 && x != 2);
		if ((2020 - yearOfBirth) >= 18 && (2020 - yearOfBirth) <= 21 && (isInIsolation == true)) {
			do {
				System.out.println("Are you carrying weapons?\n1-yes\n2-no");
				x = usebhirot.ReadInt();
				if (x == 1) {
					carryWeapon = true;
				} else if (x == 2) {
					carryWeapon = false;
				}
			} while (x != 1 && x != 2);
			do {
				System.out.println("How many days are you in isolation?");
				numOfDaysSick = usebhirot.ReadInt();
			} while (!SickSoldier.setNumOfDaysSick(numOfDaysSick));
			do {
				System.out.println("Where you want to vote?choose the ID");
				System.out.println(usebhirot.showAllSickSoldierKalpi());
				kalpiId = usebhirot.ReadInt();
				for (int i = 0; i < usebhirot.getsickSoldierBallotBox().size(); i++) {
					if (kalpiId == usebhirot.getsickSoldierBallotBox().get(i).getKalpiId()) {
						IDchecker = true;
					}
				}
			} while (!IDchecker);
			try {
				SickSoldier temp = new SickSoldier(name, yearOfBirth, isInIsolation, id, kalpiId, carryWeapon,
						numOfDaysSick);
				if (usebhirot.allCitizen.checkObject(temp)) {
					usebhirot.allCitizen.AddObject(temp);
					usebhirot.getNd().addCitizens(temp);

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if ((2020 - yearOfBirth) >= 18 && (2020 - yearOfBirth) <= 21 && (isInIsolation == false)) {
			do {
				System.out.println("Are you carrying weapons?\n1-yes\n2-no");
				x = scan.nextInt();
				if (x == 1) {
					carryWeapon = true;
				} else if (x == 2) {
					carryWeapon = false;
				}
			} while (x != 1 && x != 2);
			do {
				System.out.println("Where you want to vote?choose the ID");
				System.out.println(usebhirot.showAllSoldierKalpi());
				kalpiId = usebhirot.ReadInt();
				for (int i = 0; i < usebhirot.getSoldierBallotBox().size(); i++) {
					if (kalpiId == usebhirot.getSoldierBallotBox().get(i).getKalpiId()) {
						IDchecker = true;
					}
				}
			} while (!IDchecker);
			try {
				Soldier soldier = new Soldier(name, yearOfBirth, isInIsolation, id, kalpiId, carryWeapon);
				if (usebhirot.allCitizen.checkObject(soldier)) {
					usebhirot.allCitizen.AddObject(soldier);
					usebhirot.getNd().addCitizens(soldier);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if (((2020 - yearOfBirth) > 21 || (2020 - yearOfBirth) < 18) && (isInIsolation == true)) {
			do {
				System.out.println("How many days are you in isolation?");
				numOfDaysSick = usebhirot.ReadInt();
			} while (!SickCitizen.setNumOfDaysSick(numOfDaysSick));
			do {
				System.out.println("Where you want to vote?choose the ID");
				System.out.println(usebhirot.showAllSickCitizenKalpi());
				kalpiId = usebhirot.ReadInt();
				for (int i = 0; i < usebhirot.getAllSickCitizenbalotbox().size(); i++) {
					if (kalpiId == usebhirot.getAllSickCitizenbalotbox().get(i).getKalpiId()) {
						IDchecker = true;
					}
				}
			} while (!IDchecker);
			try {
				SickCitizen sickCitizen = new SickCitizen(name, yearOfBirth, isInIsolation, id, kalpiId, numOfDaysSick);
				if (usebhirot.allCitizen.checkObject(sickCitizen)) {
					usebhirot.allCitizen.AddObject(sickCitizen);
					usebhirot.getNd().addCitizens(sickCitizen);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if (((2020 - yearOfBirth) > 21 || (2020 - yearOfBirth) < 18) && (isInIsolation == false)) {
			do {
				System.out.println("Where you want to vote?choose the ID");
				System.out.println(usebhirot.showAllNormalKalpi());
				kalpiId = usebhirot.ReadInt();
				for (int i = 0; i < usebhirot.getAllnormalbalotbox().size(); i++) {
					if (kalpiId == usebhirot.getAllnormalbalotbox().get(i).getKalpiId()) {
						IDchecker = true;
					}
				}
			} while (!IDchecker);
			try {
				Citizen c = new Citizen(name, yearOfBirth, isInIsolation, id, kalpiId);
				if (usebhirot.allCitizen.checkObject(c)) {
					usebhirot.allCitizen.AddObject(c);
					usebhirot.getNd().addCitizens(c);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

// case 3
	static String miflagaName;
	static int miflagadDay, miflagaMonth, miflagaYear, miflagaChoise, miflagaIdeology;

	public static boolean MiflagaName(Elections useBehirot) {
		System.out.println("What the party name?");
		miflagaName = useBehirot.ReadString();
		if (!Miflaga.setMiflagaName(miflagaName)) {
			System.out.println("The name is untrue, please try again");
			return false;
		}

		for (int i = 0; i < Elections.miflagotcounter; i++) {
			if (useBehirot.getListOfMiflagot().get(i).getName().equals(miflagaName)) {
				System.out.println("The party already exists");
				return false;
			}
		}
		return true;
	}

	public static void MiflagaIdelogy() {
		do {
			miflagaChoise = 0;
			System.out.println("What the party ideology? press your choise\nyamin=1   || merckaz=2  ||  semol=3");
			miflagaChoise = useBehirot.ReadInt();
			switch (miflagaChoise) {
			case 1:
				miflagaIdeology = 1;
				break;
			case 2:
				miflagaIdeology = 2;
				break;
			case 3:
				miflagaIdeology = 3;
				break;
			}
			if (!Miflaga.setMiflagaIdeology(miflagaChoise)) {
				System.out.println("The ideology is untrue, please try again");
			}
		} while (!Miflaga.setMiflagaIdeology(miflagaChoise));

	}

	public static void MiflagaDate() {
		do {
			System.out.println("What the party creat date?");
			System.out.println("Day? (1-31)");
			miflagadDay = useBehirot.ReadInt();
			System.out.println("Month? (1-12)");
			miflagaMonth = useBehirot.ReadInt();
			System.out.println("Year? (until 2020)");
			miflagaYear = useBehirot.ReadInt();
			if (!Miflaga.setDay(miflagadDay) || !Miflaga.setMonth(miflagaMonth) || !Miflaga.setYear(miflagaYear)) {
				System.out.println("The date is untrue, please try again");
			}
		} while (!Miflaga.setDay(miflagadDay) || !Miflaga.setMonth(miflagaMonth) || !Miflaga.setYear(miflagaYear));

	}

	public static void CreateMiflaga(Elections useBehirot) {
		boolean checkMiflaga = false;
		do {
			checkMiflaga = MiflagaName(useBehirot);
		} while (!checkMiflaga);
		MiflagaIdelogy();
		MiflagaDate();
		useBehirot.CreateMiflagaHelper(miflagaName, miflagaIdeology, miflagadDay, miflagaMonth, miflagaYear);
		useBehirot.miflagotcounter++;
		for (int i = 0; i < useBehirot.getTotalKalpiotSize(); i++) {
			useBehirot.gettotalkalpiot().get(i).updateVotesListWhenMiflagaCreated();
		}
	}

//case 4

	public static void addCandidate(Elections useBehirot) throws Exception {
		boolean isValid;
		Citizen cit = new Citizen();
		int id = 0;
		String choiseMiflaga = "";
		System.out.println("Please enter the ID of the citizen");
		id = useBehirot.ReadInt();
		if (!useBehirot.findCitizenById(id)) {
			System.out.println("There is no citizen with this ID");
		} else {
			if (useBehirot.findCandidateById(id)) {
				System.out.println("Sorry but this citizen is already runing");
			} else {
				cit = useBehirot.findCitizenByIdAndSend(id);
				System.out.println("What party do you want to join? please enter an existing party name");
				System.out.println(useBehirot.showMiflagotName());
				choiseMiflaga = useBehirot.ReadString();
				isValid = useBehirot.makeCitizenCandidate(choiseMiflaga, cit);
				if (!isValid) {
					System.out.println("The party creation attempt was unsuccessful");
				}

			}

		}
	}

//case 5

	public static void showAllKalpiot(Elections useBehirot) {
		System.out.println(useBehirot.showAllKalpiot());
	}

//case 6

	public static void showAllCitizen(Elections useBehirot) {
		System.out.println(useBehirot.showAllCitizens());
	}

//case 7

	public static void showAllMiglagot(Elections useBehirot) {
		System.out.println(useBehirot.showAllMiflagot());
	}

// case 8

	public static void behirot(Elections useBehirot, Scanner scan) {
		int choose;
		boolean suit = false;
		for (int i = 0; i < useBehirot.getNd().getNumOfCitizens(); i++) {
			if (useBehirot.getNd().listOfCitizens.get(i).getIsIsInIsolation() == true) {
				do {
					System.out.println("Hey " + useBehirot.getNd().listOfCitizens.get(i).getName()
							+ " Are you wearing a protective suit?\n1-yes\n2-no");
					choose = useBehirot.ReadInt();
					if (choose == 1) {
						suit = true;
					} else if (choose == 2) {
						suit = false;
					}

				} while (choose != 1 && choose != 2);
				if (suit == true) {
					do {
						System.out.println("hey " + useBehirot.getNd().listOfCitizens.get(i).getName()
								+ " please choose one party that you want ");
						System.out.println(useBehirot.showMiflagotName());
						choose = useBehirot.ReadInt();
					} while (choose <= 0 || choose > useBehirot.miflagotcounter);
					for (int j = 0; j < useBehirot.gettotalkalpiot().size(); j++) {
						if (useBehirot.getNd().listOfCitizens.get(i).getKalpiId() == useBehirot.gettotalkalpiot().get(j)
								.getKalpiId()) {
							useBehirot.gettotalkalpiot().get(j).voteto(choose);
						}
					}
					useBehirot.getListOfMiflagot().get(choose - 1).voteTo();
				} else {
					System.out.println("You can't vote, sorry");
				}
			} else if (useBehirot.getNd().listOfCitizens.get(i).getIsIsInIsolation() == false) {
				do {
					System.out.println("hey " + useBehirot.getNd().listOfCitizens.get(i).getName()
							+ " please choose one party that you want ");
					System.out.println(useBehirot.showMiflagotName());
					choose = useBehirot.ReadInt();
				} while (choose <= 0 || choose > useBehirot.miflagotcounter);
				for (int j = 0; j < useBehirot.gettotalkalpiot().size(); j++) {
					if (useBehirot.getNd().listOfCitizens.get(i).getKalpiId() == useBehirot.gettotalkalpiot().get(j)
							.getKalpiId()) {
						useBehirot.gettotalkalpiot().get(j).voteto(choose);
					}
				}
				useBehirot.getListOfMiflagot().get(choose - 1).voteTo();
			}
		}
	}

//case 9
	public static void electionResults(Elections useBehirot) {
		if (useBehirot.ElectionResultsCheck() == true) {
			System.out.println("No votes in this election round");
		} else {
			for (int i = 0; i < useBehirot.gettotalkalpiot().size(); i++) {
				System.out.println("in " + useBehirot.gettotalkalpiot().get(i).getAdress() + " have "
						+ ((100 * useBehirot.gettotalkalpiot().get(i).getNumOfVotes())
								/ useBehirot.gettotalkalpiot().get(i).getTotalVotes() + "% voting from all voters\n"
								+ "in kalpi " + useBehirot.gettotalkalpiot().get(i).getAdress()));
				for (int j = 0; j < useBehirot.getListOfMiflagot().size(); j++) {
					System.out.println(useBehirot.gettotalkalpiot().get(i).showVotes(j) + " vote to "
							+ useBehirot.getListOfMiflagot().get(j).getName());
					System.out.println();
				}
			}

			System.out.println(useBehirot.showAllVotes());
		}
	}

// case 10
	public static void endMessage() {
		System.out.println("Thank you, good bye:)");
	}

}
