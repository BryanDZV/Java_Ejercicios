package ordenacion;

import java.util.Comparator;

public class OrdenacionPorDenominacionYPrecioDesc implements Comparator<Articulo> {

    // Método para ordenar
    /*
     * Retorna un número negativo (this < otro) → Este objeto es menor.
     * Retorna 0 (this == otro) → Son iguales.
     * Retorna un número positivo (this > otro) → Este objeto es mayor.
     */
    @Override
    public int compare(Articulo o1, Articulo o2) {
        // Comparación por denominación alfabéticamente
        int comparacionNombre = o1.getDenominacion().compareTo(o2.getDenominacion());

        if (comparacionNombre == 0) { // Si tienen el mismo nombre
            if (o2.getPvp() > o1.getPvp()) { 
                return 1; // Primero el más caro (orden descendente, invertimos para que el más caro esté primero)
            } else if (o2.getPvp() < o1.getPvp()) { 
                return -1;  // Luego el más barato
            }
            return 0; // Si tienen el mismo precio, no cambia el orden
        }

        return comparacionNombre; // Ordenación alfabética por denominación
    }
}
