package Entidades;

public class Elemento {
	int id_elemento;

	public Elemento() {

	}

	public Elemento(String nombre, int id, int cantidad) {
		this.setNombre_elemento(nombre);
		this.setId_elemento(id);
		this.setCantidad_elemento(cantidad);
	}

	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

	public int getCantidad_elemento() {
		return cantidad_elemento;
	}

	public void setCantidad_elemento(int cantidad_elemento) {
		this.cantidad_elemento = cantidad_elemento;
	}

	public String getNombre_elemento() {
		return nombre_elemento;
	}

	public void setNombre_elemento(String nombre_elemento) {
		this.nombre_elemento = nombre_elemento;
	}

	int cantidad_elemento;
	String nombre_elemento;

}
