package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosElementos;
import Datos.DatosUsuarios;
import Datos.Login;
import Entidades.Elemento;
import Entidades.Persona;

public class Controlador {
	private DatosElementos de;
	private DatosUsuarios du;

	Scanner w = new Scanner(System.in);
	private ArrayList<Elemento> el = new ArrayList<Elemento>();
	private ArrayList<Persona> pe = new ArrayList<Persona>();

	public Controlador() {
		de = new DatosElementos();
		pe.add(new Persona("jose", "piccoli", "123123", 1));
		pe.add(new Persona("analia", "salazar", "123321",2 ));

	}

	public Elemento Porid(Elemento e) {

		for (Elemento elemen : el) {
			if (elemen.getId_elemento() == (e.getId_elemento())) {
				System.out.println("Nombre: " + elemen.getNombre_elemento() + "\nCantidad Elemento: "
						+ elemen.getCantidad_elemento() + "\nId Elemento " + elemen.getId_elemento());
				return e;
			}
		}
		return null;

	}

	public void PorNombre(String n) {
		de.ConsultaNombreElementos(n);

	}

	public void SelectTodosBD(ArrayList<Elemento> e) {
		de.ConsultaTodosTiposElementos();
	}

	public void consulta() {
		for (Elemento elemen : el) {
			System.out.println("Nombre: " + elemen.getNombre_elemento() + "\n" + "cant: "
					+ elemen.getCantidad_elemento() + "\n" + "ID: " + elemen.getId_elemento());
		}
	}

	public void Alta(Elemento e) {

		de.AltaElementos(e);
	}

	public void Baja(Elemento s) {

		de.BajaElementos(s);

	}
	public ResultSet AgregarTipos(){
		
		return de.ConsultaTodosTipos();
	}
	public void AgregarElemento(Elemento e, Object tipoEl) {
		
		de.agregarElementoReserva(e,tipoEl);
		
	}

	public void Modifica(Elemento e) {
		DatosElementos de = new DatosElementos();
		de.ModificarTipoElementos(e);

	}

	public void AltaPersona(Persona p) {
		du= new DatosUsuarios();
		du.AltaUsuario(p);

	}
	public void Habilitado(){
		
	}

	public void ModificaPersona(Persona p) {
		for (Persona per : pe) {
			if (per.getIdUsuario()==(p.getIdUsuario())) {
				pe.remove(per);
				break;
			}
		}
		Persona pers = new Persona();
		System.out.println("Ingrese el nuevo nombre");
		pers.setNombre(w.nextLine());
		System.out.println("Ingrese el nuevo apellido\n");
		pers.setApellido(w.nextLine());
		System.out.println("Ingrese el nuevo dni\n");
		pers.setDNI(w.nextLine());
		pers.setIdUsuario(p.getIdUsuario());
		this.pe.add(pers);

	}

	public void BajaPersonas(Persona p) {		
		du.BajaUsuario(p);
		
	}

	public Persona PersonaPorDni(Persona p) {
		for (Persona per : pe) {
			if (per.getDNI().equals(p.getDNI())) {
				System.out.println("Id: " + per.getIdUsuario() + "\nNombre: " + per.getNombre() + "\nApellido: " + per.getApellido() + "\nDni: "
						+ per.getDNI() );
				return per;					
			} 
		}
		return null;

		
	}

	public void consultaPersona() {
		for (Persona p : pe) {
			System.out.println("Id :" + p.getIdUsuario()+ "\n" +  "Nombre: " + p.getNombre() + "\n" + "Apellido: " + p.getApellido() + "\n" + "DNI: "
					+ p.getDNI() );

		}

		
	}

	public void personaId(int n) {
		for (Persona per : pe) {
			if (per.getIdUsuario() == n) {

					System.out.println("\nId: " + per.getIdUsuario() + "\nNombre: " + per.getNombre() + "\nApellido: " + per.getApellido() + "\nDni: "
							+ per.getDNI() );
					break;
			}

		}
	}

	public ResultSet ConsultaIDElementos(int id) {
		
		return de.ConsultaIDElementos(id);
	
	}

	public ResultSet ConsultaNombreElementos(String nombre) {
		return de.ConsultaNombreElementos(nombre);
		
	}

	public ResultSet ConsultaTodos() {
		return de.ConsultaTodosTiposElementos();
	
	}

	public ResultSet ConsultarEstado(int iD) {
		System.out.println("controlador");
		ResultSet rs= du.ConsultarEstado(iD);
		return rs;
	}

	public void InhabilitarUsuario(Persona p) {
		du.InhabilitarUsuario(p);
		
	}

	public void HabilitarUsuario(Persona p) {
		du.HabilitarUsuario(p);
		
	}

	public ResultSet login(String usua, String contraseña) {
		Login log = new Login();
		return log.login(usua, contraseña);
		
		
	}

	public ResultSet ConsultarTiposElementos() {
		return de.ConsultaTodosTipos();	
		
	}





}
