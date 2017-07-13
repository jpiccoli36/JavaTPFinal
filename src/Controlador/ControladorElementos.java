package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosElementos;
import Elementos.Elemento;

public class ControladorElementos {
	private DatosElementos de;

	Scanner w = new Scanner(System.in);
	private ArrayList<Elemento> el = new ArrayList<Elemento>();

	public ControladorElementos() {
		de = new DatosElementos();
		
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
 de.ConsultaTodos();
	}
		
	public void consulta() {
		for (Elemento elemen : el) {
			System.out.println("Nombre: " + elemen.getNombre_elemento() + "\n" + "cant: " + elemen.getCantidad_elemento() + "\n" + "ID: "
					+ elemen.getId_elemento() );
		}
		}

	public void Alta(Elemento e) {

		de.AltaElementos(e);
	}

	public void Baja(Elemento s) {

		 de.BajaElementos(s);

	}

	public void Modifica(Elemento e) {
		DatosElementos de = new DatosElementos();
		de.Modificar(e);

	}

}
