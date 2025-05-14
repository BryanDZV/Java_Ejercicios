package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class MainTramos {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        // Lee y valida el primer número
        System.out.println("Introduce el primer número mayor o igual a 0:");
        int anterior;
        while (true) {
            String dato = Entrada.cadena();
            try {
                anterior = Integer.parseInt(dato);
                if (anterior < 0) {
                    System.out.println("Debe ser mayor o igual a 0. Intenta de nuevo:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número o 'fin'.");
            }
        }
        l.add(anterior);

        // Lee siguientes números en orden creciente o 'fin'
        while (true) {
            System.out.println("Introduce un número mayor que " + anterior + " o 'fin':");
            String dato = Entrada.cadena();

            if (dato.equalsIgnoreCase("fin")) {
                break;
            }

            int nuevo = -1;
            boolean parsed = true;
            try {
                nuevo = Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número o 'fin'.");
                parsed = false;
            }

            if (parsed) {
                if (nuevo < 0) {
                    System.out.println("Debe ser mayor o igual a 0.");
                } else if (nuevo > anterior) {
                    l.add(nuevo);
                    anterior = nuevo;
                } else {
                    System.out.println("Debe ser mayor que el anterior.");
                }
            }
        }

        // Si hay menos de dos puntos, no hay tramos
        if (l.size() < 2) {
            System.out.println("No hay tramos");
            return;
        }

        // Crea lista de tramos
        List<Tramos> lTramos = new ArrayList<>();
        for (int i = 0; i < l.size() - 1; i++) {
            int inicio = l.get(i);
            int fin = l.get(i + 1);
            lTramos.add(new Tramos(inicio, fin));
        }

        // Muestra tramos sin ordenar
        System.out.println("Tramos generados:");
        int cnt = 0;
        for (Tramos t : lTramos) {
            System.out.println("pk" + cnt + " " + t.getPunto1() + " : " + t.getPunto2());
            cnt++;
        }

        // Ordena ascendente
        System.out.println("ORDENADO POR TRAMOS ASCENDENTE:");
        lTramos.sort(null);
        cnt=0;
        for (Tramos tramos : lTramos) {
			System.out.println("pk"+cnt+" "+tramos.getPunto1()+"--"+tramos.getPunto2()+"--->"+tramos.getDistancia());
			cnt++;
		}
       

        // Ordena descendente
        System.out.println("ORDENADO POR TRAMOS DESCENDENTE:");
        lTramos.sort(new ordenDescendete());
        cnt=0;
        for (Tramos tramos : lTramos) {
			System.out.println("pk"+cnt+" "+tramos.getPunto1()+"--"+tramos.getPunto2()+"--->"+tramos.getDistancia());
			cnt++;
		}
    }
}

