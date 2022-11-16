package practica.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mascota {
	private final StringProperty raza;
	private final StringProperty especie;
	private final StringProperty nombre;
	private final IntegerProperty peso;

	public Mascota() {
		this(null, null, null, 0);
	}

	public Mascota(String raza, String especie, String nombre, int peso) {
		super();
		this.raza = new SimpleStringProperty(raza);
		this.especie = new SimpleStringProperty(especie);
		this.nombre = new SimpleStringProperty(nombre);
		this.peso = new SimpleIntegerProperty(peso);
	}

	public String getRaza() {
		return raza.get();
	}

	public void setRaza(String raza) {
		this.raza.set(raza);
	}

	public StringProperty razaProperty() {
		return raza;
	}

	public String getEspecie() {
		return especie.get();
	}

	public void setEspecie(String especie) {
		this.especie.set(especie);
	}

	public StringProperty especieProperty() {
		return especie;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public int getPeso() {
		return peso.get();
	}

	public void setPeso(int peso) {
		this.peso.set(peso);
	}

	public IntegerProperty pesoProperty() {
		return peso;
	}

}
