package ejercicios;

import java.util.Scanner;

import utilidades.Entrada;

public class Ejercicio3 {

    /**
     * Comprueba si una hora en formato HH:MM:SS es válida.
     *
     * @param hora La cadena que representa la hora.
     * @return true si es una hora válida, false en caso contrario.
     */
    public static boolean esHoraCorrecta(String hora) {
        // Validar longitud y formato básico
        if (hora.length() != 8 || hora.charAt(2) != ':' || hora.charAt(5) != ':') {
            return false;
        }

        // Validar que todos los caracteres relevantes son dígitos
        for (int i = 0; i < hora.length(); i++) {
            if (i != 2 && i != 5 && !Character.isDigit(hora.charAt(i))) {
                return false;
            }
        }

        // Extraer las partes de la hora
        int hh = Integer.parseInt(hora.substring(0, 2));
        int mm = Integer.parseInt(hora.substring(3, 5));
        int ss = Integer.parseInt(hora.substring(6, 8));

        // Comprobar los rangos
        return (hh >= 0 && hh <= 23) && (mm >= 0 && mm <= 59) && (ss >= 0 && ss <= 59);
    }

    /**
     * Compara dos horas en formato HH:MM:SS.
     *
     * @param h1 La primera hora.
     * @param h2 La segunda hora.
     * @return 1 si h1 > h2, 0 si h1 == h2, -1 si h1 < h2, 9999 si alguna hora es incorrecta.
     */
    public static int compararHoras(String h1, String h2) {
        if (!esHoraCorrecta(h1) || !esHoraCorrecta(h2)) {
            return 9999;
        }

        int t1 = Integer.parseInt(h1.substring(0, 2)) * 3600
               + Integer.parseInt(h1.substring(3, 5)) * 60
               + Integer.parseInt(h1.substring(6, 8));

        int t2 = Integer.parseInt(h2.substring(0, 2)) * 3600
               + Integer.parseInt(h2.substring(3, 5)) * 60
               + Integer.parseInt(h2.substring(6, 8));

        if (t1 > t2) {
            return 1;
        } else if (t1 == t2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca hora: ");
        String h1 = Entrada.cadena();

        System.out.print("Introduzca hora: ");
        String h2 = Entrada.cadena();

        if (!esHoraCorrecta(h1)) {
            System.out.println(h1 + " es incorrecta!!");
        } else if (!esHoraCorrecta(h2)) {
            System.out.println(h2 + " es incorrecta!!");
        } else {
            int comparacion = compararHoras(h1, h2);

            if (comparacion == 9999) {
                System.out.println("Error en la comparación de horas.");
            } else if (comparacion > 0) {
                System.out.println(h2 + " " + h1);
            } else {
                System.out.println(h1 + " " + h2);
            }
        }

    }
}

