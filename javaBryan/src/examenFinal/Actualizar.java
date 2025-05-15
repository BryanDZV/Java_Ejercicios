package examenFinal;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilidades.Entrada;

public class Actualizar {

	public static void main(String[] args) {
		//datos
		String usuario="root";
		String contraseña="";
		String url="jdbc:mysql://localhost:3306/cuentas";
		
		//recursos
		Connection cn=null;
		PreparedStatement pst=null;
		
		//datos a modificar
		String codigo="c005";
		double cantidad=-50.0;
		
		
		try {
			//1cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2conexion
			try {
				cn=DriverManager.getConnection(url, usuario, contraseña);
				System.out.println("conexion exitosa");
			} catch (SQLException e) {
				System.out.println("ERROR AL CONECTARSE A LA ABSE DE DATOS");
			}
			//3preparo y relleno mi consulta
			String sql="update cuentas set saldo=saldo+? where codigo=?";
			pst=cn.prepareStatement(sql);
			
			pst.setDouble(1,cantidad);
			pst.setString(2, codigo);
			//4ejeucto mi consulta
			int filarAfectadas=pst.executeUpdate();
			System.out.println("Actualizacion Correcta");
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar el DRIVER");
		} catch (SQLException e) {
			System.out.println("error en las CONSULTAS");
		}finally {
			try {
				if (cn!=null) {
					cn.close();
				}
				if (pst!=null) {
					pst.close();
				}
			} catch (SQLException e2) {
				System.out.println("error al cerrar RECURSOS"+"   "+e2.getMessage());
			}
		}
		

	}

}
