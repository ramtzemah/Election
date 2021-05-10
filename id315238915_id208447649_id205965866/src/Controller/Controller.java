package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.*;
import Model.Elections;
import Model.Miflaga;
import View.View;

public class Controller {
	private static Elections electionModel;
	private View view;
	private boolean candidateHelper;
	private boolean votealready = false;

	public Controller(Elections electionModel, View view) throws Exception {
		this.electionModel = electionModel;
		this.view = view;
		electionModel.createHardCoded();

		EventHandler<ActionEvent> mouseClickedEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.clear();
				String choose = ((MenuItem) event.getSource()).getText();
				switch (choose) {
				case "Add ballot box":
					view.ballotMenu();
					EventHandler<ActionEvent> ballotEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							if (view.getBallotName().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getBallotName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (view.getBallotKind() == 1) {
								electionModel.newNormalBallot(view.getBallotName());
								view.showSuccsessMessage("The Ballot was added successfully");
								view.clear();
							} else if (view.getBallotKind() == 2) {
								electionModel.newSoldierBallot(view.getBallotName());
								view.showSuccsessMessage("The Ballot was added successfully");
								view.clear();
							} else if (view.getBallotKind() == 3) {
								electionModel.newSickSoldierBallot(view.getBallotName());
								view.showSuccsessMessage("The Ballot was added successfully");
								view.clear();
							} else if (view.getBallotKind() == 4) {
								electionModel.newSickCitizenBallot(view.getBallotName());
								view.showSuccsessMessage("The Ballot was added successfully");
								view.clear();
							}
						}

					};

					view.EventBallotButton(ballotEvent);
					break;
				case "Show ballot box":
					view.ShowDetails(electionModel.showAllKalpiot());
					break;
				case "Add citizen":
					view.citizeMenu();
					EventHandler<ActionEvent> CitizenEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							if (view.getCitizenName().isEmpty() || view.getCitizenIDString().isEmpty()
									|| view.getCitizenAgeString().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getCitizenName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getCitizenAgeString())) {
								view.showErrorMessage("The date must to contain just digits");
								view.clear();
								return;
							}
							int ageCitizen = Integer.parseInt(view.getCitizenAgeString());
							if (!electionModel.isNumber(view.getCitizenIDString())) {
								view.showErrorMessage("The id must be a numbers");
								view.clear();
								return;
							}
							int id = Integer.parseInt(view.getCitizenIDString());
							if (id < 99999999 || id > 1000000000) {
								view.showErrorMessage("ID must have 9 digits");
								view.clear();
								return;
							}
							if (electionModel.findCitizenById(id) == true) {
								view.showErrorMessage("This citizen already exists");
								view.clear();
								return;

							}
							if (ageCitizen >= 1999 && ageCitizen <= 2002) {
								view.showErrorMessage("Adding a soldier is done separately");
								view.clear();
								return;
							}
							if (ageCitizen > 2002) {
								view.showErrorMessage("citizen must be over 18 years of age");
								view.clear();
								return;
							}
							if (ageCitizen < 0 || ageCitizen > 2020) {
								view.showErrorMessage("Year of birth can be from 0-2020");
								view.clear();
								return;
							} else {

								electionModel.newCitizne(view.getCitizenName(), ageCitizen, false, id, 0);
								view.showSuccsessMessage("The Citizen was added successfully");
								view.clear();
							}

						}
					};
					view.EventCitizenButton(CitizenEvent);

					break;
				case "Add sick citizen":
					view.sickCitizeMenu();
					EventHandler<ActionEvent> SickCitizenEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {

							if (view.getCitizenName().isEmpty() || view.getCitizenIDString().isEmpty()
									|| view.getCitizenAgeString().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getCitizenName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getCitizenAgeString())) {
								view.showErrorMessage("The date must to contain just digits");
								view.clear();
								return;
							}
							int ageCitizen = Integer.parseInt(view.getCitizenAgeString());
							if (!electionModel.isNumber(view.getCitizenIDString())) {
								view.showErrorMessage("The id must be a numbers");
								view.clear();
								return;
							}
							int id = Integer.parseInt(view.getCitizenIDString());
							if (id < 99999999 || id > 1000000000) {
								view.showErrorMessage("ID must have 9 digits");
								view.clear();
								return;
							}
							if (electionModel.findCitizenById(id) == true) {
								view.showErrorMessage("This citizen already exists");
								view.clear();
								return;
							}
							if (ageCitizen >= 1999 && ageCitizen <= 2002) {
								view.showErrorMessage("Adding a soldier is done separately");
								view.clear();
								return;
							}
							if (ageCitizen > 2002) {
								view.showErrorMessage("citizen must be over 18 years of age");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getHowMuchDaysSickString())) {
								view.showErrorMessage("The days must to contain just digits");
								view.clear();
								return;
							}
							if (view.getHowMuchDaysSick() <= 0) {
								view.showErrorMessage("The days must be up to 0 ");
								view.clear();
								return;
							}
							if (ageCitizen < 0 || ageCitizen > 2020) {
								view.showErrorMessage("Year of birth can be from 0-2020");
								view.clear();
								return;
							} else {

								electionModel.newSickCitizne(view.getCitizenName(), ageCitizen, true, id, 0,
										view.getHowMuchDaysSick());
								view.showSuccsessMessage("The Citizen was added successfully");
								view.clear();
							}

						}

					};
					view.EventSickCitizenButton(SickCitizenEvent);
					break;

				case "Add soldier":
					view.soldierMenu();
					EventHandler<ActionEvent> SoldierEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {

							if (view.getCitizenName().isEmpty() || view.getCitizenIDString().isEmpty()
									|| view.getCitizenAgeString().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getCitizenName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getCitizenAgeString())) {
								view.showErrorMessage("The date must to contain just digits");
								view.clear();
								return;
							}
							int ageCitizen = Integer.parseInt(view.getCitizenAgeString());
							if (!electionModel.isNumber(view.getCitizenIDString())) {
								view.showErrorMessage("The id must be a numbers");
								view.clear();
								return;
							}
							int id = Integer.parseInt(view.getCitizenIDString());
							if (id < 99999999 || id > 1000000000) {
								view.showErrorMessage("ID must have 9 digits");
								view.clear();
								return;
							}
							if (electionModel.findCitizenById(id) == true) {
								view.showErrorMessage("This citizen already exists");
								view.clear();
								return;
							}
							if (ageCitizen < 1999) {
								view.showErrorMessage("Adding a citizen is done separately");
								view.clear();
								return;
							}
							if (ageCitizen > 2002) {
								view.showErrorMessage("citizen must be over 18 years of age");
								view.clear();
								return;
							}
							if (ageCitizen < 0 || ageCitizen > 2020) {
								view.showErrorMessage("Year of birth can be from 0-2020");
								view.clear();
								return;
							} else {
								electionModel.newSoldier(view.getCitizenName(), ageCitizen, false, id, 0,
										view.getCheckIfCarryWeapon());
								view.showSuccsessMessage("The Citizen was added successfully");
								view.clear();
							}
						}

					};
					view.EventSoldierButton(SoldierEvent);
					break;
				case "Add sick soldier":
					view.sickSoldierMenu();
					EventHandler<ActionEvent> SickSoldierEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {

							if (view.getCitizenName().isEmpty() || view.getCitizenIDString().isEmpty()
									|| view.getCitizenAgeString().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getCitizenName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getCitizenAgeString())) {
								view.showErrorMessage("The date must to contain just digits");
								view.clear();
								return;
							}
							int ageCitizen = Integer.parseInt(view.getCitizenAgeString());
							if (!electionModel.isNumber(view.getCitizenIDString())) {
								view.showErrorMessage("The id must be a numbers");
								view.clear();
								return;
							}
							int id = Integer.parseInt(view.getCitizenIDString());
							if (id < 99999999 || id > 1000000000) {
								view.showErrorMessage("ID must have 9 digits");
								view.clear();
								return;
							}
							if (electionModel.findCitizenById(id) == true) {
								view.showErrorMessage("This citizen already exists");
								view.clear();
								return;
							}
							if (ageCitizen < 1999) {
								view.showErrorMessage("Adding a citizen is done separately");
								view.clear();
								return;
							}
							if (ageCitizen > 2002) {
								view.showErrorMessage("citizen must be over 18 years of age");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getHowMuchDaysSickString())) {
								view.showErrorMessage("The days must to contain just digits");
								view.clear();
								return;
							}
							if (view.getHowMuchDaysSick() <= 0) {
								view.showErrorMessage("The days must be up to 0 ");
								view.clear();
								return;
							}
							if (ageCitizen < 0 || ageCitizen > 2020) {
								view.showErrorMessage("Year of birth can be from 0-2020");
								view.clear();
								return;
							}

							else {
								electionModel.newSickSoldier(view.getCitizenName(), ageCitizen, true, id, 0,
										view.getCheckIfCarryWeapon(), view.getHowMuchDaysSick());
								view.showSuccsessMessage("The Citizen was added successfully");
								view.clear();
							}
						}

					};
					view.EventSickSoldierButton(SickSoldierEvent);
					break;

				case "Show all citizens":
					view.ShowDetails(electionModel.showAllCitizens());
					break;
				case "Add party":
					view.partyMenu();
					EventHandler<ActionEvent> PartyEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							if (view.getPartyName().isEmpty() || view.getPartyDayString().isEmpty()
									|| view.getPartyMonthString().isEmpty() || view.getPartyYearString().isEmpty()) {
								view.showErrorMessage("All details should be complete");
								view.clear();
								return;
							}
							if (!electionModel.isAlpha(view.getPartyName())) {
								view.showErrorMessage("The name need to contain just letters");
								view.clear();
								return;
							}
							if (!electionModel.isNumber(view.getPartyYearString())
									|| !electionModel.isNumber(view.getPartyDayString())
									|| !electionModel.isNumber(view.getPartyMonthString())) {
								view.showErrorMessage("The date must to contain just digits");
								view.clear();
								return;
							}
							int partyYear = Integer.parseInt(view.getPartyYearString());
							int partyDay = Integer.parseInt(view.getPartyDayString());
							int partyMonth = Integer.parseInt(view.getPartyMonthString());
							if (partyYear <= 0 || partyYear > 2020) {
								view.showErrorMessage("The year must be between 1-2020");
								view.clear();
								return;
							}
							if (partyMonth <= 0 || partyMonth > 12) {
								view.showErrorMessage("The month must be between 1-12");
								view.clear();
								return;
							}
							if (partyDay <= 0 || partyDay > 31) {
								view.showErrorMessage("The day must be between 1-31");
								view.clear();
								return;
							}
							Miflaga m = new Miflaga(view.getPartyName(), view.getPartyIdeology(), partyDay, partyMonth,
									partyYear);
							electionModel.getListOfMiflagot().add(m);
							view.showSuccsessMessage("The party was added successfully");
							view.clear();
						}
					};
					view.EventPartyButton(PartyEvent);
					break;
				case "Show all parties":
					view.ShowDetails(electionModel.showAllMiflagot());
					break;
				case "Add candidate to party":
					view.candidateMenu();
					EventHandler<ActionEvent> CandidateEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							if (!electionModel.isNumber(view.getCandidiateIDString())) {
								view.showErrorMessage("The ID must to contain just digits");
								view.clear();
								return;
							}
							for (int i = 0; i < electionModel.allCitizen.getList().size(); i++) {
								candidateHelper = true;
								if (electionModel.findCandidateById(view.getCandidiateID())) {
									view.showErrorMessage("This citizen is already a candidate");
									view.clear();
									return;
								} else if (view.getCandidiateID() == electionModel.allCitizen.get(i).getId()) {
									try {
										electionModel.newCandidate(electionModel.allCitizen.get(i).getName(),
												electionModel.allCitizen.get(i).getAge(),
												electionModel.allCitizen.get(i).getIsIsInIsolation(),
												view.getCandidiateID(), 0, 18, view.getCandidateParty());
										view.showSuccsessMessage("The Cndidate was added successfully");
										view.clear();
										candidateHelper = false;
										break;
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}

							if (candidateHelper) {
								view.showErrorMessage("No citizen exists");
								view.clear();
								return;
							}

						}

					};
					view.EventCandidateButton(CandidateEvent);
					break;
				case "Start eletion round":

					electionModel.resetVoting();
					view.StartElection();
					votealready = true;

					EventHandler<ActionEvent> choosingBtnEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							view.votingUpdate(electionModel.getIfInsolatedByName(view.getVoter()));

						}
					};

					view.addchoosingBtnEvent(choosingBtnEvent);

					EventHandler<ActionEvent> votingbtnEvent = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							if (view.getIfCBCornaViseble() && !view.isUsingProtectedSuit()) {
								view.showErrorMessage("you cont vote you are insolated with no protection siut");

								return;
							}
							if (electionModel.getVoterArray().length == 1) {
								electionModel.gettotalkalpiot().get(0).updateVote(view.getChosenParty());
								view.showSuccsessMessage("voting finished Bye Bye");
								view.clear();
								return;
							}
							view.showSuccsessMessage("your vote added");
							electionModel.gettotalkalpiot().get(0).updateVote(view.getChosenParty());
							electionModel.updateVoterList(view.getVoter());
							view.votingReset(electionModel.getVoterArray());

						}

					};
					view.addvotingbtnEvent(votingbtnEvent);

					break;
				case "Show results":

					if (!votealready) {
						view.showErrorMessage("No votes in this election round");
					} else {
						view.showResultsInPieChart();
					}
					break;

				}

			}

		};
		view.addMouseClickedEvenToMenu(mouseClickedEvent);
	}

	public static Elections getElectionModel() {
		return electionModel;
	}

}
