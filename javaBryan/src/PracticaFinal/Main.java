package PracticaFinal;

import java.io.*;
import java.sql.*;
import java.util.*;

import utilidades.Entrada;

public class Main {
    static final String nombreTabla = "nombreapellido"; // Cambia por tu nombre

    public static void main(String[] args) {
        String datos=Entrada.cadena();
        int opcion;
        do {
            System.out.println("""
            1. Crear tabla y cargar datos desde datos.csv
            2. Listar ordenado por población y código
            3. Guardar en fichero
            4. Salir
            """);
            opcion =Entrada.entero();
            switch (opcion) {
                case 1 -> crearYcargar();
                case 2 -> listarOrdenado();
                case 3 -> guardarEnFichero();
            }
        } while (opcion != 4);
    }

    static void crearYcargar() {
        try {
            DBHelper.crearTabla(nombreTabla);
            try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
                 Connection con = DBHelper.getConnection()) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    String accion = partes[0];
                    int codigo = Integer.parseInt(partes[1]);
                    String poblacion = partes[2];

                    if (accion.equals("A")) {
                        String sql = "INSERT INTO " + nombreTabla + " (codigo, poblacion) VALUES (?, ?) " +
                                     "ON DUPLICATE KEY UPDATE poblacion = ?";
                        try (PreparedStatement pst = con.prepareStatement(sql)) {
                            pst.setInt(1, codigo);
                            pst.setString(2, poblacion);
                            pst.setString(3, poblacion);
                            pst.executeUpdate();
                        }
                    } else if (accion.equals("B")) {
                        String sql = "DELETE FROM " + nombreTabla + " WHERE codigo = ?";
                        try (PreparedStatement pst = con.prepareStatement(sql)) {
                            pst.setInt(1, codigo);
                            pst.executeUpdate();
                        }
                    }
                }
            }
            System.out.println("Datos cargados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void listarOrdenado() {
        try (Connection con = DBHelper.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM " + nombreTabla +
                    " ORDER BY poblacion DESC, codigo ASC")) {
            while (rs.next()) {
                System.out.println(rs.getInt("codigo") + " " + rs.getString("poblacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void guardarEnFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce nombre del fichero a guardar: ");
        String nombreFichero = sc.nextLine();
        try (Connection con = DBHelper.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM " + nombreTabla);
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {

            while (rs.next()) {
                bw.write(rs.getInt("codigo") + ";" + rs.getString("poblacion"));
                bw.newLine();
            }
            System.out.println("Datos guardados en " + nombreFichero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
