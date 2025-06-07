package jdbc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Entrada;

public class TablaNotasACSV {

	public static void main(String[] args)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = conectarMySQL("172.16.55.55", "programacion", "daw1", "halloween");
			System.out.println("Conectado a MySQL.");

			PrintWriter pw = new PrintWriter(new FileWriter(new File("notas.csv")));
			pw.println("identificador;Nombre;Nota"); // Cabecera del csv

			Statement st = cn.createStatement();
			String sql = "select * from notas";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString(2);
				int nota = rs.getInt("nota");

				pw.println(id + ";" + nom + ";" + nota);

			}
			rs.close();
			pw.close();
			System.out.println("notas.csv creado.");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el conector JDBC para MySQL");
		}
		catch (SQLException e) {
			System.out.println("Error de base de datos");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en archivo de texto");
			System.out.println(e.getMessage());
		}
	}

	private static Connection conectarMySQL(String ip, String bd, String usu, String pass) throws SQLException {
		Connection cn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd, usu, pass);

		return cn;
	}

}
