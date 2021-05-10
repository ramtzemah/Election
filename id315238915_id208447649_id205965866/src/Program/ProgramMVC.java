package Program;

import javafx.application.Application;
import javafx.stage.Stage;
import Controller.Controller;
import Model.Elections;
import View.View;

public class ProgramMVC extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Elections electionModel = new Elections();
		View theView = new View(primaryStage);
		Controller TheController = new Controller(electionModel, theView);

	}
}
