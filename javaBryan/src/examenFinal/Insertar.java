package examenFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar {

	public static void main(String[] args) {
		// datos
		String url = "jdbc:mysql://localhost:3306/cuentas";
		String usuario = "root";
		String contraseña = "";

		Connection cn = null;

		PreparedStatement pstBuscar = null;
		PreparedStatement pstInsertar = null;

		String codigo = "c005"; // <- estos valores puedes pedirlos por Scanner
		String propietario = "Laura";
		String email = "laura@email.com";
		double saldo = 300.0;

		try {
			// 1cargar el drive
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2 conexion
			cn = DriverManager.getConnection(url, usuario, contraseña);
			// 3consultas
			String sqlBuscar = "select * from cuentas where codigo=?";
			pstBuscar = cn.prepareStatement(sqlBuscar);
			pstBuscar.setString(1, codigo);
			ResultSet rs = pstBuscar.executeQuery();

			if (!rs.next()) {
				// 4insertando
				String sqlInsertar = "insert into cuentas (codigo,propietario,email,saldo) values(?,?,?,?)";
				pstInsertar = cn.prepareStatement(sqlInsertar);
				pstInsertar.setString(1, codigo);
				pstInsertar.setString(2, propietario);
				pstInsertar.setString(3, email);
				pstInsertar.setDouble(4, saldo);

				pstInsertar.executeUpdate();
				System.out.println("insertado correctamente");

			} else {
				System.out.println("el codigo ya existe");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("el drive tiene problemas"+e.getMessage());

		} catch (SQLException e) {
			System.out.println("erro en la consulta" + e.getMessage());
		} finally {
			try {
				if (pstBuscar != null)
					pstBuscar.close();
				if (pstInsertar != null)
					pstInsertar.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				System.out.println("❌ Error al cerrar recursos." + e.getMessage());
			}
		}

	}

}
