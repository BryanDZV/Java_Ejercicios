package examenFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

public class TipoExamen2 {
	static Connection cn = null;

	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// DriverManager.getConnection("jdbc:mysql://"+ip+"/"+bd,usu,pass);
		try {
			// cargar driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// conexion
			// datos
			String ruta = "./src/examenFinal/datos.init";
			File datos = new File(ruta);
			BufferedReader bfr = new BufferedReader(new FileReader(datos));
			String user = bfr.readLine();
			String pass = bfr.readLine();
			String url = bfr.readLine();

			cn = DriverManager.getConnection(url, user, pass);
			System.out.println("CONECTADO CORRECTAMENTE A LA ABSE DE DATOS");
			// MENU
			List<City> l = new ArrayList<City>();
			do {
				System.out.println(
						"1.crear tabla y cargar datos desde datos.csv\n2.Listado ordenado por poblacion y codigo\n3.Guardar Fichero\n0.Salir");
				System.out.println("elige una opcion");
				int opcion = Entrada.entero();
				switch (opcion) {
				case 1:
					if (crearTabla(cn)) {
						System.out.println("****creada con exito la tabla***");

					}
					cargarDatos(cn);
					System.out.println("FIN CARGAR DATOS.");
					break;
				case 2:
					
					l = listado(cn);
					l.sort(null);
					System.out.println("***LISTADO ORDENADO POR POBLACION/CODIGO");
					for (City city : l) {
						System.out.println(city);
					}

					break;
				case 3:
					if (l.isEmpty()||l==null) {
						System.out.println("LISTA VACIA ejecuta la opcion 2 primero");
						
					}else {
						
						System.out.println("introduzca ruta para guardar");
						ruta=Entrada.cadena();
						guardarFichero(l,ruta);
						System.out.println("guardado exitoso");
					}

					break;
				case 0:
					System.out.println("saliendo...");
					return;

				default:
					System.out.println("no es una opcion");
					break;
				}

			} while (true);

		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar el driver");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("ruta no encontrada");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error al leer el fichero");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA ABSE DE DATOS");
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	

	



	private static void guardarFichero(List<City> l, String ruta) throws IOException {
		PrintWriter pw= new PrintWriter(new FileWriter(ruta),true);
		
		for (City city : l) {
			pw.println(city.getCodigo()+";"+city.getPoblacion());
			
		}
		
	}


	private static List<City> listado(Connection cn) throws FileNotFoundException, SQLException {
		List<City> l = new ArrayList<City>();
		ResultSet rs=leerTabla(cn);
		while (rs.next()) {
			l.add(new City(Integer.valueOf(rs.getInt("codigo")) , rs.getString("poblacion")));

		}
		return l;
	}

	private static ResultSet leerTabla(Connection cn) throws SQLException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql = "select * from bryanzavalaV";
		pst = cn.prepareStatement(sql);
		rs = pst.executeQuery();
		return rs;
	}

	private static void cargarDatos(Connection cn) throws IOException, SQLException {
		String ruta = "./src/examenFinal/datos.csv";
		BufferedReader bfr = new BufferedReader(new FileReader(new File(ruta)));
		PreparedStatement pst = null;
		ResultSet rs = null;
		String linea = bfr.readLine();
		linea = bfr.readLine();// salto al cabecera
		while (linea != null) {
			System.out.println(linea);
			String[] partes = linea.split(",");
			switch (partes[0]) {
			case "A":
				// existe?
				String sql = "select codigo from bryanzavalaV where codigo=?";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, Integer.valueOf(partes[1]));
				rs = pst.executeQuery();
				if (rs.next()) {
					// si YA EXISTE ACTAULIZAMOS
					sql = "update bryanzavalaV set poblacion=? where codigo=?";
					pst = cn.prepareStatement(sql);
					pst.setString(1, (partes[2]));
					pst.setInt(2, Integer.parseInt(partes[1]));

					int filasActualizadas = pst.executeUpdate();
					System.out.println("filas actualizadas " + filasActualizadas);
				} else {
					// INSERTAMOS SINO EXISTE
					sql = "insert into bryanzavalaV(codigo,poblacion)" + "values(?,?)";
					pst = cn.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(partes[1]));
					pst.setString(2, (partes[2]));
					int filasInsertadas = pst.executeUpdate();
					System.out.println("filas insertadas " + filasInsertadas);
				}
				break;
			case "B":
				sql = "delete from bryanzavalaV where codigo=?";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, Integer.valueOf(partes[1]));
				pst.executeUpdate();
				System.out.println("borrada fila");
				break;

			default:
				System.out.println("no es una opcion");
				break;
			}

			linea = bfr.readLine();
		}
		bfr.close();
		pst.close();
		rs.close();

	}

	private static boolean crearTabla(Connection cn) {
		Statement st = null;
		boolean okay = false;
		// consulta
		String sql = "CREATE TABLE IF NOT EXISTS bryanzavalaV(codigo integer primary key," + "poblacion varchar(255))";
		try {
			st = cn.createStatement();
			st.executeUpdate(sql);
			okay = true;
		} catch (SQLException e) {
			System.out.println("error al crear la tabla");
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				System.out.println("error al cerar recurso st");
			}

		}

		return okay;
	}

}
