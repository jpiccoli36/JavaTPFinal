package ABMCTipos;

import java.util.Scanner;

import Controlador.ControladorElementos;
import Datos.DatosElementos;
import Elementos.Elemento;

public class ABMCTipos {
	Scanner s = new Scanner(System.in);
	ControladorElementos ctr;

	public void start() {
		
		ctr = new ControladorElementos();

		String rta = "s";

		while (rta.equals("s")) {

			System.out.println("\n\n################\n\n");
			System.out.println("¿Que accion desea realizar?");
			System.out.println("A- Alta Elemento");
			System.out.println("B-Baja Elemento");
			System.out.println("M-Modificar un Elemento");
			System.out.println("C- Consultar Elemento");
			System.out.println("S- salir");
			rta = s.nextLine();
			Elemento e = new Elemento();
			switch (rta.toLowerCase()) {
			case "a":
				alta(e);
				System.out.println("hacer otra accion Si(s)-No(n)?"); // listo
				rta = s.nextLine();
				break;
			case "b":
				System.out.println("Ingrese el Id del Elemento");
				int id = Integer.parseInt(s.nextLine());
				ctr.Baja(id);
				System.out.println("hacer otra accion Si(s)-No(n)?"); // listo
				rta = s.nextLine();
				break;
			case "m":
				modifica(e);
				System.out.println("hacer otra accion Si(s)-No(n)?"); // listo
				rta = s.nextLine();
				break;
			case "c":
				consulta();
				System.out.println("hacer otra accion Si(s)-No(n)?"); // listo
				rta = s.nextLine();
				break;
			default:
				rta = "n";
				break;

			}
		}
	}

	private void consulta() {
		DatosElementos de = new DatosElementos();
		int r;
		Elemento e = new Elemento();
		System.out.println("1-todos");
		System.out.println("2-por nombre");
		System.out.println("3-por id");
		r = Integer.parseInt(s.nextLine());
		switch (r) {
		case 1:
			de.consulta();

			break;
		case 2:
			System.out.println("ingres Nombre Elemento");
			String n = s.nextLine();
			ctr.PorNombre(n);
			break;
		case 3:
			System.out.println("ingrese el id del Elemento");
			e.setId_elemento(Integer.parseInt(s.nextLine()));
			ctr.Porid(e);

		}

	}

	private void modifica(Elemento e) {

		System.out.println("ingrese el Id Elemento a  modificar");
		e.setId_elemento(Integer.parseInt((s.nextLine())));
		ctr.Modifica(e);

	}

	private void alta(Elemento e) {

		System.out.println("ingrese el nombre");
		e.setNombre_elemento(s.nextLine());
		System.out.println("ingrese el ID Elemento");
		e.setId_elemento(Integer.parseInt(s.nextLine()));
		System.out.println("ingrese la Cantidad");
		e.setCantidad_elemento(Integer.parseInt(s.nextLine()));

		ctr.Alta(e);

	}
	
}
