package practica.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import practica.Menu;
import practica.modelo.Mascota;

public class PerfilController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label telefonoUserLabel;

	@FXML
	private Label domicilioUserLabel;

	@FXML
	private Label emailUserLabel;

	@FXML
	private Label nombreUserLabel;

	@FXML
	private Button aniadirPetButton;

	@FXML
	private Button borrarPetButton;

	@FXML
	private Button editarPetButton;

	@FXML
	private Button editarUserButton;

	@FXML
	private TableView<Mascota> mascotasTableView;

	@FXML
	private TableColumn<Mascota, String> especieCol;

	@FXML
	private TableColumn<Mascota, String> nombreCol;

	@FXML
	private TableColumn<Mascota, String> razaCol;

	@FXML
	private TableColumn<Mascota, Integer> pesoCol;
	private Menu mainApp;

	@FXML
	void initialize() {
		aniadirPetButton.setOnAction(event -> {
			try {
				Mascota mascota = new Mascota();
				// Cargamos el diseño del diálogo desdeun XML
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(PerfilController.class.getResource("view/PersonEditDialog.fxml"));
				AnchorPane page = (AnchorPane) loader.load();

				// Se crea un nuevo Stage para mostrar el diálogo
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Crear o editar persona");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(mainApp.getPrimaryStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Carga la persona en el controlador
				FormPetDialogController controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setMascota(mascota);

				// Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
				dialogStage.showAndWait();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	public void setMainAppPerfil(Menu mainApp) {
		this.mainApp = mainApp;
	}
}
