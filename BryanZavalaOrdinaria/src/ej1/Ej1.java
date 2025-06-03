package ej1;

import java.beans.Statement;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ej1 {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// DriverManager.getConnection("jdbc:mysql://IP_serv/BD","usu","pass");

		Connection cn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		BufferedReader bfr = new BufferedReader(new FileReader("CFG.INI"));
		String ip = bfr.readLine();
		String pass = bfr.readLine();
		String bd = bfr.readLine();
		String user = bfr.readLine();
		cn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd, user, pass);
		System.out.println("conexion ok");

		// obetener fila

		String sql = "select * from alumno where nombreapellido like '%bryan%david%zavala%veletanga%'";
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		String nombreApellido = "";
		String nombretabla = "";
		while (rs.next()) {
			nombreApellido = rs.getString("nombreapellido");
			nombretabla = rs.getString("nombretabla");
			System.out.println(nombreApellido + "--" + nombretabla);
		}

		// tabla

		sql = "create table if not exists tablaR(aleatorio int primary key)";
		pst = cn.prepareStatement(sql);
		pst.executeUpdate();

		System.out.println("tabla ok");

		// guardar50 filas
		// aleatorios

		aleatorio(cn);

		Random rd = new Random();
		int aleatorio = 0;
		Set<Integer> s = new HashSet<Integer>();
		while (!(s.size() == 50)) {
			aleatorio = rd.nextInt(1701, 1800);
			s.add(aleatorio);
		}

		for (Integer integer : s) {
			System.out.println(integer);
		}

		System.out.println("tamaño de set---" + s.size());

		boolean salir = false;
		// int cnt=0;
		for (Integer integer : s) {
			while (!salir) {
				sql = "Insert into " + nombretabla + "(aleatorio)values(?)";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, integer);
				pst.executeUpdate();
//				if (cnt==51) {
//					salir=true;
//				}

			}
		}
		System.out.println("filas OK");

		// crear fichero

		PrintWriter pw = new PrintWriter(new FileWriter("ficheroR.txt"), true);
		// sql = "select * from tablaR";
		pst = cn.prepareStatement(sql);
		rs = pst.executeQuery();

		while (!rs.next()) {
			for (Integer integer : s) {
				pw.println(integer);

			}
		}

	}// main

	private static void aleatorio(Connection cn) {
		// TODO Auto-generated method stub

	}
}
