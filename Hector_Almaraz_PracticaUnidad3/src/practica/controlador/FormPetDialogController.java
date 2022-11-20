package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import practica.modelo.Mascota;

public class FormPetDialogController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ToggleGroup genero;

	@FXML
	private RadioButton hembraRadioButton;

	@FXML
	private RadioButton machoRadioButton;

	@FXML
	private TextField nombrePetTextField;

	@FXML
	private TextField pesoTextField;

	@FXML
	private TextField razaTextField;

	@FXML
	private ComboBox<String> especieComboBox;

	@FXML
    private Button cerrarButton;

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
		
		cerrarButton.setOnAction(event -> {
			dialogStage.close();
		});
		
		enviarButton.setOnAction(event -> {
			if (isInputValid()) {
				mascota.setEspecie(especieComboBox.getValue());
				mascota.setRaza(razaTextField.getText());
				mascota.setNombre(nombrePetTextField.getText());
				mascota.setPeso(Integer.parseInt(pesoTextField.getText()));

				okClicked = true;
				dialogStage.close();
			}
		});
	}

	/**
	 * Rellena los datos de la mascota que va a ser añadida o modificada en el
	 * diálogo
	 * 
	 * @param mascota
	 */
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;

		especieComboBox.setValue(mascota.getEspecie());
		razaTextField.setText(mascota.getRaza());
		nombrePetTextField.setText(mascota.getNombre());
		pesoTextField.setText(Integer.toString(mascota.getPeso()));
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Valida los campos de texto de la mascota
	 * 
	 * @return true si los campos son válidos
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (especieComboBox.getValue() == null || especieComboBox.getValue().length() == 0) {
			errorMessage += "El campo especie está vacío\n";
		}
		if (razaTextField.getText() == null || razaTextField.getText().length() == 0) {
			errorMessage += "El campo raza está vacío\n";
		}
		if (nombrePetTextField.getText() == null || nombrePetTextField.getText().length() == 0) {
			errorMessage += "El campo nombre está vacío\n";
		}

		if (pesoTextField.getText() == null || pesoTextField.getText().length() == 0) {
			errorMessage += "El campo peso está vacío\n";
		} else {
			// Se intenta convertir el código postal en entero y si da un error se muestra
			// un mensaje
			try {
				Integer.parseInt(pesoTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Peso no válido. Debe ser un número entero\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Se muestra un alert si no se puede eliminar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Hay campos incorrectos");
			errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
			errorAlert.setContentText(errorMessage);

			errorAlert.showAndWait();
			return false;
		}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
