package ejercicios3;

import java.util.*;

public class Extra2_SetUnicidad {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("Java"); // no se repite
        System.out.println("Tamaño: " + conjunto.size());
        System.out.println("Contiene Java? " + conjunto.contains("Java"));
    }
}