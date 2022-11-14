package practica.controlador;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PerfilController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<?, ?> especieCol;

	@FXML
	private TableView<?> mascotasTableView;

	@FXML
	private TableColumn<?, ?> nombreCol;

	@FXML
	private TableColumn<?, ?> pesoCol;

	@FXML
	private TableColumn<?, ?> razaCol;

	@FXML
	void initialize() {
		

	}

}
