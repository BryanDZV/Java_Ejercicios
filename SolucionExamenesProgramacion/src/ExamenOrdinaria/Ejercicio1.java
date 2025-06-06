package ExamenOrdinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		// 1) Leer configuración desde CFG.INI
		BufferedReader bfr = new BufferedReader(new FileReader("CFG.INI"));
		String ip = bfr.readLine();
		String pass = bfr.readLine();
		String bd = bfr.readLine();
		String user = bfr.readLine();
		bfr.close();

		// 2) Construir la URL JDBC
		String url = "jdbc:mysql://" + ip + "/" + bd;
		System.out.println("URL de conexión: " + url);

		// 3) Cargar el driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 4) Obtener la conexión
		Connection cn = DriverManager.getConnection(url, user, pass);
		System.out.println("¡Conexión OK!");

		// leer DATOS para tabla
		bfr = new BufferedReader(new FileReader("DATOS"));
		String nombretabla = bfr.readLine();
		String desde = bfr.readLine();
		int desdeN=Integer.parseInt(desde);
		String hasta = bfr.readLine();
		int hastaN=Integer.parseInt(hasta);
		String nombrefichero = bfr.readLine();

		bfr.close();

		// crear tabla
		String sql = "create table if not exists " + nombretabla + " (aleatorio int primary key)";
		Statement st = cn.createStatement();
		st.executeUpdate(sql);
		System.out.println("tabla OK");
		// borrar filas
		sql = "select * from " + nombretabla;
		st = cn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			// borrar datos que haya
			sql = "delete from " + nombretabla;
			st.executeUpdate(sql);
			System.out.println("borrado OK");
		}
		
		//crear aleatorios
		Set<Integer>setAleatorios=new HashSet<Integer>();
		setAleatorios=aleatorios(desdeN,hastaN);
//		for (Integer n : setAleatorios) {
//			System.out.println(n);
//		}
		
		//insertar en tabla
		for (Integer n : setAleatorios) {
			sql="insert into "+nombretabla+" values(?)";
			PreparedStatement pst=cn.prepareStatement(sql);
			pst.setInt(1, n);
			pst.executeUpdate();
			
		}
		System.out.println("insertado ok");
		
		//crear un fichero con aleatorios
		
		PrintWriter pw =new PrintWriter(new FileWriter(nombrefichero),true);
		List<Integer>listaAleatorios=new ArrayList<Integer>(setAleatorios);
		listaAleatorios.sort(new OrdenDesc());
//		System.out.println("LISTA DESC");
//		for (Integer n : listaAleatorios) {
//			System.out.println(n);
//		}
		
		for (Integer n : listaAleatorios) {
			pw.println(n);
		}
		System.out.println("fichero OK");
		pw.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// 5) Cerrar conexión antes de salir
		cn.close();
		st.close();
		
	}

	private static Set<Integer> aleatorios(int desdeN, int hastaN) {
		Random rd=new Random();
		Set<Integer>setAleatorios=new HashSet<Integer>();
		while (setAleatorios.size()<50) {
			int numero=rd.nextInt(desdeN, hastaN);
			setAleatorios.add(numero);
		}
		
		
		return setAleatorios;
	}
}
