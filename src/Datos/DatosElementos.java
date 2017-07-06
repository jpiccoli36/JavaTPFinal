package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Controlador.ControladorElementos;

import Elementos.Elemento;


public class DatosElementos {
	
	public ArrayList<Elemento> consulta() {
		ControladorElementos control = new ControladorElementos();
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		
			try {
				Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();
				
				ResultSet rs= stmt.executeQuery("select * from elementos");
				if(rs!=null ){
					while(rs.next()){
						Elemento e = new Elemento();
						e.setNombre_elemento(rs.getString("NombreElemento"));
						e.setId_elemento(rs.getInt("idElementos"));
						e.setCantidad_elemento(rs.getInt("CantidadElementos"));
						el.add(e);
						
						
					}
					control.SelectTodosBD(el);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return el;
		
	}

}
