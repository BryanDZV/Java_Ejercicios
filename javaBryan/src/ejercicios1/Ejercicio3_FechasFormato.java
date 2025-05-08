package ejercicios1;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ejercicio3_FechasFormato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una fecha (dd/MM/yyyy): ");
        String input = sc.nextLine();

        try {
            SimpleDateFormat entrada = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = entrada.parse(input);

            SimpleDateFormat salida = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
            System.out.println("Fecha formateada: " + salida.format(fecha));
        } catch (Exception e) {
            System.out.println("Fecha inválida.");
        }
    }
}