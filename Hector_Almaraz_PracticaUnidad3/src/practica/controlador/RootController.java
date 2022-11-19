package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import practica.Menu;

public class RootController {
	// Pantalla principal en la que se añade o quita contenido
	private Menu mainApp;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	@FXML
	private MenuItem perfilButton;

	@FXML
	private MenuItem menuButton;

	@FXML
	private MenuItem tutorialButton;

	@FXML
	void initialize() {
		menuButton.setOnAction(event -> {
			mainApp.setMenu();
		});
		tutorialButton.setOnAction(event -> {
			mainApp.setTutorial();
		});
		perfilButton.setOnAction(event->{
			mainApp.setPerfil();
		});
	}

	public void setMainApp(Menu mainApp) {
		this.mainApp=mainApp;
	}

}
