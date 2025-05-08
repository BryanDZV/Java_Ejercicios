package PracticaFinal;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DBHelper {
    private static String url, user, password, db;

    static {
        try (BufferedReader br = new BufferedReader(new FileReader("CFG.INI"))) {
            String host = br.readLine().trim();
            String port = br.readLine().trim();
            db = br.readLine().trim();
            user = br.readLine().trim();
            password = br.readLine().trim();
            url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        } catch (IOException e) {
            System.out.println("Error leyendo CFG.INI: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void crearTabla(String nombreTabla) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " (" +
                     "codigo INT PRIMARY KEY, poblacion VARCHAR(255))";
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        }
    }
}
