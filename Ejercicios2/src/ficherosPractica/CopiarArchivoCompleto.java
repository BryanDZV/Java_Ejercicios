package ficherosPractica;

import javax.swing.JFileChooser;
import java.io.*;

public class CopiarArchivoCompleto {

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();

        // Paso 1: Seleccionar archivo origen para leer
        fc.setDialogTitle("Selecciona el archivo para copiar");
        int opcion1 = fc.showOpenDialog(null);

        if (opcion1 == JFileChooser.APPROVE_OPTION) {
            File archivoOrigen = fc.getSelectedFile();

            // Mostrar contenido en consola
            try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen))) {
                String linea;
                System.out.println("Contenido del archivo:");
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return;
            }

            // Paso 2: Seleccionar dónde guardar la copia
            fc.setDialogTitle("Selecciona dónde guardar la copia");
            int opcion2 = fc.showSaveDialog(null);

            if (opcion2 == JFileChooser.APPROVE_OPTION) {
                File archivoDestino = fc.getSelectedFile();

                // Copiar contenido
                try (
                    BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
                    PrintWriter pw = new PrintWriter(archivoDestino)
                ) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        pw.println(linea);
                    }
                    System.out.println("Archivo copiado correctamente.");
                } catch (IOException e) {
                    System.out.println("Error al guardar la copia: " + e.getMessage());
                }
            } else {
                System.out.println("Guardado cancelado.");
            }

        } else {
            System.out.println("Lectura cancelada.");
        }
    }
}
