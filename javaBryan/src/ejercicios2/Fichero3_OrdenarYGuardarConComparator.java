package ejercicios2;

import java.io.*;
import java.sql.*;
import java.util.*;

class Registro {
    int codigo;
    String poblacion;

    public Registro(int codigo, String poblacion) {
        this.codigo = codigo;
        this.poblacion = poblacion;
    }

    public String toString() {
        return codigo + ";" + poblacion;
    }
}

public class Fichero3_OrdenarYGuardarConComparator {
    public static void main(String[] args) {
        try (
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tuBase", "usuario", "contraseña");
            PrintWriter pw = new PrintWriter(new FileWriter("ordenado.csv"))
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            List<Registro> lista = new ArrayList<>();

            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM nombreapellido");

            while (rs.next()) {
                lista.add(new Registro(rs.getInt("codigo"), rs.getString("poblacion")));
            }

            lista.sort((a, b) -> {
                int comp = a.poblacion.compareTo(b.poblacion);
                if (comp == 0) return Integer.compare(b.codigo, a.codigo);
                return comp;
            });

            for (Registro r : lista) {
                pw.println(r);
            }

            System.out.println("Datos ordenados y guardados en ordenado.csv.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}