package ejercicios1;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Fichero1_GuardarDesdeMySQL {
    public static void main(String[] args) {
        try (
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuBase", "usuario", "contraseña");
            PrintWriter pw = new PrintWriter(new FileWriter("salida.csv"))
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "SELECT codigo, poblacion FROM nombreapellido";
            ResultSet rs = cn.createStatement().executeQuery(sql);

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String poblacion = rs.getString("poblacion");
                pw.println(codigo + ";" + poblacion);
            }

            System.out.println("Datos guardados en salida.csv");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}