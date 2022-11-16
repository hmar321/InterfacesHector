package practica.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RootController {
	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout;

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
	private void cerrarListado(ActionEvent event) {
		// Se elimina el contenido del nodo central
		rootLayout.setCenter(null);
	}

	@FXML
	void initialize() {
		menuButton.setOnAction(event -> {
			try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(RootController.class.getResource("/practica/vista/Menu.fxml"));
				BorderPane listadoControles = (BorderPane) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		tutorialButton.setOnAction(event -> {
			try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(RootController.class.getResource("/practica/vista/Tutorial.fxml"));
				HBox listadoControles = (HBox) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		perfilButton.setOnAction(event->{
			try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(RootController.class.getResource("/practica/vista/Perfil.fxml"));
				HBox listadoControles = (HBox) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public void setMenu() {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("/practica/vista/Menu.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
