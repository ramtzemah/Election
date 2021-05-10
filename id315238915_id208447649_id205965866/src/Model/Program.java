package Model;

import java.util.Scanner;

public class Program {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Elections useBehirot = new Elections();
		menu(useBehirot);
	}

	public static void menu(Elections useBehirot) throws Exception {

		useBehirot.createHardCoded();
		int choose;
		do {
			InputAndOutput.menuMessage();
			choose = useBehirot.ReadInt();
			switch (choose) { // Menu
			case 1:
				InputAndOutput.addKalpi(useBehirot);
				break;
			case 2:
				InputAndOutput.CreateCitizen(useBehirot);
				break;
			case 3:
				InputAndOutput.CreateMiflaga(useBehirot);
				break;
			case 4:
				InputAndOutput.addCandidate(useBehirot);
				break;
			case 5:
				InputAndOutput.showAllKalpiot(useBehirot);
				break;
			case 6:
				InputAndOutput.showAllCitizen(useBehirot);
				break;
			case 7:
				InputAndOutput.showAllMiglagot(useBehirot);
				break;
			case 8:
				InputAndOutput.behirot(useBehirot, scan);
				break;

			case 9:
				InputAndOutput.electionResults(useBehirot);
				break;

			case 10:
				InputAndOutput.endMessage();
				break;

			}

		} while (choose != 10);

	}

}
