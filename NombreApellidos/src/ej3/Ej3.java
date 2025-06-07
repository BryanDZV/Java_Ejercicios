package ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Entrada;

public class Ej3 {
	static Connection cn = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		BufferedReader bfr = new BufferedReader(new FileReader(new File("CFG.INI")));
		String ip = bfr.readLine();
		String bd = bfr.readLine();
		String usuario = bfr.readLine();
		String password = bfr.readLine();
		bfr.close();
		System.out.println();
		cn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd, usuario, password);

		String opcion;
		do {
			mostrarMenu();
			opcion = Entrada.cadena().trim();
			switch (opcion) {
			case "1":
				crearCargarTabla();
				break;
			case "2":
				listadoOrdenado();
				break;
			case "3":
				guardarFichero();
				break;
			case "0":
				break;

			}
			System.out.println();
		} while (!opcion.equals("0"));

		System.out.println("PROGRAMA FINALIZADO.");

	}

	private static void guardarFichero() {
		// TODO Auto-generated method stub

	}

	private static void listadoOrdenado() {
		// TODO Auto-generated method stub

	}

	private static void crearCargarTabla() throws SQLException, IOException {
		Statement st = cn.createStatement();
		String sql = null;
		sql = "CREATE TABLE IF NOT EXISTS profesor (codigo INTEGER PRIMARY KEY,poblacion VARCHAR(255))";
		st.executeUpdate(sql);

		BufferedReader bfr = new BufferedReader(new FileReader("datos.csv"));
		bfr.readLine(); // Salta cabecera
		String linea;
		int cnt = 0;
		while ((linea = bfr.readLine()) != null) {
			cnt++;
			String[] pob = linea.split(";");
			String accion = pob[0];
			String codigo = pob[1];
			String poblacion = pob[2];
			sql = "SELECT * FROM profesor WHERE codigo=" + codigo;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) { // Ya existe en la tabla el codigo
				switch (accion) {
				case "A":
					sql = "UPDATE profesor SET poblacion='" + poblacion + "' WHERE codigo=" + codigo;
					System.out.println(sql);
					st.executeUpdate(sql);
					break;
				case "B":
					sql = "DELETE FROM profesor WHERE codigo=" + codigo;
					System.out.println(sql);
					st.executeUpdate(sql);
					break;
				}

			} else { // No existe
				if (accion.equals("A")) {
					sql = "INSERT INTO profesor VALUES (" + codigo + ",'" + poblacion + "')";
					System.out.println(sql);
					st.executeUpdate(sql);
				}
			}
		}
		bfr.close();
		st.close();
		System.out.println("Procesadas " + cnt + " líneas del archivo datos.csv.");

	}

	private static void mostrarMenu() {
		System.out.println("=== Poblaciones ===");
		System.out.println("1-Crear tabla y cargar datos desde datos.csv");
		System.out.println("2-Listado ordenado por población y código");
		System.out.println("3-Guardar en fichero");
		System.out.println("0-Salir");
	}

	private static boolean existeTabla(Connection con, String base, String tabla) throws SQLException {
		DatabaseMetaData meta = con.getMetaData();
		ResultSet res = null;
		res = meta.getTables(base, null, "%", null);

		while (res.next()) {
			if (res.getString("TABLE_TYPE").equals("TABLE")) {
				if (res.getString("TABLE_NAME").toLowerCase().equals(tabla.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * CONEXION REMOTA mysql numeroIP -u daw1 -p halloween CONEXION LOCAL mysq -u
	 * daw -p halloween SELECT * FROM PROFESOR ORDER BY POBLACION,CODIGO DESC; SHELL
	 */

}