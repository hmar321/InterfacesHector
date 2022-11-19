package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import practica.modelo.Mascota;

public class FormPetDialogController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> especieComboBox;

	@FXML
	private ToggleGroup genero;

	@FXML
	private Button cerraButton;

	@FXML
	private Button enviarButton;

	private Stage dialogStage;
    private Mascota mascota;
    private boolean okClicked = false;

	@FXML
	void initialize() {

		// ChoiceBox con separador
		especieComboBox.getItems().addAll("Perro", "Gato", "Ave", "Pez", "Otro");
		especieComboBox.setValue("Selecciona una especie...");
		cerraButton.setOnAction(event -> {

		});
		enviarButton.setOnAction(event -> {

		});
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

}
