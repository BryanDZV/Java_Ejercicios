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

import utilidades.Entrada;

public class JDBCLecturaEscritura {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
        Connection cn = null;
        Statement st = null;
        BufferedReader bfr = null;

        // 1) Cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2) Leer archivo de configuración
        String ruta = "src/modeloExamenOrdinariaJDBC/CNF.INIT";
        File datos = new File(ruta);
        bfr = new BufferedReader(new FileReader(datos));
        String user = bfr.readLine();
        String pass = bfr.readLine();
        String url  = bfr.readLine();
        bfr.close(); // CIERRE MANUAL BufferedReader

        // 3) Conectar a BD
        cn = DriverManager.getConnection(url, user, pass);

        // 4) Crear tabla
        st = cn.createStatement();
        String crea = "CREATE TABLE IF NOT EXISTS ventas ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "producto VARCHAR(100) NOT NULL,"
                    + "cantidad INT NOT NULL,"
                    + "fecha DATE NOT NULL)";
        st.executeUpdate(crea);

        boolean salir = false;
        do {
            System.out.println("\nTU MENU ELIGE UNA OPCION/FIN PARA SALIR");
            System.out.println("1.Insertar venta\n2.Listar todas las ventas\n"
                             + "3.Actualizar Cantidad de venta\n4.Eliminar venta\n"
                             + "5.Exportar Ventas CSV\n6.Crear HTML\n7.Importar desde CSV\n8.Importar desde HTML\n9.HTML a CSV\nFIN para salir");

            String dato = Entrada.cadena();
            if (dato.equalsIgnoreCase("fin")) {
                System.out.println("Saliendo...");
                salir = true;

            } else if (!dato.matches("\\d+")) {
                System.out.println("Opción no válida.");

            } else {
                int opcion = Integer.parseInt(dato);
                switch (opcion) {
                    case 1:
                        // INSERTAR
                        System.out.println("Producto a insertar:");
                        String producto = Entrada.cadena();
                        System.out.println("Cantidad:");
                        int cantidad = Entrada.entero();
                        System.out.println("Fecha (dd/MM/yyyy):");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        sdf.setLenient(false);
                        try {
                            Date fecha = sdf.parse(Entrada.cadena());
                            insertarVenta(cn, producto, cantidad, fecha);
                            System.out.println("✅ Venta insertada correctamente.");
                        } catch (ParseException e) {
                            System.out.println("Fecha no válida, formato dd/MM/yyyy.");
                        }
                        break;

                    case 2:
                        // LISTAR
                        System.out.printf("ID  %-10s  %-8s  %s%n", "Producto", "Cantidad", "Fecha");
                        PreparedStatement pstList = cn.prepareStatement("SELECT * FROM ventas");
                        ResultSet rsList = pstList.executeQuery();
                        while (rsList.next()) {
                            int id    = rsList.getInt("id");
                            String prod = rsList.getString("producto");
                            int cant = rsList.getInt("cantidad");
                            Date f = rsList.getDate("fecha");
                            System.out.printf("%d  %-10s  %-8d  %s%n", id, prod, cant, f);
                        }
                        rsList.close();    // CIERRE MANUAL ResultSet
                        pstList.close();  // CIERRE MANUAL PreparedStatement
                        break;

                    case 3:
                        // ACTUALIZAR
                        System.out.println("ID de la venta a actualizar:");
                        int idAct = Entrada.entero();
                        if (!ventaExiste(cn, idAct)) {
                            System.out.println("La venta con ID " + idAct + " no existe.\n");
                        } else {
                            System.out.println("Nueva cantidad:");
                            int nuevaCant = Entrada.entero();
                            actualizarVenta(cn, idAct, nuevaCant);
                            System.out.println("✅ Venta actualizada correctamente: ID " + idAct);
                        }
                        break;

                    case 4:
                        // ELIMINAR
                        System.out.println("ID de la venta a eliminar:");
                        int idDel = Entrada.entero();
                        if (!ventaExiste(cn, idDel)) {
                            System.out.println("La venta con ID " + idDel + " no existe.\n");
                        } else {
                            eliminarVenta(cn, idDel);
                            System.out.println("✅ Venta eliminada correctamente: ID " + idDel);
                        }
                        break;

                    case 5:
                        // EXPORTAR CSV
                        System.out.println("Exportando ventas a CSV...");
                        exportarVentasCSV(cn);
                        System.out.println("✅ CSV generado: ventas.csv");
                        break;

                    case 6:
                        // CREAR HTML
                        System.out.println("Creando archivo HTML...");
                        crearHtmlVentas(cn);
                        System.out.println("✅ HTML creado: ventas.html");
                        break;

                    case 7:
                        // IMPORTAR DESDE CSV
                        System.out.println("Importando ventas desde CSV...");
                        importarDesdeCSV(cn, "ventas.csv");
                        System.out.println("✅ Importación desde CSV completada.");
                        break;

                    case 8:
                        // IMPORTAR DESDE HTML
                        System.out.println("Importando ventas desde HTML...");
                        importarDesdeHTML(cn, "ventas.html");
                        System.out.println("✅ Importación desde HTML completada.");
                        break;

                    case 9:
                        // HTML A CSV
                        System.out.println("Convirtiendo HTML a CSV...");
                        htmlToCSV("ventas.html", "ventas_de_html.csv");
                        System.out.println("✅ HTML convertido a CSV: ventas_de_html.csv");
                        break;

                    default:
                        System.out.println("Opción no reconocida.");
                        break;
                }
            }
        } while (!salir);

