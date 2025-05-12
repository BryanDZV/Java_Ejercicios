package examenOrdinaria;

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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class EjercicioJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bryan";
		String user = "root";
		String pass = "";
		cn = DriverManager.getConnection(url, user, pass);
		System.out.println("conectado con exito");
		List<City> l = new ArrayList<City>();
		do {
			System.out.println(
					"1.crear tabal y cargar datos desde.csv\n2.listado ordenador por poblacion y codigo\n3.guardar en fichero\n0.salir");
			int opcion = Entrada.entero();
			switch (opcion) {
			case 1:
				// crear tabla
				String sql = "create table if not exists bb(" + "codigo integer primary key,"
						+ "poblacion varchar(255))";
				st = cn.createStatement();
				st.executeUpdate(sql);
				System.out.println("tabla creada con exito");
				// cargardatos
				String ruta = "./src/examenOrdinaria/datos.csv";
				File fichero = new File(ruta);
				BufferedReader bfr = new BufferedReader(new FileReader(fichero));
				String linea = bfr.readLine();
				linea = bfr.readLine();
				while (linea != null) {
					System.out.println(linea);
					String[] tmp = linea.split(",");
					if (tmp[0].equals("A")) {
						switch (tmp[0]) {
						case "A":
							sql = "select * from bb where codigo=?";
							pst = cn.prepareStatement(sql);
							pst.setInt(1, Integer.parseInt(tmp[1]));
							rs = pst.executeQuery();
							if (rs.next()) {
								// actualizar
								sql = "update bb set poblacion=? where codigo=?";
								pst = cn.prepareStatement(sql);
								pst.setString(1, tmp[2]);
								pst.setInt(2, Integer.parseInt(tmp[1]));
								pst.executeUpdate();
							} else {
								sql = "insert into bb(Codigo,Poblacion)" + "values(?,?)";
								pst = cn.prepareStatement(sql);
								pst.setString(1, tmp[1]);
								pst.setString(2, tmp[2]);

								pst.executeUpdate();

							}

							break;
						case "B":
							// borrar
							sql = "delete from bb where codigo=?";
							pst = cn.prepareStatement(sql);
							pst.setInt(1, Integer.parseInt(tmp[1]));
							pst.executeUpdate();
							break;

						default:
							System.out.println("la accion es invalida");
							break;
						}

					}
					linea = bfr.readLine();
				}
				bfr.close();
				break;
			case 2:
				// listado
			
				sql = "select * from bb";
				pst = cn.prepareStatement(sql);
				rs = pst.executeQuery();

				while (rs.next()) {
					l.add(new City(rs.getString("poblacion"), rs.getInt("codigo")));

				}

				for (City city : l) {
					System.out.println(city);
				}
				l.sort(null);

				break;

			case 3:
				
				File nuevoFichero=new File("datos2.txt");
				PrintWriter pw=new PrintWriter(new FileWriter(nuevoFichero));
				for (City city : l) {
					//System.out.println(city);
					pw.println(city.getCiudad()+";"+city.getCodigo());
				}
pw.close();
				break;
			case 0:
				System.out.println("saliendo");
				return;

			default:
				break;
			}

		} while (true);

	}

}
