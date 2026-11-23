package laboratorio;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Introduce secuencia genética:");
            String entrada = Entrada.cadena();

            Laboratorio l = new Laboratorio(entrada);
            System.out.println(l);
            System.out.println("Caracteres válidos: " + l.contarCaracteresValidos());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
