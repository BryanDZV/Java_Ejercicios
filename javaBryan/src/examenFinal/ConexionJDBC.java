package examenFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionJDBC {

	public static void main(String[] args) {
		
		//datos
		Connection cn=null;
		Statement st=null;
		
		try {
			//BLOQUE 1: Cargar el Driver JDBC

		    Class.forName("com.mysql.cj.jdbc.Driver");
		  //BLOQUE 2: Establecer conexión con MySQL
			
			 cn = DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/cuentas", // URL del servidor + base de datos
				    "root",                                // usuario MySQL
				    ""                                     // contraseña (vacía en XAMPP)
				);
			
			//BLOQUE 3: Crear una tabla en MySQL desde Java
			
			
			 st = cn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS cuentas ("
			           + "codigo VARCHAR(10) PRIMARY KEY, "
			           + "propietario VARCHAR(100), "
			           + "email VARCHAR(100), "
			           + "saldo DOUBLE)";

			st.executeUpdate(sql);
			
			System.out.println("tabla creada correctamente");

		} catch (ClassNotFoundException e) {

		    System.out.println("No se encontro el Driver MySQL para JDBC.");

		} catch (SQLException e) {
			System.out.println("error al conectar o crear la tabla");
			e.getMessage();
		}finally {
			if (st!=null || cn!=null) {
				try {
					cn.close();
					st.close();
				} catch (SQLException e) {
					System.out.println("error al cerrar la conexion");
					e.getMessage();
				}
				
			}
		}
		
		
		
		

	

		


	}//main

}//class
