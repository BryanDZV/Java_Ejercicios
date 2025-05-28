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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;

public class VentasJDBCCSV {

    public static void main(String[] args)
            throws ClassNotFoundException, IOException, SQLException, ParseException {

        // 1) Cargar driver y leer credenciales
        Class.forName("com.mysql.cj.jdbc.Driver");
        String ruta = "src/modeloExamenOrdinariaJDBC/CNF.INIT";  
        BufferedReader bfr = new BufferedReader(new FileReader(new File(ruta)));
        String user = bfr.readLine();
        String pass = bfr.readLine();
        String url  = bfr.readLine();
        bfr.close();

        // 2) Conectar
        Connection cn = DriverManager.getConnection(url, user, pass);
        System.out.println("conexión ok");

        // 3) Menú
        boolean salir = false;
        do {
            System.out.println("\nElige una opción:");
            System.out.println("1 Insertar");
            System.out.println("2 Listar");
            System.out.println("3 Actualizar cantidad por ID");
            System.out.println("4 Eliminar por ID");
            System.out.println("5 Exportar a ventas.csv");
            System.out.println("0 Salir");
            String dato = Entrada.cadena();

            if (dato.equalsIgnoreCase("salir") || dato.equals("0")) {
                System.out.println("saliendo");
                salir = true;

            } else if (!dato.matches("[0-9]+")) {
                System.out.println("opción no válida");

            } else {
                int opcion = Integer.parseInt(dato);
                switch (opcion) {
                    case 1:
                        // INSERT sin pedir ID, ya que es AUTO_INCREMENT
                        System.out.print("producto: ");
                        String producto = Entrada.cadena();
                        System.out.print("cantidad: ");
                        int cantidad = Entrada.entero();
                        System.out.print("fecha (dd/MM/yyyy): ");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        sdf.setLenient(false);
                        Date fecha = sdf.parse( Entrada.cadena() );
                        insertar(cn, producto, cantidad, fecha);
                        System.out.println("insertado OK");
                        break;

                    case 2:
                        listar(cn);
                        System.out.println("mostrados OK");
                        break;

                    case 3:
                        System.out.print("id: ");
                        int idAct = Entrada.entero();
                        if (!validarExiste(cn, idAct)) {
                            System.out.println("no existe ese id");
                        } else {
                            System.out.print("nueva cantidad: ");
                            int nuevaCant = Entrada.entero();
                            actualizar(cn, nuevaCant, idAct);
                            System.out.println("actualizado OK");
                        }
                        break;

                    case 4:
                        System.out.print("id: ");
                        int idDel = Entrada.entero();
                        if (!validarExiste(cn, idDel)) {
                            System.out.println("no existe ese id");
                        } else {
                            eliminar(cn, idDel);
                            System.out.println("eliminación OK");
                        }
                        break;

                    case 5:
                        exportarCSV(cn);
                        System.out.println("exportado OK");
                        break;

                    default:
                        System.out.println("no es una opción válida");
                }
            }
        } while (!salir);

        // 4) Cerrar conexión
        cn.close();
    }

    /** Inserta registro sin pasar ID (auto-increment) */
    private static void insertar(Connection cn, String producto, int cantidad, Date fecha)
            throws SQLException {
        String sql = "INSERT INTO ventas(producto, cantidad, fecha) VALUES (?,?,?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, producto);
        pst.setInt(2, cantidad);
        pst.setDate(3, new java.sql.Date(fecha.getTime()));
        pst.executeUpdate();
        pst.close();
    }

    /** Lista todo */
    private static void listar(Connection cn) throws SQLException {
        String sql = "SELECT * FROM ventas";
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (rs.next()) {
            int    id       = rs.getInt("id");
            String prod     = rs.getString("producto");
            int    cant     = rs.getInt("cantidad");
            Date   fecha    = rs.getDate("fecha");
            System.out.println(id + " -- " + prod + " -- " + cant + " -- " + sdf.format(fecha));
        }
        rs.close();
        pst.close();
    }

    /** Actualiza cantidad para ID dado */
    private static void actualizar(Connection cn, int cantidad, int id) throws SQLException {
        String sql = "UPDATE ventas SET cantidad=? WHERE id=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, cantidad);
        pst.setInt(2, id);
        pst.executeUpdate();
        pst.close();
    }

    /** Elimina registro por ID */
    private static void eliminar(Connection cn, int id) throws SQLException {
        String sql = "DELETE FROM ventas WHERE id=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
    }

    /** Exporta todo a CSV */
    private static void exportarCSV(Connection cn) throws SQLException, IOException {
        String sql = "SELECT * FROM ventas";
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        PrintWriter pw = new PrintWriter(new FileWriter("ventas.csv"), true);
        // cabecera
        pw.println("id,producto,cantidad,fecha");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (rs.next()) {
            int    id    = rs.getInt("id");
            String prod  = rs.getString("producto");
            int    cant  = rs.getInt("cantidad");
            Date   fecha = rs.getDate("fecha");
            pw.println(id + "," + prod + "," + cant + "," + sdf.format(fecha));
        }
        rs.close();
        pst.close();
        pw.close();
    }

    /** Comprueba existencia de ID */
    private static boolean validarExiste(Connection cn, int id) throws SQLException {
        String sql = "SELECT 1 FROM ventas WHERE id=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        boolean existe = rs.next();
        rs.close();
        pst.close();
        return existe;
    }
}
