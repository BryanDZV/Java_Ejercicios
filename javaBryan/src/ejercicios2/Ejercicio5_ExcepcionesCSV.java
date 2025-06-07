package ejercicios2;

import java.io.*;

public class Ejercicio5_ExcepcionesCSV {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("personas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                try {
                    int edad = Integer.parseInt(partes[1]);
                    System.out.println(nombre + " tiene " + edad + " años.");
                } catch (NumberFormatException e) {
                    System.out.println("Edad no válida para: " + nombre);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}