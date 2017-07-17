package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosElementos;
import Datos.DatosUsuarios;
import Entidades.Elemento;
import Entidades.Persona;

public class Controlador {
	private DatosElementos de;
	private DatosUsuarios da;

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
		de.ConsultaTodos();
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

	public void Modifica(Elemento e) {
		DatosElementos de = new DatosElementos();
		de.Modificar(e);

	}

	public void AltaPersona(Persona p) {
		da= new DatosUsuarios();
		da.AltaUsuario(p);

	}

	public void ModificaPersona(Persona p) {
		for (Persona per : pe) {
			if (per.getId()==(p.getId())) {
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
		pers.setId(p.getId());
		this.pe.add(pers);

	}

	public void BajaPersonas(int id) {
		for (Persona per : pe) {
			if (per.getId()==(id)) {
				pe.remove(per);
				break;
			}
		}
		
	}

	public Persona PersonaPorDni(Persona p) {
		for (Persona per : pe) {
			if (per.getDNI().equals(p.getDNI())) {
				System.out.println("Id: " + per.getId() + "\nNombre: " + per.getNombre() + "\nApellido: " + per.getApellido() + "\nDni: "
						+ per.getDNI() );
				return per;					
			} 
		}
		return null;

		
	}

	public void consultaPersona() {
		for (Persona p : pe) {
			System.out.println("Id :" + p.getId()+ "\n" +  "Nombre: " + p.getNombre() + "\n" + "Apellido: " + p.getApellido() + "\n" + "DNI: "
					+ p.getDNI() );

		}

		
	}

	public void personaId(int n) {
		for (Persona per : pe) {
			if (per.getId() == n) {

					System.out.println("\nId: " + per.getId() + "\nNombre: " + per.getNombre() + "\nApellido: " + per.getApellido() + "\nDni: "
							+ per.getDNI() );
					break;
			}

		}
	}
		

}
