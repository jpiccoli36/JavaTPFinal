package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Elemento;
import Entidades.Reservas;

public class DatosElementos {

	public ArrayList<Elemento> ConsultaTodosTiposElementos() {
		ResultSet rs = null;
		ArrayList<Elemento> el = new ArrayList<Elemento>();

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from tiposelementos");
			if (rs != null) {
				while (rs.next()) {
					Elemento e = new Elemento();
					e.setId_elemento(rs.getInt("idElementos"));
					e.setCantidad_elemento(rs.getInt("CantidadElementos"));
					e.setNombre_elemento(rs.getString("NombreElemento"));
					
					el.add(e);

				}
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return el;
	}

	public ArrayList<Elemento> ConsultaTodosElementos(Object TipoEl) {
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from elementos" + " where TipoElemento=?");
			stmt.setObject(1, TipoEl);
			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Elemento e = new Elemento();
					e.setIdElementosReserva(rs.getInt("IDElementosReserva"));
					e.setTipoElementoReserva(rs.getString("TipoElemento"));
					e.setNombreElementoReserva(rs.getString("NombreElementoReserva"));
					el.add(e);
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return el;
	}

	public ArrayList<Elemento> SeleccionarTiposElementos(Object ele) {
		ResultSet rs = null;
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * " + " from elementos where TipoElemento=?");
			stmt.setObject(1, ele);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Elemento e = new Elemento();
				e.setIdElementosReserva(rs.getInt("IDElementosReserva"));
				e.setTipoElementoReserva(rs.getString("TipoElemento"));
				e.setNombreElementoReserva(rs.getString("NombreElementoReserva"));
				el.add(e);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return el;

	}

	public ArrayList<Elemento> ConsultaTodosTipos() {
		ResultSet rs = null;
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select DISTINCT NombreElemento from tiposelementos ");
			while (rs.next()) {
				Elemento e = new Elemento();

				e.setNombre_elemento(rs.getString("NombreElemento"));
				el.add(e);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return el;
	}

	public void agregarElementoReserva(Elemento e, Object ob) {

		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("insert into elementos (NombreElementoReserva,TipoElemento) VALUES (?,?)");
			stmt.setString(1, e.getNombre_elemento());
			stmt.setObject(2, ob);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Elemento Reserva Agregado");
			
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

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
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				e.setId_elemento(rs.getInt(1));
			}
			rs.close();
			stmt.close();
		} catch (SQLException s) {

			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Elemento Agregado");
		try {
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public void BajaElementos(Elemento e) {
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("delete from tiposelementos where idElementos=? ");
			stmt.setInt(1, e.getId_elemento());

			stmt.executeUpdate();
			
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Elemento Eliminado");
		try {
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public void ModificarTipoElementos(Elemento ele) {

		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE tiposelementos SET NombreElemento=?,CantidadElementos=? WHERE idElementos=?");
			stmt.setInt(3, ele.getId_elemento());
			stmt.setString(1, ele.getNombre_elemento());
			stmt.setInt(2, ele.getCantidad_elemento());
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public void ModificarElemento(int id, String Nombre, String tipo) {
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update elementos set NombreElementoReserva=?,TipoElemento=?" + " where IDElementosReserva=?");
			stmt.setString(1, Nombre);
			stmt.setString(2, tipo);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void BajaTipoElemento(int idelemento) {
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("delete from elementos where IDElementosReserva=?");
			stmt.setInt(1, idelemento);
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public Elemento CantidadMaxReservas(String Tipo){
		Elemento e = new Elemento();
		ResultSet rs=null;
		java.sql.PreparedStatement stmt = null;	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select CantidadElementos "
					+ "from tiposelementos where NombreElemento=?");
			stmt.setString(1, Tipo);
			stmt.executeQuery();
			rs=stmt.executeQuery();
			rs.next();
			e.setCantidad_elemento(rs.getInt("CantidadElementos"));
			rs.close();
			stmt.close();
		} catch (SQLException w) {
			
			w.printStackTrace();
		}
		
		return e;
}
	}
