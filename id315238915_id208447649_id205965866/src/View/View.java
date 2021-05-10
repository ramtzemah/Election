package View;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.*;
import Controller.Controller;
import Model.Elections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*; //import to menu

public class View {

	Elections useElection = new Elections();
	private Menu ballotMenu, citizenMenu, partiesMenu, electionMenu;

	private MenuItem addBallotMenuItems, showBallotMenuItems, addCitizenMenuItems, showCitizenMenuItems, addPartyMenuItems,
			showPartiesMenuItems, addCandidateMenuItems, startElectionMenuItems, showResultsMenuItems, addSickCitizen,
			addSoldier, addSickSolsier;

	private MenuBar menuBar;
	private VBox vb, vbVoting;
	private HBox hbVoters, hbParties;
	private GridPane gpRoot;
	private Label lblVoterList, lblPartyList;
	private TextField tfName, ballotName, citizenName, citizenID, citizenAge, HowMuchDaysSick, PartyYear, PartyMonth, PartyDay,
			partyName, candidiateID;
	private Button ballotButton, PartyButton, citizenButton, sickCitizenButton, sickSoldierButton, soldierButton,
			candidateButtom, chooseButton, voteButton;
	private ComboBox<String> cmbBallotKind, cmbPartyIdeology, cmbParties, cmbBallotBox, cmbAllvoters;

	private CheckBox checkIfCarryWeapon, usingSuit;

	public View(Stage s) throws Exception {
		s.setTitle("Welcome to election round");
		// create a menus
		ballotMenu = new Menu("Ballot box");
		citizenMenu = new Menu("Citizen");
		partiesMenu = new Menu("Party");
		electionMenu = new Menu("Election");
		// create menu items
		// ballot menu items
		addBallotMenuItems = new MenuItem("Add ballot box");
		showBallotMenuItems = new MenuItem("Show ballot box");

		// citizen menu items
		addCitizenMenuItems = new MenuItem("Add citizen");
		addSickCitizen = new MenuItem("Add sick citizen");
		addSoldier = new MenuItem("Add soldier");
		addSickSolsier = new MenuItem("Add sick soldier");
		showCitizenMenuItems = new MenuItem("Show all citizens");

		// parties menu items
		addPartyMenuItems = new MenuItem("Add party");
		showPartiesMenuItems = new MenuItem("Show all parties");
		addCandidateMenuItems = new MenuItem("Add candidate to party");

		// election menu items
		startElectionMenuItems = new MenuItem("Start eletion round");
		showResultsMenuItems = new MenuItem("Show results");
		// add menu items to menu
		ballotMenu.getItems().addAll(addBallotMenuItems, showBallotMenuItems);
		citizenMenu.getItems().addAll(addCitizenMenuItems, addSickCitizen, addSoldier, addSickSolsier,
				showCitizenMenuItems);
		partiesMenu.getItems().addAll(addPartyMenuItems, showPartiesMenuItems, addCandidateMenuItems);
		electionMenu.getItems().addAll(startElectionMenuItems, showResultsMenuItems);

		// create a menu bar
		menuBar = new MenuBar();
		// add menu to menu bar
		menuBar.getMenus().addAll(ballotMenu, citizenMenu, partiesMenu, electionMenu);
		// create a VBox
		vb = new VBox(menuBar);
		// create a scene
		Scene sc = new Scene(vb, 500, 300);
		// set the scene
		s.setScene(sc);
		s.show();

		gpRoot = new GridPane();
		tfName = new TextField();
		// Elections useElection = new Elections();
		useElection.createHardCoded();
	}

	public void addMouseClickedEvenToMenu(EventHandler<ActionEvent> mouseClickedEvent) {
		addBallotMenuItems.setOnAction(mouseClickedEvent);
		showBallotMenuItems.setOnAction(mouseClickedEvent);

		addCitizenMenuItems.setOnAction(mouseClickedEvent);
		showCitizenMenuItems.setOnAction(mouseClickedEvent);
		addSickCitizen.setOnAction(mouseClickedEvent);
		addSoldier.setOnAction(mouseClickedEvent);
		addSickSolsier.setOnAction(mouseClickedEvent);

		addPartyMenuItems.setOnAction(mouseClickedEvent);
		showPartiesMenuItems.setOnAction(mouseClickedEvent);
		addCandidateMenuItems.setOnAction(mouseClickedEvent);

		startElectionMenuItems.setOnAction(mouseClickedEvent);
		showResultsMenuItems.setOnAction(mouseClickedEvent);
	}

