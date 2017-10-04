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
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * "
					+ "from elementos el "
					+ "where TipoElemento=? and NombreElementoReserva not in ( select elemento "
					+ "from reservas r "
					+ "where ? between fhinicio and fhfin or"
					+ "? between fhinicio and fhfin or "
					+ "fhinicio <= ? and fhfin >= ? or "
					+ "fhinicio<= ? and fhfin >= ? or "
					+ "fhinicio<=? and fhfin >= ? or "
					+ "fhinicio<=? and fhfin >= ?)");
			stmt.setObject(1, tipoEl);
			stmt.setTimestamp(2, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(6, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(7, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(8, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(9, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(10, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(11, new java.sql.Timestamp(fechaHoraIni.getTime()));
			
			
		rs= stmt.executeQuery();
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}

}
