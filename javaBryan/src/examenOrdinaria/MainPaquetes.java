package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class MainPaquetes {
    public static void main(String[] args) {
        List<Integer> lsimple = new ArrayList<>();
        System.out.println("Introduce números positivos en orden creciente ('fin' para terminar)");
        String dato = Entrada.cadena();

        while (!dato.equalsIgnoreCase("fin")) {
            int pk = -1;
            boolean parsed = true;
            try {
                pk = Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número o 'fin'.");
                parsed = false;
            }

            if (parsed) {
                if (pk < 0) {
                    System.out.println("Solo números positivos.");
                } else if (!lsimple.isEmpty() && pk < lsimple.get(lsimple.size() - 1)) {
                    System.out.println("El número " + pk + " debe ser mayor que " + lsimple.get(lsimple.size() - 1));
                } else {
                    lsimple.add(pk);
                }
            }

            System.out.println("Introduce números positivos en orden creciente ('fin' para terminar)");
            dato = Entrada.cadena();
        }

        // Si hay menos de dos puntos, no hay tramos
        if (lsimple.size() < 2) {
            System.out.println("No hay tramos");
            return;
        }

        List<Paquetes> lpaquetes = new ArrayList<>();
        // Creamos objetos Paquetes para cada par consecutivo
        for (int i = 0; i < lsimple.size() - 1; i++) {
            lpaquetes.add(new Paquetes(lsimple.get(i), lsimple.get(i + 1)));
        }

        System.out.println("Ordenado de menor a mayor por intervalo:");
        lpaquetes.sort(null);

        int cnt = 0;
        for (Paquetes paquetes : lpaquetes) {
            System.out.println("pk" + cnt + "/" + paquetes.getCodigo1() + "---" + paquetes.getCodigo2() + "/ intervalo="
                    + paquetes.getIntervalo());
            cnt++;
        }
    }
}
