package practica.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import practica.modelo.Veterinario;

public class MenuController {

	@FXML
	private TreeView<String> especiesTreeView;
	@FXML
	private TableView<Veterinario> equipoTableView;
	@FXML
	private TableColumn<Veterinario, String> especializacionCol;
	@FXML
	private TableColumn<Veterinario, String> nombreCol;
	@FXML
	private TableColumn<Veterinario, String> correoCol;
	// Lista auxiliar para TableView
	private ObservableList<Veterinario> data = FXCollections.observableArrayList(
			new Veterinario("John Doe", "Veterinario", "john@correo.com"),
			new Veterinario("Liz Fernandez", "Peluquería Canina", "liz@correo.com"),
			new Veterinario("María García", "Veterinaria", "maria@correo.com"),
			new Veterinario("Pepe Perez", "Auxiliar Técnico Veterinario", "pepe@correo.com"));

	@FXML
	private void initialize() {

		// Asociamos cada columna del TableView a una propiedad de la clase Person
		nombreCol.setCellValueFactory(new PropertyValueFactory<Veterinario, String>("nombre"));
		especializacionCol.setCellValueFactory(new PropertyValueFactory<Veterinario, String>("especializacion"));
		correoCol.setCellValueFactory(new PropertyValueFactory<Veterinario, String>("correo"));
		// Se rellena la tabla con objetos de la clase Person
		equipoTableView.setItems(data);
		// imagen treeview

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/practica/images/huellasTree.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Icono para el TreeView
		ImageView imageView = new ImageView(new Image(fis));
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(20);

		// TreeView con icono
		TreeItem<String> rootItem = new TreeItem<String>("Especies", imageView);
		rootItem.setExpanded(true);

		List<String> treeListItems = new ArrayList<String>(Arrays.asList("Perro", "Gato", "Ave", "Pez", "Otro"));

		// Nodos del TreeView
		for (String item : treeListItems) {
			TreeItem<String> treeItem = new TreeItem<String>(item);
			rootItem.getChildren().add(treeItem);
		}

		especiesTreeView.setRoot(rootItem);
	}

}
