package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class DatosReserva {
	
	
	public ResultSet ConsultaElementosDisponibles(Time hora, Date fechaHora, Object tipoEl) {
		ResultSet rs = null;

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from usuarios");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}

}
