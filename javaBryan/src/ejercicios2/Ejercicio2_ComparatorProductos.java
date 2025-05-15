package ejercicios2;

import java.util.*;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString() {
        return nombre + " - " + precio + "€";
    }
}

public class Ejercicio2_ComparatorProductos {
    public static void main(String[] args) {
        Set<Producto> set = new HashSet<>();
        set.add(new Producto("Teclado", 25.5));
        set.add(new Producto("Ratón", 15.0));
        set.add(new Producto("Monitor", 150.0));

        List<Producto> lista = new ArrayList<>(set);
        lista.sort((a, b) -> Double.compare(b.precio, a.precio));

        for (Producto p : lista) {
            System.out.println(p);
        }
    }
}