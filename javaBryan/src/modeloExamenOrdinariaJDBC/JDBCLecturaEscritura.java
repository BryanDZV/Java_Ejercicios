package modeloExamenOrdinariaJDBC;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import utilidades.Entrada;

public class JDBCLecturaEscritura {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		Connection cn = null;
		Statement st = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String ruta = "src/modeloExamenOrdinariaJDBC/CNF.INIT";
		// System.out.println(ruta);
		File datos = new File(ruta);
		BufferedReader bfr = new BufferedReader(new FileReader(datos));

		String user = bfr.readLine();
		String pass = bfr.readLine();
		String url = bfr.readLine();
		cn = DriverManager.getConnection(url, user, pass);

		st = cn.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS ventas (" + "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "producto VARCHAR(100) NOT NULL," + "cantidad INT NOT NULL," + "fecha DATE NOT NULL)";

		st.executeUpdate(sql);// ok
		boolean salir = false;
		do {
			System.out.println("\nTU MENU ELIGE UNA OPCION/FIN PARA SALIR");
			System.out.println(
					"1.Insertar venta\n2.Listar todas las ventas\n3.Actualizar Cantidad de venta\n4.Eliminar venta\n5.Exportar Ventas CVS\n6.Crear Htmlfin para salir");

			String dato = Entrada.cadena();
			if (dato.equalsIgnoreCase("fin")) {
				System.out.println("saliendo");
				salir = true;
			} else if (!dato.matches("[0-9]+")) {
				System.out.println("opcion no valida");

			} else {

				int opcion = Integer.parseInt(dato);

				switch (opcion) {
				case 1:
					System.out.println("producto a insertar");
					String producto = Entrada.cadena();
					System.out.println("cantidad");
					int cantidad = Entrada.entero();
					System.out.println("fecha");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false);

					try {
						Date fecha = sdf.parse(Entrada.cadena());
						insertarVentas(cn, producto, cantidad, fecha);
					} catch (ParseException e) {
						System.out.println("Fecha no valida, formato dd/MM/yyyy");

					}

					break;
				case 2:
					ResultSet rs = null;
					rs = listarVentas(cn);
					System.out.println("ID Producto Cantidad Fecha");
					while (rs.next()) {
						int id = rs.getInt("id");
						producto = rs.getString("producto");
						cantidad = rs.getInt("cantidad");
						Date fecha = rs.getDate("fecha");
						System.out.println(id + " " + producto + " " + cantidad + " " + fecha);
					}
					rs.close(); // Cerramos el ResultSet después de usarlo

					break;
				case 3:
					System.out.println("ID de la venta a actualizar");
					int id = Entrada.entero();
					int nuevaCantidad = 0; // Inicializamos para evitar errores de variable no asignada
					if (!noExisteVenta(cn, id)) {
						System.out.println("La venta con ID " + id + " no existe.\n");

					} else {
						// 2️⃣ Si existe, pido cantidad, actualizo y sólo entonces confirmo
						System.out.println("Nueva cantidad:");
						nuevaCantidad = Entrada.entero();
						actualizarVenta(cn, id, nuevaCantidad);
						System.out.println("✅ Venta actualizada correctamente: ID " + id);
					}

					break;
				case 4:
					System.out.println("ID de la venta a eliminar");
					id = Entrada.entero();
					eliminarVenta(cn, id);
					System.out.println("Venta eliminada correctamente: ID " + id);
					break;
				case 5:
					System.out.println("Exportando ventas a CSV...");
					exportarVentasCSV(cn);

					break;
				case 6:
					System.out.println("Creando archivo HTML...");
					crearHtmlVentas(cn);
					System.out.println("Archivo HTML creado correctamente: ventas.html");

					break;

				default:
					System.out.println("soy defaul opcion");
					break;
				}

			}

		} while (!salir);

	}

	private static void crearHtmlVentas(Connection cn) throws IOException, SQLException {
		PreparedStatement pst = null;
		String ruta = "ventas.html";
		File datos = new File(ruta);
		PrintWriter pw = new PrintWriter(new FileWriter(datos), true);
		pw.println("<html>");
		pw.println("<head><title>Ventas</title></head>");
		pw.println("<body>");
		pw.println("<h1>Listado de Ventas</h1>");
		pw.println("<table border='1'>");
		pw.println("<tr><th>ID</th><th>Producto</th><th>Cantidad</th><th>Fecha</th></tr>");
		String sql = "SELECT * FROM ventas";
		pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String producto = rs.getString("producto");
			int cantidad = rs.getInt("cantidad");
			Date fecha = rs.getDate("fecha");
			pw.println("<tr><td>" + id + "</td><td>" + producto + "</td><td>" + cantidad + "</td><td>" + fecha
					+ "</td></tr>");

		}

	}

	private static void exportarVentasCSV(Connection cn) throws SQLException, IOException {
		PreparedStatement pst = null;
		String ruta = "ventas.csv";
		File datos = new File(ruta);
		PrintWriter pw = new PrintWriter(new FileWriter(datos), true);
		String sql = "SELECT * FROM ventas";
		pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String producto = rs.getString("producto");
			int cantidad = rs.getInt("cantidad");
			Date fecha = rs.getDate("fecha");
			pw.println(id + ";" + producto + ";" + cantidad + ";" + fecha);
		}

	}

	private static boolean noExisteVenta(Connection cn, int id) throws SQLException {
		PreparedStatement pst = null;
		String sql = "SELECT * FROM ventas WHERE id=?";
		pst = cn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		return rs.next(); // Devuelve true si existe, false si no existe

	}

	private static void eliminarVenta(Connection cn, int id) throws SQLException {
		PreparedStatement pst = null;
		String sql = "DELETE FROM ventas WHERE id=?";
		pst = cn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

	}

	private static void actualizarVenta(Connection cn, int id, int nuevaCantidad) throws SQLException {
		PreparedStatement pst = null;
		String sql = "update ventas set cantidad=? where id=?";
		pst = cn.prepareStatement(sql);
		pst.setInt(1, nuevaCantidad);
		pst.setInt(2, id);
		pst.executeUpdate();
		pst.close();

	}

	private static ResultSet listarVentas(Connection cn) throws SQLException {
		PreparedStatement pst = null;

		String sql = "Select * from ventas";
		pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();

		return (rs);
	}

	// 1) Cambia la firma para recibir la conexión real:
	private static void insertarVentas(Connection cn, String producto, int cantidad, Date fecha) throws SQLException {
		// 2) Preparamos sobre la conexión que pasamos:
		String sql = "INSERT INTO ventas(producto, cantidad, fecha) VALUES (?, ?, ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		// 3) ¡Recuerda: empieza en 1!
		pst.setString(1, producto);
		pst.setInt(2, cantidad);
		// 4) Convierte util.Date → sql.Date con un 'puente' de milisegundos
		pst.setDate(3, new java.sql.Date(fecha.getTime()));
		pst.executeUpdate();
		pst.close();
	}

}
