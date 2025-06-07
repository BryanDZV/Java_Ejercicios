package ficheros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Csv_Tabla_Propio {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Cargar el driver (necesario en algunos casos)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Datos de conexión
        String ip = "172.16.55.55";
        String bd = "programacion";
        String usuario = "daw1";
        String contraseña = "halloween";

        // Variables de recursos
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;
        FileWriter archivo = null;
        PrintWriter escritor = null;

        try {
            // ✅ Conectar con el método personalizado
            try {
                conexion = conectarMySQL(ip, bd, usuario, contraseña);
                System.out.println("✅ Conexión establecida.");
            } catch (SQLException e) {
                System.out.println("❌ Error de conexión: " + e.getMessage());
                return;
            }

            // ✅ Ejecutar consulta
            try {
                stmt = conexion.createStatement();
                String sql = "SELECT * FROM notas";
                rs = stmt.executeQuery(sql);
                System.out.println("✅ Consulta realizada.");
            } catch (SQLException e) {
                System.out.println("❌ Error al ejecutar consulta: " + e.getMessage());
                return;
            }

            // ✅ Crear archivo CSV
            try {
                archivo = new FileWriter("notas.csv");
                escritor = new PrintWriter(archivo);
                escritor.println("ID,Nombre,Nota");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int nota = rs.getInt("nota");

                    escritor.println(id + "," + nombre + "," + nota);
                }

                System.out.println("✅ Archivo notas.csv generado.");
            } catch (IOException e) {
                System.out.println("❌ Error al escribir el archivo: " + e.getMessage());
            }

        } finally {
            // ✅ Cerrar todo
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
                if (escritor != null) escritor.close();
                if (archivo != null) archivo.close();
                System.out.println("✅ Recursos cerrados.");
            } catch (Exception e) {
                System.out.println("❌ Error al cerrar: " + e.getMessage());
            }
        }
    }

    // 📦 Método para conectar a MySQL (el mismo del profesor)
    private static Connection conectarMySQL(String ip, String bd, String usu, String pass) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd, usu, pass);
        return cn;
    }
}
