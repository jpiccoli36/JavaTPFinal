package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;

import Datos.DatosElementos;
import Entidades.Elemento;


public class ControladorElementos {
	DatosElementos de= new DatosElementos();
	
	public ArrayList<Elemento> ConsultaTodosTiposElementos() {
		return de.ConsultaTodosTiposElementos();	
		
	}
	public ArrayList<Elemento> ConsultaTodosElementos(Object TipoEl){
		return de.ConsultaTodosElementos(TipoEl);
		
	}
	public ArrayList<Elemento >SeleccionarTiposElementos(Object TipoEl)
	{
		return de.SeleccionarTiposElementos(TipoEl);
		
	}
public  ArrayList<Elemento > AgregarTipos(){
		
		return de.ConsultaTodosTipos();
	}

}
