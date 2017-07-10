package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
		return ConsultaIDElementos(id);
	}
	public ResultSet ConsultaIDElementos(int id){
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
	public ResultSet ConsultaNombreElementos(String Nombre){
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
	
	public void AltaElementos(Elemento e){
		
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		
		try {
			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("insert into elementos(NombreElemento,CantidadElementos) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1,e.getNombre_elemento());
			stmt.setInt(2, e.getCantidad_elemento());			
			int resp =stmt.executeUpdate();
			
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				e.setId_elemento(rs.getInt(1));
			}		
			
		} catch (SQLException s) {
			
			s.printStackTrace();
		}		
		
		
	

}
	}
