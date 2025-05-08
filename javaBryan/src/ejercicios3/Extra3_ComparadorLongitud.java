package ejercicios3;

import java.util.*;

public class Extra3_ComparadorLongitud {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("hola", "programación", "sol");
        palabras.sort((a, b) -> Integer.compare(a.length(), b.length()));
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}