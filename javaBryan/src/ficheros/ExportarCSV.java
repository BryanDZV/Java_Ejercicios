package ficheros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ExportarCSV {
    public static void main(String[] args) throws SQLException {
        // 📌 Datos para conectar a MySQL
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos"; // Cambia el nombre de la base de datos
        String usuario = "root";      // Cambia si usas otro usuario
        String contraseña = "";       // Añade tu contraseña si tienes

        // 🔧 Declaramos variables fuera del try para poder cerrarlas al final
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;
        FileWriter archivo = null;
        PrintWriter escritor = null;

        try {
            // 🔹 Paso 1: Conexión a la base de datos
            try {
                conexion = DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("✅ Conexión a MySQL establecida.");
            } catch (SQLException e) {
                System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
                return; // No se puede continuar sin conexión
            }

            // 🔹 Paso 2: Ejecutar la consulta SELECT
            try {
                stmt = conexion.createStatement();
                String consulta = "SELECT id, nombre, email FROM clientes"; // Cambia según tu tabla
                rs = stmt.executeQuery(consulta);
                System.out.println("✅ Consulta ejecutada correctamente.");
            } catch (SQLException e) {
                System.out.println("❌ Error al ejecutar la consulta: " + e.getMessage());
                return; // No se puede continuar sin resultados
            }

            // 🔹 Paso 3: Crear y escribir el archivo CSV
            try {
                // Crear archivo llamado "clientes.csv" en la raíz del proyecto
                archivo = new FileWriter("clientes.csv");
                escritor = new PrintWriter(archivo);

                // Escribir la cabecera del archivo CSV
                escritor.println("ID,Nombre,Email");

                // Recorrer los resultados y escribir cada fila en el archivo
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");
                    //mostrar la tabla por consola(opcional)
                    System.out.printf("%10d %-30s %d\n",rs.getInt("id"),rs.getString("nombre"),rs.getInt("nota"));

                    // Escribimos la línea separada por comas
                    escritor.println(id + "," + nombre + "," + email);
                }

                System.out.println("✅ Archivo CSV creado correctamente.");
            } catch (IOException e) {
                System.out.println("❌ Error al crear o escribir el archivo CSV: " + e.getMessage());
            }

        } finally {
            // 🔹 Paso 4: Cerrar todos los recursos
            try {
                if (rs != null) rs.close();              // Cerrar ResultSet
                if (stmt != null) stmt.close();          // Cerrar Statement
                if (conexion != null) conexion.close();  // Cerrar conexión MySQL
                if (escritor != null) escritor.close();  // Cerrar escritor
                if (archivo != null) archivo.close();    // Cerrar archivo
                System.out.println("✅ Recursos cerrados correctamente.");
            } catch (Exception e) {
                System.out.println("❌ Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
