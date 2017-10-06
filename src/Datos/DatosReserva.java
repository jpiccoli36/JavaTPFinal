package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class DatosReserva {
	
	
	public ResultSet ConsultaElementosDisponibles(Date fechaHoraIni, Date fechaHoraFin, Object tipoEl) {
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;	

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from elementos el "
					+ "where TipoElemento=? and NombreElementoReserva not in ( select elemento "
					+ "from reservas r inner join elementos e on r.elemento=e.NombreElementoReserva"
					+ " where ? between fhinicio and fhfin or "
					+ "? between fhinicio and fhfin or "
					+ "fhinicio<=? and fhfin<= ? or "
					+ "fhinicio>=? and fhfin<= ? or "
					+ "fhinicio>=? and fhinicio<=?)");
			stmt.setObject(1, tipoEl);
			stmt.setTimestamp(2, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(6, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(7, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(8, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(9, new java.sql.Timestamp(fechaHoraFin.getTime()));	
			
			
		rs= stmt.executeQuery();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}
	public void CancelarReserva(int IDReserva){
		
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from reservas where idreserva=?");
			stmt.setInt(1, IDReserva);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public ResultSet ConsultaTodosReservasUsuario(String user){
		ResultSet rs=null;
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * "
					+ "from reservas"
					+ " where usuario=? and fhinicio>=curdate()");
			stmt.setString(1, user);
			rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet ConsultarTodasReservas(){
		ResultSet rs=null;
		
		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * "
					+ "from reservas "
					+ "where fhinicio>=curdate();");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		
	}
	public ResultSet CantidadMaxReservas(String Tipo){
		ResultSet rs=null;
		java.sql.PreparedStatement stmt = null;	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select CantidadElementos "
					+ "from tiposelementos where NombreElemento=?");
			stmt.setString(1, Tipo);
			stmt.executeQuery();
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet ContarReservas(String tipo, String usuario){
		ResultSet rs=null;
		java.sql.PreparedStatement stmt = null;	
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select count(*) Cantidad_Reservas"
					+ " from reservas "
					+ "where usuario=? and tipoelemento=? and fhfin>= curdate()");
			stmt.setString(1, usuario);
			stmt.setString(2, tipo);
			rs=stmt.executeQuery();
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public void ReservarElemento(String usuario,Date fechaHoraIni, Date fechaHoraFin, String elemento, String tipo,String detalle){
		java.sql.PreparedStatement stmt = null;
		ResultSet rs=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into reservas (usuario, fhinicio, fhfin, elemento, tipoelemento,detalle) "
					+ "values (?,?,?,?,?,?)");
			stmt.setString(1, usuario);
			stmt.setTimestamp(2, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setString(4, elemento);
			stmt.setString(5, tipo);
			stmt.setString(6, detalle);
			stmt.executeUpdate();				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
