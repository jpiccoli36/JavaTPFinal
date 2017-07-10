package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Controlador.ControladorElementos;

import Elementos.Elemento;
import Interface.InterfaceConsultarTodosElementos;


public class DatosElementos {
	
	public  ResultSet ConsultaTodos(){
		ResultSet rs = null;
		
		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();
			
			rs= stmt.executeQuery("select * from elementos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ConsultaID(int id){
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		
		try {
			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select idElementos, NombreElemento,CantidadElementos from elementos where idElementos= ?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return rs;
	}
	public ResultSet ConsultaNombre(String Nombre){
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		
		try {
			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select idElementos, NombreElemento,CantidadElementos from elementos where NombreElemento= ?");
			stmt.setString(1,Nombre);
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return rs;
	}

}
