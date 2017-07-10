package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	public ResultSet login(String Nombre,String contraseña){
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		
		
		try {
			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select nombre, apellido,dni,categoria from usuarios where usuario= ? and contraseña=?");
			stmt.setString(1,Nombre);
			stmt.setString(2, contraseña);
			
			rs=stmt.executeQuery();
			
			if((rs.next())){
				
				return rs;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		return null;
	}

}
