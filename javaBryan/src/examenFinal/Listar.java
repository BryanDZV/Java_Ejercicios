package examenFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Listar {

	public static void main(String[] args) {
		//datos
		String usuario="root";
		String url="jdbc:mysql://localhost:3306/cuentas";
		String contraseña="";
		
		Connection cn=null;
		PreparedStatement pstLista=null;
		try {
			
			//cargar driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//1conexion
			cn=DriverManager.getConnection(url,usuario, contraseña);
			//2 cosultas
			String sql="SELECT * FROM cuentas";
			pstLista=cn.prepareStatement(sql);
			
			ResultSet rs=pstLista.executeQuery();
			
			//3leer datos
			String fila="";
			while (rs.next()) {
				String codigo=rs.getString("codigo");
				String propietario=rs.getString("propietario");
				String email=rs.getString("propietario");
				Double saldo=rs.getDouble("saldo");
				System.out.println(codigo + " | " + propietario + " | " + email + " | " + saldo);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("porblemas con cargar el driver");
		} catch (SQLException e) {
			System.out.println("consulta erronea");
			e.printStackTrace();
		}finally {
			try {
				if (cn!=null) {
					cn.close();
				}
				if (pstLista!=null) {
					pstLista.close();
				}
				
			} catch (SQLException e2) {
System.out.println("error al cerrar recurso"+ e2.getMessage());			}
		}

	}

}
