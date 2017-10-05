package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Controlador.Controlador;
import Entidades.Elemento;
import Interface.InterfaceConsultarTodosElementos;

public class DatosElementos {

	public ResultSet ConsultaTodos() {
		ResultSet rs = null;

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from tiposelementos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet SeleccionarTiposElementos(Object el){
		ResultSet rs=null;
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * "
					+ " from elementos where TipoElemento=?");
			stmt.setObject(1, el);
			rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
	public ResultSet ConsultaTodosTipos() {
		ResultSet rs = null;
		
		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select DISTINCT NombreElemento from tiposelementos ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ConsultaTodosNombresTipo(Object Nombre) {
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;				

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select DISTINCT NombreElementoReserva from tiposelementos el inner join elementos er on el.NombreElemento=er.TipoElemento where NombreElemento=?");
			stmt.setObject(1, Nombre);;
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet ConsultaID(int id) {
		return ConsultaIDElementos(id);
	}
	public void agregarElementoReserva(Elemento e, Object ob)	
	{	ResultSet rs= null;
		java.sql.PreparedStatement stmt = null;
		try {			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into elementos (NombreElementoReserva,TipoElemento) VALUES (?,?)");
			stmt.setString(1, e.getNombre_elemento());
			stmt.setObject(2, ob);					
			 stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null, "Elemento Reserva Agregado");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
 
		
		
	}

	public ResultSet ConsultaIDElementos(int id) {
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idElementos, NombreElemento,CantidadElementos from tiposelementos where idElementos= ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet ConsultaNombreElementos(String Nombre) {
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idElementos, NombreElemento,CantidadElementos from tiposelementos where NombreElemento= ?");
			stmt.setString(1, Nombre);
			rs = stmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	public void AltaElementos(Elemento e) {

		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tiposelementos(NombreElemento,CantidadElementos) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, e.getNombre_elemento());
			stmt.setInt(2, e.getCantidad_elemento());
			int resp = stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				e.setId_elemento(rs.getInt(1));
			}

		} catch (SQLException s) {

			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Elemento Agregado");
		try {
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void BajaElementos(Elemento e) {
		java.sql.PreparedStatement stmt = null;		

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("DELETE tiposelementos,elementos  FROM tiposelementos,elementos where NombreElemento=TipoElemento and NombreElemento=? ");
			stmt.setInt(1, e.getId_elemento());			
			
			stmt.executeUpdate();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Elemento Eliminado");
		try {
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

	}

	public ResultSet Modificar(Elemento e) {
		java.sql.PreparedStatement stmt =null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE tiposelementos SET NombreElemento=?,CantidadElementos=? WHERE idElementos=?");
			stmt.setInt(3, e.getId_elemento());
			stmt.setString(1,e.getNombre_elemento());
			stmt.setInt(2, e.getCantidad_elemento());
			stmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;

	}
	public void  BajaTipoElemento(int idelemento) {
		java.sql.PreparedStatement stmt =null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("delete from elementos where IDElementosReserva=?");
			stmt.setInt(1, idelemento);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
