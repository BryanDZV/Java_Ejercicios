package ordenacion;

import java.util.Comparator;

public class OrdenacionPorPesoDesc implements Comparator<Articulo> {

    @Override
    public int compare(Articulo o1, Articulo o2) {
        if (o1.getPeso() > o2.getPeso()) {
            return -1; // Primero los de mayor peso
        } else if (o1.getPeso() < o2.getPeso()) {
            return 1;
        }
        return 0;
    }
}
