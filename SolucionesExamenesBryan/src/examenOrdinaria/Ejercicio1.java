package examenOrdinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio1 {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = null;
		// leer datos
		BufferedReader bfr = new BufferedReader(new FileReader("CFG.INI"));
		String ip = bfr.readLine();
		String pass = bfr.readLine();
		String bd = bfr.readLine();
		String user = bfr.readLine();
		String url = "jdbc:mysql://" + ip + "/" + bd;
		cn = DriverManager.getConnection(url, user, pass);
		System.out.println("conexion OK");
		// crear tabla
		crearTabla(cn);
		// borrar datos de tabla
		borraDatos(cn);
		// crear aleatorios
		Set<Integer> setAleatorios = new TreeSet<Integer>();
		setAleatorios = crearAleatorios();
	
		// insertar aleatorios en tabla
		insertar(cn, setAleatorios);
		
		//crear Fichero
		
		crearFichero(setAleatorios);

		// cerrar recursos
		cn.close();
	}

	private static void crearFichero(Set<Integer> setAleatorios) throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter("fichero.txt"),true);
		for (Integer n : setAleatorios) {
			pw.println(n);
				
		}
	pw.close();
		System.out.println("fichero creado OK");
	}

	private static void insertar(Connection cn, Set<Integer> setAleatorios) throws SQLException {

		for (Integer n : setAleatorios) {
			String sql = "insert into bryanordinaria (aleatorio) values(?)";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setInt(1, n);
			pst.executeUpdate();
			pst.close();
		}

		System.out.println("insertados OK");

	}

	private static Set<Integer> crearAleatorios() {
		Set<Integer> setAleatorios = new TreeSet<Integer>();
		Random rd = new Random();
		while (setAleatorios.size() < 50) {
			int aleatorio = rd.nextInt(1000, 2000);
			setAleatorios.add(aleatorio);
		}
		System.out.println("aleatorios OK");
		return setAleatorios;
	}

	private static void borraDatos(Connection cn) throws SQLException {
		String sql = "select * from bryanOrdinaria";
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			sql = "delete from bryanOrdinaria";
			st = cn.createStatement();
			st.executeUpdate(sql);
			System.out.println("datos borrados OK");
			st.close();
			rs.close();
		}

	}

	private static void crearTabla(Connection cn) throws SQLException {
		String sql = "create table if not exists bryanOrdinaria(aleatorio int primary key)";
		Statement st = cn.createStatement();
		st.executeUpdate(sql);
		System.out.println("tabla ok");
		st.close();
	}

}
