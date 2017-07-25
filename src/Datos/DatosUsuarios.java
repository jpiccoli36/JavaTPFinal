package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Persona;



public class DatosUsuarios {
	public void AltaUsuario(Persona p) {

		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into usuarios(NombreUsuario,ApellidoUsuario,DNI,Usuario,Contraseña,Categoria) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDNI());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContraseña());
			stmt.setString(6, p.getCategoria());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				p.setIdUsuario(rs.getInt(1));
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

	public void BajaUsuario(Persona p) {
		
		java.sql.PreparedStatement stmt = null;
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("DELETE FROM usuarios where idUsuarios=?");
			stmt.setInt(1, p.getIdUsuario());
			stmt.executeUpdate();

		} catch (SQLException s) {

			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Usuario Eliminado");
		try {
			stmt.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}

	public ResultSet ConsultaTodosUsuarios() {
		ResultSet rs = null;

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from usuarios");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	
	}

}
