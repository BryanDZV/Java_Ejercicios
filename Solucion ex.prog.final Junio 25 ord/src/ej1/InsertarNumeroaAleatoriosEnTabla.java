package ej1;
import java.io.*;
import java.sql.*;
import java.util.*;

public class InsertarNumeroaAleatoriosEnTabla {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Leer CFG.INI
			BufferedReader br = new BufferedReader(new FileReader("CFG.INI"));
			String host = br.readLine().trim();
			String password = br.readLine().trim();
			String database = br.readLine().trim();
			String user = br.readLine().trim();
			br.close();

			// Conexión
			String url = "jdbc:mysql://" + host + "/" + database;
			System.out.println(url+" "+user+" "+password);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado a la base de datos.");

			// Buscar fila del alumno
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM alumno WHERE nombreapellido LIKE '%Rene%Pozo%'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				int desde = rs.getInt("desde");
				int hasta = rs.getInt("hasta");
				String nombretabla = rs.getString("nombretabla");
				String nombrefichero = rs.getString("nombrefichero");

				// Crear tabla si no existe
				String crearTabla = "CREATE TABLE IF NOT EXISTS " + nombretabla + " (aleatorio INT PRIMARY KEY)";
				st = conn.createStatement();
				st.executeUpdate(crearTabla);
				System.out.println("Tabla '" + nombretabla + "creada.");

				// Vaciar tabla
				st.executeUpdate("DELETE FROM " + nombretabla);
				System.out.println("Contenido anterior de la tabla eliminado.");

				// Generar 50 números únicos
				Random r = new Random();
				Set<Integer> numeros = new HashSet<>();
				while (numeros.size() < 50) {
					int num = r.nextInt(hasta - desde + 1) + desde;
					numeros.add(num);
				}

				// Insertar en tabla
				PreparedStatement insert = conn.prepareStatement("INSERT INTO " + nombretabla + " (aleatorio) VALUES (?)");
				for (int num : numeros) {
					insert.setInt(1, num);
					insert.executeUpdate();
				}
				System.out.println("50 números aleatorios insertados en la tabla.");

				// Ordenar de menor a mayor
				List<Integer> lista = new ArrayList<>(numeros);
				lista.sort(null); // ascendente

				// Escribir de mayor a menor con PrintWriter
				PrintWriter pw = new PrintWriter(nombrefichero);
				for (int i = lista.size() - 1; i >= 0; i--) {
					pw.println(lista.get(i));
				}
				pw.close();
				System.out.println("Fichero '" + nombrefichero + "' creado en orden descendente.");
			} else {
				System.out.println("No se encontró ningún alumno con nombre 'Rene Pozo'.");
			}
		} catch (SQLException e) {
			System.err.println("Error en base de datos: " + e.getMessage());
			e.printStackTrace();
		} 
		 catch (IOException e) {
				System.err.println("Error en base de datos: " + e.getMessage());
				e.printStackTrace();
			} 
	}
}
