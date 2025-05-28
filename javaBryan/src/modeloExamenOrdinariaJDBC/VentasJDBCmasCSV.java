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

import com.mysql.cj.xdevapi.Result;

import utilidades.Entrada;

public class VentasJDBCmasCSV {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		Connection cn = null;
		Statement st = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String ruta = "C:\\Users\\bryan\\git\\javaBryan\\src\\modeloExamenOrdinariaJDBC\\CNF.INIT";
		File datos = new File(ruta);
		BufferedReader bfr = new BufferedReader(new FileReader(datos));
		String user = bfr.readLine();
		String pass = bfr.readLine();
		String url = bfr.readLine();
		bfr.close();
		cn = DriverManager.getConnection(url, user, pass);
		System.out.println("ok");
		st = cn.createStatement();
		String crea = "CREATE TABLE libros (\r\n" + "  isbn VARCHAR(20) PRIMARY KEY,\r\n" + "  titulo VARCHAR(200),\r\n"
				+ "  autor VARCHAR(100),\r\n" + "  año Date)";
		try {
			st.executeUpdate(crea);
			System.out.println("ok tabla");
		} catch (Exception e) {
			System.out.println("ya existe");
		}

		// menu
		boolean salir = false;
		do {
			System.out.println("elige una opcion:\n");
			System.out.println(
					"1.insertar\n2.Mostar Todos\n3.Modificar Año por ISBN\n4.Eliminar por ISBN\n5.Exportar a texto biblioteca.txt\n6.SALIR");
			String dato = Entrada.cadena();
			if (dato.equalsIgnoreCase("salir") || dato.equals("6")) {
				System.out.println("✔ Saliendo...");
				salir = true;

			} else if (!dato.matches("[1-6]")) {
				System.out.println("⚠ Opción no válida");

			} else {
				int opcion = Integer.parseInt(dato);
				switch (opcion) {
				case 1:
					System.out.println("ISBN");
					String isbn = Entrada.cadena();
					// valida de insertar
					if (validarExiste(cn, isbn)) {
						System.out.println("ya EXISTE ESE ISBN");
					} else {
						System.out.println("titulo");
						String titulo = Entrada.cadena();
						System.out.println("autor");
						String autor = Entrada.cadena();
						System.out.println("año dd/mm/yyyy");
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.setLenient(false);
						Date fecha = new Date();
						try {

							fecha = sdf.parse(Entrada.cadena());
						} catch (ParseException e) {
							System.out.println("formato de fecha no valido");
						}

						// insertar sino existe
						insertarPorIsbn(cn, isbn, titulo, autor, fecha);
						System.out.println("insertado ok");
					}

					break;
				case 2:
					mostrarTodos(cn);
					System.out.println("mostrados ok");

					break;
				case 3:
					System.out.println("ISBN");
					isbn = Entrada.cadena();
					// valida antes de modificar
					if (validarExiste(cn, isbn)) {
						// System.out.println("ya EXISTE ESE ISBN");
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.setLenient(false);
						Date fecha = sdf.parse(Entrada.cadena());
						modificarAño(cn, isbn, fecha);
						System.out.println("MODIFICACION OK");

					} else {
						System.out.println("no existe el ISBN");
					}

					break;
				case 4:
					System.out.println("ISBN");
					isbn = Entrada.cadena();
					// valida antes de modificar
					if (validarExiste(cn, isbn)) {
						eleminar(cn, isbn);
						System.out.println("elimanacion ok");

					} else {
						System.out.println("no existe");
					}

					break;
				case 5:
					exportar(cn);
					System.out.println("exportar ok");

					break;
				case 6:
					System.out.println("saliendo");
					salir = true;

					break;

				default:
					System.out.println("OPCION NO VALIDA ");
					break;
				}

			}

		} while (!salir);
		
		st.close();
		cn.close();

	}

	private static void exportar(Connection cn) throws SQLException, IOException {
		String sql = "select * from libros";
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		PrintWriter pw = new PrintWriter(new FileWriter("libros.txt"), true);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while (rs.next()) {
			pw.println(rs.getString("isbn") + ";" + rs.getString("titulo") + rs.getString("autor")
					+ sdf.format(rs.getDate("año")));

		}
		
		pst.close();
		rs.close();
		pw.close();

	}

	private static void eleminar(Connection cn, String isbn) throws SQLException {
		String sql = "delete from libros where isbn=?";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, isbn);
		pst.executeUpdate();

	}

	private static void modificarAño(Connection cn, String isbn, Date fecha) throws SQLException {
		String sql = "update libros set año=? where isbn=?";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setDate(1, new java.sql.Date(fecha.getTime()));
		pst.setString(2, isbn);
		pst.executeUpdate();
		pst.close();

	}

	private static void mostrarTodos(Connection cn) throws SQLException {
		String sql = "select * from libros";

		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		System.out.println("DATOS MOSTRANDO::\n");
		System.out.println("ISBN\t" + "TÍTULO\t" + "AUTOR\t" + "AÑO");
		while (rs.next()) {
			String isbn = rs.getString("isbn");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			Date fecha = rs.getDate("año");

			System.out.println(isbn + "\t" + titulo + "\t" + autor + "\t" + fecha + "\n");
		}

	}

	private static void insertarPorIsbn(Connection cn, String isbn, String titulo, String autor, Date fecha)
			throws SQLException {
// Es mejor nombrar columnas para evitar problemas si cambia el orden
		String sql = "INSERT INTO libros(isbn, titulo, autor, año) VALUES (?,?,?,?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, isbn); // primer ?
		pst.setString(2, titulo); // segundo ?
		pst.setString(3, autor); // tercer ?
		pst.setDate(4, new java.sql.Date(fecha.getTime())); // cuarto ?
		pst.executeUpdate();
		pst.close();
	}

	private static boolean validarExiste(Connection cn, String isbn) throws SQLException {
		PreparedStatement pst = null;
		String sql = "Select * from libros where isbn=?";
		pst = cn.prepareStatement(sql);
		pst.setString(1, isbn);
		ResultSet rs = pst.executeQuery();
		boolean existe = false;
		while (rs.next()) {
			existe = true;
		}
		pst.close();
		rs.close();
		return existe;

	}

}
