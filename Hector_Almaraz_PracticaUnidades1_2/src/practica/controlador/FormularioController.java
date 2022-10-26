package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;

public class FormularioController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<Object> especieChoiceBox;

	@FXML
	private ToggleGroup genero;

	@FXML
	void abrirFormulario(ActionEvent event) {

	}

	@FXML
	void cerrarListado(ActionEvent event) {

	}

	@FXML
	void initialize() {

		// ChoiceBox con separador
		especieChoiceBox.setItems(FXCollections.observableArrayList("Perro",
				"Gato","Ave", "Pez", new Separator(), "Otro"));
		especieChoiceBox.setValue("Selecciona una especie...");
	}

}
