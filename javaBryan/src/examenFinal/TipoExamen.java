package examenFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class TipoExamen {
	//recursos 
			static Connection cn = null;
			static Statement st = null; //a nivel de calse utilizable en todo

	public static void main(String[] args) {
//recursos 
		//Connection cn = null;
		//Statement st = null;
		try {
			// datos
			String ruta = "./src/examenFinal/datos.init";
			File datos = new File(ruta);
			BufferedReader bfr = new BufferedReader(new FileReader(datos));
			System.out.println("ruta correcta");

			String linea = bfr.readLine(); // salta cabecera

			List<String> ldatos = new ArrayList<String>();

			while (linea != null) {
				// System.out.println(linea);
				ldatos.add(linea);
				linea = bfr.readLine();

			}
			/*
			 * for (String elemento : ldatos) {
			 * System.out.println("dentro de la lista--->"+elemento); }
			 */

			String usuario = ldatos.get(0);
			String contraseña = ldatos.get(1);
			String url = ldatos.get(2);

			try {
				// bloque6.conexion
				// 1cargar drive
				Class.forName("com.mysql.cj.jdbc.Driver"); // 2conexion
				cn = DriverManager.getConnection(url, usuario, contraseña);
				System.out.println("CONEXION EXITOSA");
			} catch (Exception e) {
				System.out.println("erro al conectarse a la base de datos");
			}

			int opcion;
			do {
				System.out.println(
						"1.crear tabla y cargar datos desde datos.csv\n2.crear tabla y cargar datos desde datos.csv\n3. guardar fichero\n 0. salir");
				opcion = Entrada.entero();
				switch (opcion) {
				case 1: {
					if (crearTabla(cn, st)) {
						System.out.println("pasando a cargar datos desde datos.init");
						cargarDatos(cn, st);
					};

				}
				case 2: {
					System.out.println("generando listado Espere...");
					List<Ciudad> lCiudad = new ArrayList<Ciudad>();
					lCiudad = generarLista(cn, st);
					lCiudad.sort(null);
					System.out.println("**ordenado por poblacion ascdente/a igual poblacion por codigo descendente**");
					for (Ciudad ciudad : lCiudad) {
						System.out.println(ciudad);
					}
					;
					

				}
				case 3: {

				}
				case 0: {

				}
				default:
					throw new IllegalArgumentException();
				}
			} while (true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static List<Ciudad> generarLista(Connection cn, Statement st) throws SQLException {
		List<Ciudad> l = new ArrayList<Ciudad>();
		PreparedStatement pstRecogida = null;
		// consulta
		String sql = "select* from bryanzavala";
		pstRecogida = cn.prepareStatement(sql);
		ResultSet rs = pstRecogida.executeQuery();
		while (rs.next()) {
			Integer codigo = rs.getInt("codigo");
			String poblacion = rs.getString("poblacion");
			l.add(new Ciudad(codigo, poblacion));
			

		}
		/*
		 * for (Ciudad ciudad : l) { System.out.println(ciudad); }
		 */

		return l;
	}

	private static void cargarDatos(Connection cn, Statement st) {
		// recurso
		PreparedStatement pstBuscar = null;
		PreparedStatement pstActualizar = null;
		PreparedStatement pstInsertar = null;
		PreparedStatement pstBorrar = null;
		st = null;
		ResultSet rs = null;
		try {
			String ruta = "/javaBryan/src/examenFinal/datos.csv";
			File datos = new File(ruta);
			BufferedReader bfr = new BufferedReader(new FileReader(datos));
			String linea = bfr.readLine(); // salta cabecera
			linea = bfr.readLine();
			while (linea != null) {
				System.out.println(linea);
				String[] partes = linea.split(",");
				if (partes[0].equalsIgnoreCase("A")) {
					// comprobar si existe para actualizar
					// consulta por codigo
					String sql = "select codigo from bryanzavala where codigo=?";
					pstBuscar = cn.prepareStatement(sql);

					pstBuscar.setInt(1, Integer.valueOf(partes[1]));
					rs = pstBuscar.executeQuery();

					if (!rs.next()) {
						// consulta sql y crear prepare
						sql = "insert into bryanzavala(codigo,poblacion)" + "values(?,?)";
						pstInsertar = cn.prepareStatement(sql);
						// psar datos

						pstInsertar.setInt(1, Integer.valueOf(partes[1]));
						pstInsertar.setString(2, (partes[2]));

						// ejecutarla
						int filasAfectadas = pstInsertar.executeUpdate();
						System.out.println("INSERTADAS FILAS CON EXITO");

					} else {
						sql = "update bryanzavala set codigo=?,poblacion=? where codigo=?";
						pstActualizar = cn.prepareStatement(sql);
						pstActualizar.setInt(1, Integer.valueOf(partes[1]));
						pstActualizar.setString(2, partes[2]);
						pstActualizar.setInt(3, Integer.valueOf(partes[1]));
						pstActualizar.executeUpdate();

						System.out.println("actualziad con exito");

					}

				} else if (partes[0].equalsIgnoreCase("B")) {
					// consulta
					String sql = "delete from bryanzavala where codigo=?";
					pstBorrar = cn.prepareStatement(sql);
					pstBorrar.setInt(1, Integer.valueOf(partes[1]));
					pstBorrar.executeUpdate();
					System.out.println("BORRADO EXITOSO");
				}

				// System.out.println("soy primera columna"+partes[0]);

				linea = bfr.readLine();// siguiente lineas
			}

		} catch (FileNotFoundException e) {
			System.out.println("fallo al cargar datos ruta no entrada..saliendo");
			return;
		} catch (IOException e) {
			System.out.println("error en la lectura");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("tipo de dato incorrecto");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error sql");

		} finally {

		}

	}

	private static boolean crearTabla(Connection cn, Statement st) {
		// recuros
		boolean okay = false;
		// consulta
		try {
			String sql = "create table if not exists bryanZavala(" + "codigo integer primary key,"
					+ "poblacion varchar(255))";
			st = cn.createStatement();
			st.executeUpdate(sql);
			System.out.println("tabla creada correctamente");
			okay = true;

		} catch (SQLException e) {
			System.out.println("ha surgido un erro al crea la tabla");
		}
		return okay;

	}

}