        // 5) CIERRE MANUAL recursos principales
        st.close();    // Cierra el Statement de creación
        cn.close();    // Cierra la conexión
    }

    private static void insertarVenta(Connection cn, String producto, int cantidad, Date fecha) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("INSERT INTO ventas(producto, cantidad, fecha) VALUES (?, ?, ?)");
        pst.setString(1, producto);
        pst.setInt(2, cantidad);
        pst.setDate(3, new java.sql.Date(fecha.getTime()));
        pst.executeUpdate();
        pst.close();
    }

    private static boolean ventaExiste(Connection cn, int id) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("SELECT 1 FROM ventas WHERE id = ?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        boolean existe = rs.next();
        rs.close();
        pst.close();
        return existe;
    }

    private static void actualizarVenta(Connection cn, int id, int nuevaCantidad) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("UPDATE ventas SET cantidad = ? WHERE id = ?");
        pst.setInt(1, nuevaCantidad);
        pst.setInt(2, id);
        pst.executeUpdate();
        pst.close();
    }

    private static void eliminarVenta(Connection cn, int id) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM ventas WHERE id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
    }

    private static void exportarVentasCSV(Connection cn) throws SQLException, IOException {
        PreparedStatement pst = cn.prepareStatement("SELECT * FROM ventas");
        ResultSet rs = pst.executeQuery();
        PrintWriter pw = new PrintWriter(new FileWriter("ventas.csv"), true);
        while (rs.next()) {
            int id    = rs.getInt("id");
            String prod = rs.getString("producto");
            int cant = rs.getInt("cantidad");
            Date f = rs.getDate("fecha");
            pw.println(id + ";" + prod + ";" + cant + ";" + f);
        }
        pw.close();
        rs.close();
        pst.close();
    }

    private static void crearHtmlVentas(Connection cn) throws SQLException, IOException {
        PreparedStatement pst = cn.prepareStatement("SELECT * FROM ventas");
        ResultSet rs = pst.executeQuery();
        PrintWriter pw = new PrintWriter(new FileWriter("ventas.html"), true);
        pw.println("<html>");
        pw.println("<head><title>Ventas</title></head>");
        pw.println("<body>");
        pw.println("<h1>Listado de Ventas</h1>");
        pw.println("<table border='1'>");
        pw.println("<tr><th>ID</th><th>Producto</th><th>Cantidad</th><th>Fecha</th></tr>");
        while (rs.next()) {
            int id    = rs.getInt("id");
            String prod = rs.getString("producto");
            int cant = rs.getInt("cantidad");
            Date f = rs.getDate("fecha");
            pw.printf("<tr><td>%d</td><td>%s</td><td>%d</td><td>%s</td></tr>%n", id, prod, cant, f);
        }
        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
        rs.close();
        pst.close();
    }

    // Nueva funcionalidad:
    private static void importarDesdeCSV(Connection cn, String filePath) throws IOException, SQLException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(";");
            String prod = campos[1];
            int cant = Integer.parseInt(campos[2]);
            Date fecha = sdf.parse(campos[3]);
            insertarVenta(cn, prod, cant, fecha);
        }
        reader.close();
    }

    private static void importarDesdeHTML(Connection cn, String filePath) throws IOException, SQLException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith("<tr><td>")) {
                String content = line.replaceAll("</?tr>", "");
                String[] cols = content.split("</td><td>");
                int id = Integer.parseInt(cols[0].replace("<tr><td>", ""));
                String prod = cols[1];
                int cant = Integer.parseInt(cols[2]);
                String fechaStr = cols[3].replace("</td>", "");
                Date fecha = sdf.parse(fechaStr);
                insertarVenta(cn, prod, cant, fecha);
            }
        }
        reader.close();
    }

    private static void htmlToCSV(String htmlPath, String csvPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(htmlPath));
        PrintWriter pw = new PrintWriter(new FileWriter(csvPath), true);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith("<tr><td>")) {
                String content = line.replaceAll("</?tr>", "");
                String[] cols = content.split("</td><td>");
                cols[0] = cols[0].replace("<tr><td>", "");
                cols[3] = cols[3].replace("</td>", "");
                pw.println(cols[0] + ";" + cols[1] + ";" + cols[2] + ";" + cols[3]);
            }
        }
        pw.close();
        reader.close();
    }
}
