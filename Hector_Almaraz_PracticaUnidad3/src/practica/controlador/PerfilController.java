package practica.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import practica.Menu;
import practica.modelo.Mascota;

public class PerfilController {

	private Menu mainApp;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label especieLabel;

	@FXML
	private Label nombrePetLabel;

	@FXML
	private Label pesoLabel;

	@FXML
	private Label razaLabel;

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
	private TableColumn<Mascota, Number> pesoCol;

	@FXML
	void initialize() {
		razaCol.setCellValueFactory(cellData -> cellData.getValue().razaProperty());
		especieCol.setCellValueFactory(cellData -> cellData.getValue().especieProperty());
		nombreCol.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		pesoCol.setCellValueFactory(cellData -> cellData.getValue().pesoProperty());
		showMascotaDetails(null);
		mascotasTableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showMascotaDetails(newValue));
		// mascotasTableView
		aniadirPetButton.setOnAction(event -> {
			Mascota tempMascota = new Mascota();
	        boolean okClicked = mainApp.showMascotaEditDialog(tempMascota);
	        if (okClicked) {
	            mainApp.getMascotaData().add(tempMascota);
	        }
		});
		borrarPetButton.setOnAction(event->{
			int selectedIndex = mascotasTableView.getSelectionModel().getSelectedIndex();
	    	
	    	// Si no hay ningún campo seleccionado, se muestra un alert
	    	if (selectedIndex >= 0) {
	    		// Si se ha seleccionado una fila, se muestra un pop up de confirmación
	    		Alert confirm = new Alert(AlertType.CONFIRMATION);
	        	
	    		confirm.setTitle("Confirmación para eliminar");
	    		//errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
	    		confirm.setContentText("¿Está seguro de eliminar la fila actual?");
	    		    	    		
	    		// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
	    		confirm.showAndWait().ifPresent(response -> {
	    			if (response == ButtonType.OK) {
	    				mascotasTableView.getItems().remove(selectedIndex);
	    		    }
	    		});
	    	} else {
	    		// Se muestra un alert si no se puede eliminar la fila
	    		Alert errorAlert = new Alert(AlertType.ERROR);
	        	
	    		errorAlert.setTitle("Error al eliminar");
	    		errorAlert.setHeaderText("Se ha producido un error");
	    		errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");
	    		
	    		errorAlert.showAndWait();
	    	}
		});
		editarPetButton.setOnAction(event->{
			 Mascota selectedMascota = mascotasTableView.getSelectionModel().getSelectedItem();
		        if (selectedMascota != null) {
		            boolean okClicked = mainApp.showMascotaEditDialog(selectedMascota);
		            if (okClicked) {
		            	showMascotaDetails(selectedMascota);
		            }

		        } else {
		        	// Se muestra un alert si no se puede eliminar la fila
		    		Alert errorAlert = new Alert(AlertType.ERROR);
		        	
		    		errorAlert.setTitle("Error al editar mascota");
		    		errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
		    		errorAlert.setContentText("Por favor, selecciona una mascota en la tabla");
		    		
		    		errorAlert.showAndWait();
		        }
		});
	}

	public void setMainAppPerfil(Menu mainApp) {
		this.mainApp = mainApp;
		mascotasTableView.setItems(this.mainApp.getMascotaData());
	}
	/**
     * Rellena todos los campos para mostrar información detallada de una mascota
     * Si el parámero es nulo, entonces se rellenan en blanco
     * 
     * @param mascota o null
     */
	private void showMascotaDetails(Mascota mascota) {
		if (mascota != null) {
			// Si el campo contiene datos, entonces se rellena la información
			especieLabel.setText(mascota.getEspecie());
			razaLabel.setText(mascota.getRaza());
			nombrePetLabel.setText(mascota.getNombre());
			pesoLabel.setText(Integer.toString(mascota.getPeso()));
		} else {
			// Person is null, remove all the text.
			especieLabel.setText("");
			razaLabel.setText("");
			nombrePetLabel.setText("");
			pesoLabel.setText("");
		}
	}

}
