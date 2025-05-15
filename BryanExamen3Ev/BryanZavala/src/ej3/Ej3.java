package ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import utilidades.Entrada;

public class Ej3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// DriverManager.getConnection("jdbc:mysql://IP_serv/BD","usu","pass");

		// recursos
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		// cargar driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// datos
		String ruta = "CFG.INI";
		File datos = new File(ruta);
		BufferedReader bfr = new BufferedReader(new FileReader(datos));
		String ip = bfr.readLine();
		String bd = bfr.readLine();
		String user = bfr.readLine();
		String pass = bfr.readLine();

		String url = "jdbc:mysql://" + ip + "/" + bd;
		System.out.println(url);
		// conexion
			cn = DriverManager.getConnection(url, user, pass);
			System.out.println("CONEXION EXITOSA");
		

		try {
			// CREAR TABLA
			String sql = "create table if not exists clienteBryanZavala(id int primary key auto_increment,"
					+ "nombre varchar(100) not null," + "email varchar(100) unique not null," + "edad int)";
			st = cn.createStatement();
			
			st.executeUpdate(sql);

			System.out.println("tabla creada");

		} catch (Exception e) {
			System.out.println("tabla no creada error" + e.getMessage());
		}

		// menu
		do {
			System.out.println(
					"1.Insertar nuevo cliente\n2.Mostrar todos los clientes\n3.Actualizar email de un cliente por ID\n4.Eliminar cliente por ID\n5.Crear tabla HTML\n0.Salir");
			int opcion = Entrada.entero();
			switch (opcion) {
			case 1:
				// INSERTAMOS
				System.out.println("insertado NOMBRE");
				String nombre = Entrada.cadena();
				System.out.println("insertado EDAD");
				int edad = Entrada.entero();
				System.out.println("insertado EMAIL");
				String email = Entrada.cadena();
				// validando
				String sql = "";
				try {
					sql = "insert into clienteBryanZavala(id,nombre,email,edad)" + "values(null,?,?,?)";
					pst = cn.prepareStatement(sql);
					pst.setString(1, nombre);
					pst.setString(2, email);
					pst.setInt(3, edad);
					int filasAfectadas = pst.executeUpdate();
					System.out.println("FILAS AFECTADAS" + filasAfectadas);

				} catch (SQLIntegrityConstraintViolationException e) {
					System.out.println("email DUPLICADO" + e.getMessage());
				}

				break;
			case 2:
				// mostrar clientes
				sql = "select * from  clienteBryanZavala";
				pst = cn.prepareStatement(sql);
				rs = pst.executeQuery();
				int id;
				while (rs.next()) {
					id = rs.getInt("id");
					nombre = rs.getString("nombre");
					email = rs.getString("email");
					edad = rs.getInt("edad");
					System.out.println("id\t" + id + "nombre\t" + nombre + "email\t" + email + "edad\t" + edad);

				}

			case 3:
				// actualizar
				System.out.println("id de cliente a actualizar y nuevo email");
				System.out.println("id");
				id = Entrada.entero();
				System.out.println("email");
				email = Entrada.cadena();
				// validar

				sql = "select id from clienteBryanZavala where id=?";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();

				if (rs.next()) {
					sql = "update clienteBryanZavala set email=? where id=?";
					pst = cn.prepareStatement(sql);
					pst.setString(1, email);
					pst.setInt(2, id);

					pst.executeUpdate();
				} else {
					System.out.println("NO EXISTE EL CLIENTE");
				}

				break;
			case 4:
				// eliminar CLIENTE
				System.out.println("Id de cliente a eliminar");
				id = Entrada.entero();

				sql = "select id from clienteBryanZavala where id=?";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();

				if (rs.next()) {
					sql = "delete from clienteBryanZavala where=?";
					pst = cn.prepareStatement(sql);
					pst.setInt(1, id);
					pst.executeUpdate();

				} else {
					System.out.println("NO EXISTE EL CLIENTE");
				}

			case 5:
				// html
				
				sql = "select * from  clienteBryanZavala";
				pst = cn.prepareStatement(sql);
				rs = pst.executeQuery();

				String rutaFichero = "./src/clientes.html";
				File fichero = new File(rutaFichero);
				PrintWriter pw = new PrintWriter(new FileWriter(fichero), true);
				pw.println("<tr> <th>ID</th>  <th>NOMBRE</th> <th>EMAIL</th> <th>EDAD</th></tr>");
				while (rs.next()) {

					pw.println("<table border='1'><td>" + rs.getInt("id") + "</td>+<td>" + rs.getString("nombre")
							+ "</td><td>" + rs.getString("email") + "</td><td>" + rs.getInt("edad") + "</td>"
							+ "</table>");

				}
				System.out.println("html creada");

			case 0:
				System.out.println("SALIENDO...");
				break;
			default:
				System.out.println("no es una opcion");
				break;
			}

		} while (true);

	}// main

}// class
