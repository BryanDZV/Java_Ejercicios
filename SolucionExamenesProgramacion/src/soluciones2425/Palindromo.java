package soluciones2425;

public class Palindromo {
    public static void main(String[] args) {
        String palabra = "Rotor";
        String p = palabra.toUpperCase();
        boolean esPal = true;
        
        int len = p.length();
        // Sólo hace falta recorrer hasta la mitad
        for (int i = 0; i < len; i++) {
            if (p.charAt(i) != p.charAt(len - 1 - i)) {
                esPal = false;
            }
        }
        
        if (esPal) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
    }
}

