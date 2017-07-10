package Controlador;

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

	public ArrayList<Elemento> PorNombre(String n) {

		for (Elemento elemen : el) {
			if (elemen.getNombre_elemento().equals(n)) {

				System.out.println("Nombre: " + elemen.getNombre_elemento() + "\nCantidad Elemento: "
						+ elemen.getCantidad_elemento() + "\nId Elemento " + elemen.getId_elemento());
				break;

			}
		}

		return el;

	}

	public void SelectTodosBD(ArrayList<Elemento> e) {
		for (Elemento el : e) {
			System.out.println("Nombre: " + el.getNombre_elemento() + "\n" + "cant: " + el.getCantidad_elemento() + "\n" + "ID: "
					+ el.getId_elemento() );
	
	}
		}
	public void consulta() {
		for (Elemento elemen : el) {
			System.out.println("Nombre: " + elemen.getNombre_elemento() + "\n" + "cant: " + elemen.getCantidad_elemento() + "\n" + "ID: "
					+ elemen.getId_elemento() );
		}
		}

	public void Alta(Elemento e) {

		el.add(e);
	}

	public void Baja(int id) {

		for (Elemento elem : el) {
			if (elem.getId_elemento() == id) {
				el.remove(elem);
				break;
			}
		}

	}

	public void Modifica(Elemento e) {
		this.Baja(e.getId_elemento());
		this.Alta(e);

	}

}
