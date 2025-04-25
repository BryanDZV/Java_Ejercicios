package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Entrada;

public class PruebaMySQL {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró el driver");
		}

		/* cn =DriverManager.getConnection("jdbc:mysql://172.16.55.55/programacion","daw1", "halloween");*/
		System.out.println("INDTRODUCE DATOS DE CONEXION");

			System.out.println("ip");
			int ip=Entrada.entero();
			System.out.println("base de datos");
			String bd=Entrada.cadena();
			System.out.println("user");
			String user=Entrada.cadena();
			System.out.println("pass");
			int pass=Entrada.entero();
			
			
		
		Connection cn = conectarMySQL(ip,bd,user,pass);
		System.out.println("CONECTADO A MYSQL CORRECTAMENTE");
		try {
			/*REALIZAR CONSULTAR*/
			Statement st=cn.createStatement();
			String sql="insert into notas values(1111,'pepito',8)";
			st.executeUpdate(sql);
			/*todo lo que no sea select usar executeUpdate*/
			System.out.println("fila insertada");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static Connection conectarMySQL(int ip, String bd, String user, int pass) throws SQLException {
		Connection cn=DriverManager.getConnection("jdbc:mysql://172.16.55.55/programacion","daw1", "halloween");
		return cn;
	}


}
