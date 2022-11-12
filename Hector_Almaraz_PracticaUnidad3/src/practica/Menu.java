package practica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practica.controlador.RootController;

public class Menu extends Application {
	private BorderPane rootLayout;

	// Listado de personas de la aplicación
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Menu.class.getResource("vista/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			RootController rootController = loader.getController();
			rootController.setRootLayout(rootLayout);
			rootController.setMenu();

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

}
