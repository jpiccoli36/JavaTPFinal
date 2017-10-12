package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosElementos;
import Datos.DatosUsuarios;
import Datos.Login;
import Entidades.Elemento;
import Entidades.Persona;

public class ControladorUsuario {
	private DatosUsuarios du;

	Scanner w = new Scanner(System.in);
	private ArrayList<Elemento> el = new ArrayList<Elemento>();
	private ArrayList<Persona> pe = new ArrayList<Persona>();

	public ControladorUsuario() {
		pe.add(new Persona("jose", "piccoli", "123123", 1));
		pe.add(new Persona("analia", "salazar", "123321", 2));

	}

	public ArrayList<Persona> ConsultaTodosUsuarios() {
		return du.ConsultaTodosUsuarios();
	}

	public void Modifica(Elemento e) {
		DatosElementos de = new DatosElementos();
		de.ModificarTipoElementos(e);

	}

	public void AltaPersona(Persona p) {
		du = new DatosUsuarios();
		du.AltaUsuario(p);

	}

	public void BajaPersonas(Persona p) {
		du.BajaUsuario(p);

	}

	public Persona ConsultarEstado(int iD) {

		return du.ConsultarEstado(iD);

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

}
