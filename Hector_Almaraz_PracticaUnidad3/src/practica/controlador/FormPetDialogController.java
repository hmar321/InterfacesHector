package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
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
		nombrePetTextField.setOnKeyPressed((event) -> mostrarTecla(event, "presionada"));
		nombrePetTextField.setOnKeyReleased((event) -> mostrarTecla(event, "soltada"));
		nombrePetTextField.setOnKeyTyped((event) -> mostrarTecla(event, "escrita"));
		razaTextField.addEventHandler(KeyEvent.KEY_TYPED, event -> {

			String type = event.getEventType().getName();
			String source = event.getSource().getClass().getSimpleName();
			String target = event.getTarget().getClass().getSimpleName();

			System.out.println("handler: " + type + ", " + source + ", " + target);

			if (!Character.isAlphabetic(event.getCharacter().charAt(0))) {
				System.out.println("caracter: " + event.getCharacter() + ", solo se permite texto.");
				event.consume();
			}
		});

		pesoTextField.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
			System.out.print("Codigo: " + e.getCode().getChar() + "-> " + e.getCode().getCode());
			System.out.println(" Texto: " + e.getText());
		});

		pesoTextField.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {
			System.out.println("Caracter: " + e.getCharacter());
			if (!Character.isDigit(e.getCharacter().charAt(0))) {
				e.consume();
				System.out.println("Solo se admiten numeros.");
			}
		});
		especieComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
		});
	}

	private void mostrarTecla(KeyEvent event, String accion) {
		System.out.println("Tecla " + accion + " " + event.getEventType().getName() + ": " + event.getCode() + ","
				+ " Key text " + event.getEventType().getName() + ": " + event.getText() + "," + " Key character "
				+ event.getEventType().getName() + ": " + (int) event.getCharacter().charAt(0));
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
