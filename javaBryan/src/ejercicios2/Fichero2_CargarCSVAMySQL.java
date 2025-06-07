package ejercicios2;

import java.io.*;
import java.sql.*;

public class Fichero2_CargarCSVAMySQL {
    public static void main(String[] args) {
        try (
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuBase", "usuario", "contraseña");
            BufferedReader br = new BufferedReader(new FileReader("datos.csv"))
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    int codigo = Integer.parseInt(partes[0]);
                    String poblacion = partes[1];

                    PreparedStatement ps = cn.prepareStatement("REPLACE INTO nombreapellido VALUES (?, ?)");
                    ps.setInt(1, codigo);
                    ps.setString(2, poblacion);
                    ps.executeUpdate();
                }
            }

            System.out.println("CSV importado a MySQL.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}