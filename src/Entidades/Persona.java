package Entidades;

import javax.swing.Spring;

public class Persona {
	
	String apellido;
	String DNI;
	int id;
	String nombre;
	String usuario;
	String Categoria;
	
	String Estados;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstados() {
		return Estados;
	}
	public void setEstados(String estados) {
		Estados = estados;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	String contraseña;
	public Persona(){
		
	}
	public Persona(String nombre, String apellido, String dni, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = dni;
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getIdUsuario() {
		return id;
	}
	public void setIdUsuario(int id) {
		this.id = id;
	}
	
	
	

}