	public void ShowDetails(String details) {
		ScrollPane sp = new ScrollPane(); // If the string is too long
		Label txt = new Label(details);
		sp.setContent(txt);
		sp.setMinWidth(400);
		sp.setMinHeight(250);
		vb.getChildren().addAll(sp);

	}

	public void clear() {
		vb.getChildren().clear();
		vb.getChildren().add(menuBar);

	}

	public void showErrorMessage(String errorMessage) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(errorMessage);
		alert.show();
	}

	public void showSuccsessMessage(String succsessMessage) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText(succsessMessage);
		alert.show();
	}

	public void ballotMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);
		ballotName = new TextField();
		cmbBallotKind = new ComboBox<String>();
		cmbBallotKind.getItems().addAll("Regular", "Soldier", "Sick soldier", "Sick citizen");
		cmbBallotKind.getSelectionModel().select(0);

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("City Name:"), 0, 0);
		gpRoot.add(ballotName, 1, 0);
		gpRoot.add(new Label("Ballot Kind:"), 0, 1);
		gpRoot.add(cmbBallotKind, 1, 1);
		ballotButton = new Button("Add Ballot");
		gpRoot.add(ballotButton, 0, 3);

		vb.getChildren().add(gpRoot);

	}

	public void citizeMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);

		citizenName = new TextField();
		citizenID = new TextField();
		citizenAge = new TextField();
		citizenButton = new Button("Finish!");

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Name:"), 0, 0);
		gpRoot.add(citizenName, 1, 0);
		gpRoot.add(new Label("ID:"), 0, 1);
		gpRoot.add(citizenID, 1, 1);
		gpRoot.add(new Label("What is your birth year"), 0, 2);
		gpRoot.add(citizenAge, 1, 2);
		gpRoot.add(citizenButton, 0, 4);

		vb.getChildren().add(gpRoot);

	}

	public void sickCitizeMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);

		citizenName = new TextField();
		citizenID = new TextField();
		citizenAge = new TextField();
		HowMuchDaysSick = new TextField();
		sickCitizenButton = new Button("Finish!");

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Name:"), 0, 0);
		gpRoot.add(citizenName, 1, 0);
		gpRoot.add(new Label("ID:"), 0, 1);
		gpRoot.add(citizenID, 1, 1);
		gpRoot.add(new Label("What is your birth year"), 0, 2);
		gpRoot.add(citizenAge, 1, 2);
		gpRoot.add(new Label("How many days you are in isolation?"), 0, 3);
		gpRoot.add(HowMuchDaysSick, 1, 3);
		gpRoot.add(sickCitizenButton, 0, 5);

		vb.getChildren().add(gpRoot);

	}

	public void soldierMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);

		citizenName = new TextField();
		citizenID = new TextField();
		citizenAge = new TextField();
		HowMuchDaysSick = new TextField();
		soldierButton = new Button("Finish!");

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Name:"), 0, 0);
		gpRoot.add(citizenName, 1, 0);
		gpRoot.add(new Label("ID:"), 0, 1);
		gpRoot.add(citizenID, 1, 1);
		gpRoot.add(new Label("What is your birth year"), 0, 2);
		gpRoot.add(citizenAge, 1, 2);
		checkIfCarryWeapon = new CheckBox("Carry weapon");
		gpRoot.add(checkIfCarryWeapon, 0, 3);
		gpRoot.add(soldierButton, 0, 5);

		vb.getChildren().add(gpRoot);

	}

	public void sickSoldierMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);

		citizenName = new TextField();
		citizenID = new TextField();
		citizenAge = new TextField();
		HowMuchDaysSick = new TextField();
		sickSoldierButton = new Button("Finish!");

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Name:"), 0, 0);
		gpRoot.add(citizenName, 1, 0);
		gpRoot.add(new Label("ID:"), 0, 1);
		gpRoot.add(citizenID, 1, 1);
		gpRoot.add(new Label("What is your birth year"), 0, 2);
		gpRoot.add(citizenAge, 1, 2);
		checkIfCarryWeapon = new CheckBox("Carry weapon");
		gpRoot.add(checkIfCarryWeapon, 0, 3);
		gpRoot.add(new Label("How many days you are in isolation?"), 0, 4);
		gpRoot.add(HowMuchDaysSick, 1, 4);
		gpRoot.add(sickSoldierButton, 0, 6);

		vb.getChildren().add(gpRoot);

	}

	public void candidateMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);

		candidiateID = new TextField();

		cmbParties = new ComboBox<String>();
		for (int i = 0; i < Controller.getElectionModel().getListOfMiflagot().size(); i++) {
			cmbParties.getItems().add(Controller.getElectionModel().getListOfMiflagot().get(i).getName());
		}
		cmbParties.getSelectionModel().select(0);

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Candidate ID: "), 0, 0);
		gpRoot.add(candidiateID, 0, 1);
		gpRoot.add(new Label("The party: "), 1, 0);
		gpRoot.add(cmbParties, 1, 1);

		candidateButtom = new Button("Add Candidate!");
		gpRoot.add(candidateButtom, 0, 2);

		vb.getChildren().add(gpRoot);

	}

	public void partyMenu() {
		gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.CENTER_LEFT);
		gpRoot.setVgap(10);
		gpRoot.setHgap(15);
		// Ideology
		partyName = new TextField();
		cmbPartyIdeology = new ComboBox<String>();
		cmbPartyIdeology.getItems().addAll("Left", "Right", "Center");
		cmbPartyIdeology.getSelectionModel().select(0);
		// Date
		PartyYear = new TextField();
		PartyMonth = new TextField();
		PartyDay = new TextField();

		Label lblYourDetails = new Label();
		lblYourDetails.setWrapText(true);

		gpRoot.add(new Label("Party Name:"), 0, 0);
		gpRoot.add(partyName, 2, 0);
		gpRoot.add(new Label("Party Ideology:"), 0, 1);
		gpRoot.add(cmbPartyIdeology, 1, 1);
		gpRoot.add(new Label("Year of party creation:"), 0, 2);
		gpRoot.add(PartyYear, 2, 2);
		gpRoot.add(new Label("Month of party creation:"), 0, 3);
		gpRoot.add(PartyMonth, 2, 3);
		gpRoot.add(new Label("Day of party creation:"), 0, 4);
		gpRoot.add(PartyDay, 2, 4);

		PartyButton = new Button("Add Party");
		gpRoot.add(PartyButton, 2, 5);

		vb.getChildren().add(gpRoot);
	}

	public String getBallotName() {
		return ballotName.getText();
	}

	public String getCitizenIDString() {
		return citizenID.getText();
	}

	public int getHowMuchDaysSick() {
		return Integer.parseInt(HowMuchDaysSick.getText());
	}

	public String getHowMuchDaysSickString() {
		return (HowMuchDaysSick.getText());
	}

	public String getCitizenAgeString() {
		return citizenAge.getText();
	}

	public String getPartyYearString() {
		return PartyYear.getText();
	}

	public String getPartyMonthString() {
		return PartyMonth.getText();
	}

	public String getPartyDayString() {
		return PartyDay.getText();
	}

	public int getCandidiateID() {
		return Integer.parseInt(candidiateID.getText());
	}

	public String getCandidiateIDString() {
		return (candidiateID.getText());
	}

	public String getCandidateParty() {
		return cmbParties.getValue();
	}

	public String getPartyName() {
		return partyName.getText();
	}

	public String getCitizenName() {
		return citizenName.getText();
	}

	public boolean getCheckIfCarryWeapon() {
		if (checkIfCarryWeapon != null) {
			return true;
		}

		return false;
	}

	public int getPartyIdeology() {
		switch (cmbPartyIdeology.getValue()) {
		case "Left":
			return 1;
		case "Right":
			return 2;
		case "Center":
			return 3;
		}
		return 0;
	}

	public int getBallotKind() {
		switch (cmbBallotKind.getValue()) {
		case "Regular":
			return 1;
		case "Soldier":
			return 2;
		case "Sick soldier":
			return 3;
		case "Sick citizen":
			return 4;
		}
		return 0;
	}

	public void EventBallotButton(EventHandler<ActionEvent> EventButton) {
		ballotButton.setOnAction(EventButton);

	}

	public void EventPartyButton(EventHandler<ActionEvent> EventButton) {
		PartyButton.setOnAction(EventButton);

	}

	public void EventCitizenButton(EventHandler<ActionEvent> EventButton) {
		citizenButton.setOnAction(EventButton);

	}

	public void EventSickCitizenButton(EventHandler<ActionEvent> EventButton) {
		sickCitizenButton.setOnAction(EventButton);

	}

	public void EventSoldierButton(EventHandler<ActionEvent> EventButton) {
		soldierButton.setOnAction(EventButton);

	}

	public void EventSickSoldierButton(EventHandler<ActionEvent> EventButton) {
		sickSoldierButton.setOnAction(EventButton);

	}

	public void EventCandidateButton(EventHandler<ActionEvent> EventButton) {
		candidateButtom.setOnAction(EventButton);

	}

	public void addvotingbtnEvent(EventHandler<ActionEvent> votingbtnEvent) {
		voteButton.setOnAction(votingbtnEvent);

	}

	public void addchoosingBtnEvent(EventHandler<ActionEvent> choosingBtnEvent) {
		chooseButton.setOnAction(choosingBtnEvent);

	}

	public void StartElection() {

		cmbAllvoters = new ComboBox<String>();

		cmbAllvoters.getItems().addAll(Controller.getElectionModel().getVoterArray());
		cmbAllvoters.getSelectionModel().select(0);

		cmbParties = new ComboBox<String>();
		cmbParties.getItems().addAll(Controller.getElectionModel().getAllPartiesList());

		cmbParties.setValue(Controller.getElectionModel().getPartyNameByNumInArr(0));

		lblVoterList = new Label("choose voter:");
		lblPartyList = new Label("choose party:");

		usingSuit = new CheckBox("You in insolation, press if you waering protection suit ");
		usingSuit.setSelected(false);

		hbVoters = new HBox(lblVoterList, cmbAllvoters);
		hbVoters.setAlignment(Pos.CENTER);
		hbVoters.setSpacing(10);
		hbVoters.setPadding(new Insets(10));

		hbParties = new HBox(lblPartyList, cmbParties);
		hbParties.setAlignment(Pos.CENTER);
		hbParties.setSpacing(10);
		hbParties.setPadding(new Insets(10));

		chooseButton = new Button("press to Choose");
		voteButton = new Button("Press to vote");

		vbVoting = new VBox(hbVoters, chooseButton, usingSuit, hbParties, voteButton);
		vbVoting.setAlignment(Pos.CENTER);
		vbVoting.setSpacing(10);
		vbVoting.setPadding(new Insets(10));

		hbVoters.setVisible(true);
		chooseButton.setVisible(true);
		usingSuit.setVisible(false);
		hbParties.setVisible(false);
		voteButton.setVisible(false);

		vb.getChildren().add(vbVoting);

	}

	public void votingReset(String[] voters) {
		cmbAllvoters.getItems().clear();
		cmbAllvoters.getItems().addAll(voters);
		if (Controller.getElectionModel().getVoterArray().length > 0) {
			cmbAllvoters.setValue(Controller.getElectionModel().getVoterArray()[0]);
		}
		hbVoters.setVisible(true);
		chooseButton.setVisible(true);
		hbParties.setVisible(false);
		voteButton.setVisible(false);
		usingSuit.setVisible(false);
		usingSuit.setSelected(false);

	}

	public String getVoter() {
		return cmbAllvoters.getValue();

	}

	public void votingUpdate(boolean ifInsolated) {
		hbVoters.setVisible(false);
		chooseButton.setVisible(false);
		usingSuit.setVisible(ifInsolated);

		hbParties.setVisible(true);
		voteButton.setVisible(true);

	}

	public String getChosenParty() {

		return cmbParties.getValue();
	}

	public void updateCoronaChheckBox(boolean ifInsolated) {

		usingSuit.setVisible(ifInsolated);

	}

	public boolean isUsingProtectedSuit() {

		return usingSuit.isSelected();

	}

	public boolean getIfCBCornaViseble() {

		return usingSuit.isVisible();
	}

	public void showResultsInPieChart() {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < Controller.getElectionModel().getListOfMiflagot().size(); i++) {

			pieChartData.add(new PieChart.Data(Controller.getElectionModel().getListOfMiflagot().get(i).getName(),
					Controller.getElectionModel().gettotalkalpiot().get(0).getVote(i)));
		}

		PieChart pc = new PieChart(pieChartData);
		vb.getChildren().add(pc);

	}
}
