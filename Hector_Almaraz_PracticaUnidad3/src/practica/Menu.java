package practica;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import practica.controlador.FormPetDialogController;
import practica.controlador.PerfilController;
import practica.controlador.RootController;
import practica.modelo.Mascota;

public class Menu extends Application {
	private BorderPane rootLayout;
	private Stage primaryStage;
	private ObservableList<Mascota> mascotaData = FXCollections.observableArrayList();
	
	

	// Listado de personas de la aplicación
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Prueba");
		setRootLayout();
		setMenu();
	}
	
	public Menu() {
		mascotaData.add(new Mascota("Dachshund", "Perro", "Pocoloco", 9));
		mascotaData.add(new Mascota("Munchkin ", "Gato", "John", 3));
		mascotaData.add(new Mascota("carassius auratus", "Pez", "Gimbo", 15));
		mascotaData.add(new Mascota("Majorero", "Perro", "Chico", 40));
	}

	public static void main(String[] args) {
		launch(args);
	}
	private void setRootLayout() {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Menu.class.getResource("vista/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			RootController rootController = loader.getController();
			rootController.setMainApp(this);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void setTutorial() {
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
	}

	public void setPerfil() {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("/practica/vista/Perfil.fxml"));
			HBox listadoControles = (HBox) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
			
			PerfilController controller = loader.getController();
	        controller.setMainAppPerfil(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean showMascotaEditDialog(Mascota mascota) {
	    try {
	        // Cargamos el diseño del diálogo desde un XML
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Menu.class.getResource("/practica/vista/FormPetDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Se crea un nuevo Stage para mostrar el diálogo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Crear o editar mascota");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Carga la persona en el controlador
	        FormPetDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setMascota(mascota);

	        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean showUsuarioEditDialog(Mascota mascota) {
	    try {
	        // Cargamos el diseño del diálogo desde un XML
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Menu.class.getResource("/practica/vista/FormPetDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Se crea un nuevo Stage para mostrar el diálogo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Crear o editar mascota");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Carga la persona en el controlador
	        FormPetDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setMascota(mascota);

	        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public ObservableList<Mascota> getMascotaData() {
		return mascotaData;
	}

}
