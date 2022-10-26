package practica.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veterinario {

	private final StringProperty nombre;
	private final StringProperty especializacion;
	private final StringProperty correo;

	/**
	 * Constructor por defecto
	 */
	public Veterinario() {
		this(null, null, null);
	}

	/**
	 * Constructor con nombre, especializacion y correo
	 * 
	 * @param nombre
	 * @param especializacion
	 * @param correo
	 */
	public Veterinario(String nombre, String especializacion, String correo) {
		this.nombre = new SimpleStringProperty(nombre);
		this.especializacion = new SimpleStringProperty(especializacion);
		this.correo = new SimpleStringProperty(correo);

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

	public String getEspecializacion() {
		return especializacion.get();
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion.set(especializacion);
	}

	public StringProperty especializacionProperty() {
		return especializacion;
	}

	public String getCorreo() {
		return correo.get();
	}

	public void setCorreo(String correo) {
		this.correo.set(correo);
	}

	public StringProperty correoProperty() {
		return correo;
	}

}
