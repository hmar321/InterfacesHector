package practica;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practica.controlador.MenuController;
import practica.modelo.Veterinario;

public class Menu extends Application {
	private BorderPane rootLayout;
	// Listado de personas de la aplicación
	private ObservableList<Veterinario> equipoData = FXCollections.observableArrayList();

	public Menu() {
		equipoData.add(new Veterinario("John Doe", "Veterinario","john@correo.com"));
		equipoData.add(new Veterinario("Liz Fernandez", "Peluquería Canina","liz@correo.com"));
		equipoData.add(new Veterinario("María", "Veterinaria","maria@correo.com"));
		equipoData.add(new Veterinario("Pepe Perez", "Auxiliar Técnico Veterinario","pepe@correo.com"));
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Menu.class.getResource("vista/Menu.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			//MenuController menuController = loader.getController();
			//menuController.setRootLayout(rootLayout);
			//menuController.setMenuApp(this);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * Método get para lista de Veterinario
	 * @return
	 */
	public ObservableList<Veterinario> getVeterinarioData() {
		return equipoData;
	}

}
